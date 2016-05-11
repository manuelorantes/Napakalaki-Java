/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author manuel
 */
public class Dice {
    private static final Dice instance = new Dice();
    
    private Dice(){
        
    }
    
    public static Dice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        Random r = new Random();
        return  r.nextInt(5)+1;   
    }
}
