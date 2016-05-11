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
public class SpecificBadConsequence extends BadConsequence{
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(text, levels);
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
    }
    
    
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    
    @Override
    public boolean isEmpty(){
        return (specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty());
    }
    
    

    @Override      
    public void substractVisibleTreasure(Treasure t){
       ArrayList<TreasureKind> aux = new ArrayList(specificVisibleTreasures);
       if(specificVisibleTreasures != null)
       for(TreasureKind tipo: aux)
          if(tipo == t.getType())
              specificVisibleTreasures.remove(tipo);
    }    
    
        
    @Override
    public void substractHiddenTreasure(Treasure t){
       ArrayList<TreasureKind> aux = new ArrayList(specificHiddenTreasures);
       if(specificHiddenTreasures != null)
       for(TreasureKind tipo: aux)
           if(tipo == t.getType())
               specificHiddenTreasures.remove(tipo);                      
    }
    
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){

        ArrayList<TreasureKind> new_s_v = new ArrayList<TreasureKind>();
        ArrayList<TreasureKind> new_s_h = new ArrayList<TreasureKind>();

        ArrayList<TreasureKind> aux_visible = new ArrayList<>(specificVisibleTreasures);
        for(Treasure j :v){
          boolean esta = false;
          for (TreasureKind i : aux_visible){
            if (i == j.getType()){
              esta = true;
              i = null;
            }
          }
          if (esta)
            new_s_v.add(j.getType());
        }
        
        ArrayList<TreasureKind> aux_hidden = new ArrayList<>(specificHiddenTreasures);
        for (Treasure j : h){
          boolean esta = false;
          for (TreasureKind i : aux_hidden){
            if (i == j.getType()){
              esta = true;
              i = null;
            }
          }
          if (esta)
            new_s_h.add(j.getType());
        }
     
        SpecificBadConsequence bc = new SpecificBadConsequence(this.text, this.levels, new_s_v, new_s_h);
        return bc;
        
    }
    
             
    @Override
    public String toString(){
        return "\n\tText= " + text + "\n\tLevels = " + Integer.toString(levels) +
                "\n\tSpecific Visible Treasures" + specificVisibleTreasures +
                "\n\tSpecific Hidden Treasures" + specificHiddenTreasures;
    }
    
}
