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
public class NumericBadConsequence extends BadConsequence {
    
    
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence(String text, int levels, int nVisible, int nHidden){
        super(text, levels);
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
        
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
        
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    
    @Override
    public boolean isEmpty(){
        return ((nVisibleTreasures == 0 || nVisibleTreasures == -1) && (nHiddenTreasures == 0 || nHiddenTreasures == -1));
    }
    
    

    @Override      
    public void substractVisibleTreasure(Treasure t){
       if(nVisibleTreasures != 0 && nVisibleTreasures != -1)
           nVisibleTreasures--;
    }    
    
        
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures != 0 && nHiddenTreasures != -1)
            nHiddenTreasures--;
                  
    }
    
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){

        int new_v; 
        int new_h;

        if (v.size() < nVisibleTreasures)
          new_v = v.size();
        else
          new_v = nVisibleTreasures;

        if (h.size() < nHiddenTreasures)
          new_h = h.size();
        else
          new_h = nHiddenTreasures;
      
        
        NumericBadConsequence bc = new NumericBadConsequence(this.text, this.levels, new_v, new_h);
        return bc;
        
      }
    
             
    @Override
    public String toString(){
        return "\n\tText= " + text + "\n\tLevels = " + Integer.toString(levels) + "\n\tVisible treasures = " +
                Integer.toString(nVisibleTreasures) + "\n\tHidden treasures = " + Integer.toString(nHiddenTreasures);
    }
    
}
    

