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
public class GoodMonster extends Monster{
    Player friend;
    
    public GoodMonster(String name, int level, BadConsequence bc, Prize prize, Player p){
        super(name, level, bc, prize);
        friend = p;
    }
    
    @Override
    protected int GetCombatLevel(Player p){
        if( p == friend)
            return 0;
        else
            return super.GetCombatLevel(p);
    }

    @Override
    protected int getCombatlevelAgainCultistPlayer(Player p){
        if( p == friend)
            return 0;
        else
            return super.getCombatlevelAgainCultistPlayer(p);
    }
        

}
