package upmc.pcg.game;

import java.util.*;

public class Game {

    public Game() {
    }

    public ArrayList<Player> initialize(ArrayList<String> players_name) {
        ArrayList<Player> player = new ArrayList<Player>();
        for (String name : players_name) {
            player.add(new Player(name));
        }
        return player;
    }

    public void play(ArrayList<Player> player) {
        Deck pack = new Deck();
        Player gamer = player.get(0);
        gamer.setDeck(pack);
        Menu menu = new Menu(gamer);
        menu.Start();
//        new UIMenu().setVisible(true);
    }
}
