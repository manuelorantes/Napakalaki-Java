
package NapakalakiGame;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();

        Dice.createInstance(napakalakiView);
        napakalakiView.setNapakalaki(game);

        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);

        names = namesCapture.getNames();

        game.initGame(names);

        napakalakiView.setVisible (true);

    }
}
