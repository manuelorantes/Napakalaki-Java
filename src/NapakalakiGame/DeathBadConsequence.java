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
public class DeathBadConsequence extends NumericBadConsequence{
    
    public DeathBadConsequence(String text){
        super(text, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
    }
    
    @Override
    public String toString(){
        return "\n\tText= " + text;
    }
}
