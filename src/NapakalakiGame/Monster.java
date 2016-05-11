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
public class Monster {
    private String name;
    private int combatLevel;
    private Prize premio;
    private BadConsequence mal_rollo;
    private int levelChangeAgainCultistPlayer = 0;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize){
        this.name = name;
        this.combatLevel = level;
        this.premio = prize;
        this.mal_rollo = bc;
        this.levelChangeAgainCultistPlayer = 0;
    }
    
    public Monster(String name, int level, BadConsequence bc, Prize prize, int lC){
        this.name = name;
        this.combatLevel = level;
        this.premio = prize;
        this.mal_rollo = bc;
        this.levelChangeAgainCultistPlayer = lC;
    }
    
    public void SetName(String name){
        this.name = name;
    }
    
    public void SetLevel(int level){
        this.combatLevel = level;
    }
    
    public void SetPrize(Prize premio){
        this.premio = premio;
    }
    
    public void SetBadConsequence(BadConsequence mal_rollo){
        this.mal_rollo = mal_rollo;
    }
    
    public String GetName(){
        return name;
    }
    
    protected int GetCombatLevel(Player p){
        return combatLevel;
    }
    
    public int getLevelGained(){
        return premio.GetLevels();
    }
    
    public int getTreasuresGained(){
        return premio.GetTreasures();
    }
    
    protected int getCombatlevelAgainCultistPlayer(Player p){
        return combatLevel + this.levelChangeAgainCultistPlayer;
    }
    
    public BadConsequence GetBadConsequence(){
        return mal_rollo;
    }
    
    public Prize GetPrize(){
        return premio;
    }
    
    @Override
    public String toString(){
        return "Name ->  " + name + "\nLevel->  " + Integer.toString(combatLevel) + "\nLevel vs Cultist->  " + //Integer.toString(getCombatlevelAgainCultistPlayer()) +
                "\nPrize:  " + premio.toString() + "\n\nBadconsequence:  " + mal_rollo.toString();
    }
}
