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
public class Prize {
    private int treasures;
    private int level;
    
    public Prize(int treasures, int level){
        this.level = level;
        this.treasures = treasures;
    }
    
    public void SetLevels( int levels){
        this.level = levels;
    }
    
    public void SetTreasures( int treasures){
        this.treasures = treasures;
    }
    
    public int GetLevels(){
        return level;
    }
    
    public int GetTreasures(){
        return treasures;
    }
    
    @Override
    public String toString(){
        return "\n\tTreasures = " + Integer.toString(treasures) + "\n\tLevels = " + Integer.toString(level);
    }
    
}
