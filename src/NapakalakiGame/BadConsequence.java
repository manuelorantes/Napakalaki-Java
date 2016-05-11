/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

        import java.util.ArrayList;
/**
 *
 * @author manuel
 */
abstract public class BadConsequence {
    static final int MAXTREASURES = 10;
    
    protected String text;
    protected int levels;
    
    public BadConsequence(String name, int levels){
        this.text = name;
        this.levels = levels;
    }

       
    public int getLevels(){
        return levels;
    }
    
    public String getText(){
        return text;
    }
    abstract public boolean isEmpty();
    abstract public void substractVisibleTreasure(Treasure t);
    abstract public void substractHiddenTreasure(Treasure t);
    abstract public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h);

            
    @Override
    public String toString(){
        return "\n\tText= " + text + "\n\tLevels = " + Integer.toString(levels);
    }
}






