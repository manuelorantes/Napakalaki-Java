
package NapakalakiGame;

import GUI.Dice;
import GUI.NapakalakiView;

public class EjemploMain {

    public static void main(String[] args) {
      Napakalaki game = Napakalaki.getInstance();
      NapakalakiView napakalakiView = new NapakalakiView();
      
      Dice.createInstance(napakalakiView);
      napakalakiView.setNapakalaki(game);
      napakalakiView.setVisible (true);
    }
}
