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
public class CultistPlayer extends Player{
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }
    
    @Override
    protected int getCombatLevel(){
        return super.getCombatLevel()*(3/2) + totalCultistPlayers*myCultistCard.getGainedLevels();
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatlevelAgainCultistPlayer(this);
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
        
    public int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    @Override
    public String toString(){
        return "Sectario " + name + "\tLevel: "+ level +"\tCombatLevel: " + getCombatLevel();
    }
    
    
}
