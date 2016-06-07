/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.ArrayList;
import GUI.Dice;


/**
 *
 * @author manuel
 */
public class Player {
    static final int MAXLEVEL = 10;
    
    protected String name;
    protected int level;
    private boolean dead = true;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private BadConsequence pendingBadConsequence;
    
    //Constructors
    public Player(String name){
      this.name = name;
      this.level = 1;
      visibleTreasures = new ArrayList();
    }
    
    public Player(Player p){
        this.name = p.getName();
        this.level = p.getLevels();
        this.dead = p.isDead();
        this.visibleTreasures = p.getVisibleTreasures();
        this.hiddenTreasures = p.getHiddenTreasures();
        this.pendingBadConsequence = p.pendingBadConsequence;
    }
    
    //Setters
    public void setName(String name){
        this.name = name;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
       pendingBadConsequence = b;
    }       
    
    //Getters
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
          
    public String getName(){
        return name;
    }  
    
    public int getLevels(){
        return level;
            
    }
    
    //Other methods
    private void bringToLife(){
       dead = false;
    }
    
    private void incrementLevels(int l){
        if(level + l <= 10)
            level += l;
        else
            level = 10;
    }
    
    private void decrementLevels(int l){
        if(level - l >= 1)
            level -= l;
        else
            level = 1;
            dead = true;
    }
    
    protected int getOponentLevel(Monster m){
        return m.GetCombatLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dado = Dice.getInstance();
        int numero;
        numero = dado.nextNumber("A pesar de haber perdido","Si sacas un 6 te conviertes en sectario");
        return (numero == 6);
    }
    
    public int getCombatLevel(){
            
        int nivel = 0;
        
        for(Treasure i: visibleTreasures){
            nivel += i.getBonus();
        }
        nivel += level;
        
        return nivel;
    }  
    
    private void applyPrize(Monster m){
        int nLevels = m.getLevelGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        
        if(nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            for (int i = 1; i <= nTreasures; i++){
                Treasure tesoro = dealer.nextTreasure();
                hiddenTreasures.add(tesoro);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.GetBadConsequence();
        int nLeves = badConsequence.getLevels();
        decrementLevels(nLeves);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        //Trato diferente los casos de las manos y el resto
       
        if(t.getType() != TreasureKind.ONEHAND && t.getType() != TreasureKind.BOTHHANDS){
            for(Treasure m: visibleTreasures){
                if(t.getType() == m.getType())
                    return false;
            }
            return true;
        }
        
        //Caso de las manos
    
        int manos_ocupadas = 0;
        for(Treasure m: visibleTreasures){
            if(TreasureKind.ONEHAND == m.getType())
                manos_ocupadas++;
            if(TreasureKind.BOTHHANDS == m.getType())
                return false;
        }
        if (t.getType() == TreasureKind.ONEHAND){
            return (manos_ocupadas <= 1);
        }
        return (manos_ocupadas == 0);
         
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int tantos = 0;
        for(Treasure i: visibleTreasures){
            if(i.getType() == tKind)
            tantos++;
        }
        return tantos;
    }
    
    private void dieIfNoTreasures(){
        if(visibleTreasures == null && hiddenTreasures == null)
            dead = true;
    }   
 
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;    
    }    
    
    
    public CombatResult combat(Monster m){
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m); 
        CombatResult resultado;
        
        if(myLevel > monsterLevel){
            applyPrize(m);
            if( getLevels() >= MAXLEVEL)
                resultado = CombatResult.WINGAME;
            else
                resultado = CombatResult.WIN;
        }
        else{
            applyBadConsequence(m);
            if(shouldConvert())
                resultado = CombatResult.LOSEANDCONVERT;
            else
                resultado = CombatResult.LOSE;
        }
        return resultado;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI = canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
        
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        CardDealer.getInstance().giveTreasureBack(t);
        
        if((pendingBadConsequence) != null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        dieIfNoTreasures();
        
    }

    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        CardDealer.getInstance().giveTreasureBack(t);
        
        if((pendingBadConsequence) != null && !pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        dieIfNoTreasures();
        
    }
    
    public boolean validState(){
        int t_ocultos;
        t_ocultos = hiddenTreasures.size();
        if( (pendingBadConsequence == null || pendingBadConsequence.isEmpty()) && t_ocultos <= 4)
            return true;
        return false;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures = new ArrayList();
        
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber("si sacas...    1 -> 1 tesoro", "2,3,4,5 -> 2 tesoros     6 -> 3 tesoros");
        
        if(number > 1){    
        Treasure treasure2 = dealer.nextTreasure();
        hiddenTreasures.add(treasure2);
        }
        if(number == 6){    
        Treasure treasure3 = dealer.nextTreasure();
        hiddenTreasures.add(treasure3);
        }
        
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> copia_visibles = new ArrayList(visibleTreasures); 
        ArrayList<Treasure> copia_hidden = new ArrayList(hiddenTreasures);
        for(Treasure t: copia_visibles)
            discardVisibleTreasure(t);
        for(Treasure t: copia_hidden)
            discardHiddenTreasure(t);        
    }
    
    @Override
    public String toString(){
        return name + "\tLevel: "+ level +"\tCombatLevel: " + getCombatLevel();
    }
    
    
    
    
    
    
}
