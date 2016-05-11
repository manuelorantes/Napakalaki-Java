/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author manuel
 */
import java.util.ArrayList;
import java.util.Random;

public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private int currentPlayerIndex = -1;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private Monster currentMonster;
    private CardDealer dealer;
    
    private Napakalaki(){
        dealer = CardDealer.getInstance();
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    private void initPlayers(ArrayList<String> names){
        players = new ArrayList();
        for(String n: names){
            Player aux = new Player(n);
            players.add(aux);
        }
    }
    
    private Player nextPlayer(){
        if(currentPlayer == null){
            Random r = new Random();
            currentPlayerIndex = r.nextInt(players.size());
            currentPlayer = players.get(currentPlayerIndex);
        }
        else{
            currentPlayerIndex = (currentPlayerIndex+1)%players.size();
            currentPlayer = players.get(currentPlayerIndex);
        }
              
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed(){
        if(currentPlayer == null)
            return true;    
        
        return getCurrentPlayer().validState();
    }

    public CombatResult developCombat(){
        CombatResult resultado = currentPlayer.combat(currentMonster);
        CardDealer.getInstance().giveMonsterBack(currentMonster);
        if(resultado == CombatResult.LOSEANDCONVERT){
            Cultist cultor = dealer.nextCultist();
            CultistPlayer jugador = new CultistPlayer(currentPlayer , cultor);
            
            currentPlayer = jugador;
            players.set(currentPlayerIndex,jugador);
        }
        return resultado;
    }
        
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for( Treasure t: treasures){
            currentPlayer.discardVisibleTreasure(t);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for( Treasure t: treasures)
            currentPlayer.discardHiddenTreasure(t);
        
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure t: treasures){
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
        //return players.get(currentPlayerIndex);
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK = true;
        if(currentPlayer != null)
            stateOK = nextTurnAllowed();
  
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDead();
            
            if(dead){
                currentPlayer.initTreasures();
            }
            
        }
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    }
}
