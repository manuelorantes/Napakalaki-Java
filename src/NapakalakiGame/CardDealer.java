/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author manuel
 */
public class CardDealer {
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultist = new ArrayList();
    
    private CardDealer(){
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    private void initTreasureCardDeck(){
      
      unusedTreasures.add(new Treasure("¡Si mi amo!", 4,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Fez alopodo", 3,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Casco minero", 2,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Necrotelecom", 2,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Tentaculo de pega", 2,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Porra preternatural", 1,TreasureKind.HELMET));
      unusedTreasures.add(new Treasure("Zapato deja-amigos", 1,TreasureKind.SHOES));
      unusedTreasures.add(new Treasure("Botas de lluvia acida", 1,TreasureKind.SHOES));
      unusedTreasures.add(new Treasure("Botas de investigacion", 3,TreasureKind.SHOES));
      unusedTreasures.add(new Treasure("A prueba de babas", 2,TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("La rebeca metalica", 2,TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Camiseta de la UGR", 1,TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("El aparato de Pr. Tesla", 4,TreasureKind.ARMOR));
      unusedTreasures.add(new Treasure("Insecticida ", 2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Necro-comicon", 1,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Necro-gnomicon", 2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Necro-playboycon", 3,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Garabato mistico", 2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Hacha prehistorica", 2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Mazo de los antiguos", 3,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Varita de atizamiento", 3,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3,TreasureKind.ONEHAND));
      unusedTreasures.add(new Treasure("Gaita", 4,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Shogulador", 1,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Lanzallamas", 4,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Necronomicon", 5,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Linterna a dos manos", 3,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4,TreasureKind.BOTHHANDS));
      unusedTreasures.add(new Treasure("Ametralladora Thompson", 4,TreasureKind.BOTHHANDS));
    
    }
    
    private void initCultistCardDeck(){
        unusedCultist.add(new Cultist("Agaricus", 1));
        unusedCultist.add(new Cultist("Boletus", 2));
        unusedCultist.add(new Cultist("Daldinia", 1));
        unusedCultist.add(new Cultist("Bolbitius", 2));
        unusedCultist.add(new Cultist("Calvatia", 1));
        unusedCultist.add(new Cultist("Dermoloma", 1));
    }

    private void initMonsterCardDeck(){
        
        //Meto los monstruos
        
        //El rey de rosa
        BadConsequence badConsequence1 = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        Prize prize1 = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence1, prize1));
        
        //Byakhees de bonanza
        BadConsequence badConsequence2 = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize2 = new Prize(2,1);
        unusedMonsters.add(new Monster("Byakhees de bonanza", 8, badConsequence2, prize2));
        
        //Chibithulhu
        BadConsequence badConsequence3 = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        Prize prize3 = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence3, prize3));
        
        //El sopor de Dunwich
        BadConsequence badConsequence4 = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        Prize prize4 = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence4, prize4));
        
        //Ángeles de la noche ibicenca
        BadConsequence badConsequence5 = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize5 = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence5, prize5));
        
        //El gorrón en el umbral
        BadConsequence badConsequence6 = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0, 10, 0);
        Prize prize6 = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badConsequence6, prize6));
        
        //H.P. Munchcraft
        BadConsequence badConsequence7 = new SpecificBadConsequence("Pierdes la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        Prize prize7 = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence7, prize7));
        
        //Bichgooth                          
        BadConsequence badConsequence8 = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        Prize prize8 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence8, prize8));
        
        //La que redacta en las tinieblas
        BadConsequence badConsequence9 = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        Prize prize9 = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence9, prize9));
        
        //Los hondos
        BadConsequence badConsequence10 = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto");
        Prize prize10 = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence10, prize10));
        
        //Semillas Cthulhu
        BadConsequence badConsequence11 = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos..", 2, 0, 2);
        Prize prize11 = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence11, prize11));
        
        //Dameargo
        BadConsequence badConsequence12 = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible..", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        Prize prize12 = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence12, prize12));
        
        //Pollipólipo volante
        BadConsequence badConsequence13 = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        Prize prize13 = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence13, prize13));
        
        //Yskhtihyssg-Goth
        BadConsequence badConsequence14 = new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto");
        Prize prize14 = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence14, prize14));
        
        //Familia feliz
        BadConsequence badConsequence15 = new DeathBadConsequence("La familia te atrapa. Estás muerto.");
        Prize prize15 = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence15, prize15));
        
        //Roboggoth
        BadConsequence badConsequence16 = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        Prize prize16 = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence16, prize16));
        
        //El espia
        BadConsequence badConsequence17 = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible..", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        Prize prize17 = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence17, prize17));
        
        //El Lenguas
        BadConsequence badConsequence18 = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        Prize prize18 = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence18, prize18));
        
        //Bicéfalo
        BadConsequence badConsequence19 = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)), new ArrayList());
        Prize prize19 = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence19, prize19));
        
        
        //El mal indecible impronunciable
        BadConsequence badConsequence_cultist1 = new SpecificBadConsequence("Pierdes 1 mano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        Prize prize_cultist1 = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence_cultist1,prize_cultist1, -2));

        //Testigos Oculares
        BadConsequence badConsequence_cultist2 = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, 10, 0);
        Prize prize_cultist2 = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, badConsequence_cultist2, prize_cultist2, 2));

        //El gran cthulhu
        BadConsequence badConsequence_cultist3 = new DeathBadConsequence("Hoy no es tu dı́a de suerte. Mueres.");
        Prize prize_cultist3 = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence_cultist3, prize_cultist3, 4));

        //Serpiente Polı́tico
        BadConsequence badConsequence_cultist4 = new NumericBadConsequence("Tu gobierno te recorta 2 niveles.", 2, 0, 0);
        Prize prize_cultist4 = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Polı́tico", 8, badConsequence_cultist4, prize_cultist4, -2));

        //Felpuggoth
        BadConsequence badConsequence_cultist5 = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",
            0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), 
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS,TreasureKind.BOTHHANDS,TreasureKind.BOTHHANDS,TreasureKind.BOTHHANDS)));
        Prize prize_cultist5 = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence_cultist5, prize_cultist5, 5));


        //Lolitagooth
        BadConsequence badConsequence_cultist7 = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0);
        Prize prize_cultist7 = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence_cultist7, prize_cultist7, 3));

 
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);        
    }
    
    private void shuffleCultist(){
        Collections.shuffle(unusedCultist);
    }
    
    public Treasure nextTreasure(){
        if(unusedTreasures.isEmpty()){
            unusedTreasures = new ArrayList(usedTreasures);
            Collections.shuffle(unusedTreasures);
            usedTreasures.clear();
        }
        usedTreasures.add(unusedTreasures.get(0));
        return unusedTreasures.remove(0);
    }
    
    public Monster nextMonster(){
        if(unusedMonsters.isEmpty()){
            unusedMonsters = new ArrayList(usedMonsters);
            Collections.shuffle(unusedMonsters);
            usedMonsters.clear();
        }
        usedMonsters.add(unusedMonsters.get(0));        
        return unusedMonsters.remove(0);
            
    }
    public Cultist nextCultist(){
        return unusedCultist.remove(0);
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        initTreasureCardDeck();
        shuffleTreasures();
        initMonsterCardDeck();
        shuffleMonsters();
        initCultistCardDeck();
        shuffleCultist();
        
    }
}


















