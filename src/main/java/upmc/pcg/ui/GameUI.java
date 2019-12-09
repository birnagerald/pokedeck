package upmc.pcg.ui;

import java.util.*;
import upmc.pcg.game.Game;
import upmc.pcg.game.Player;

public class GameUI {

    private final Game game = new Game();

    private final Scanner console = new Scanner(System.in);

    public void start() {
        print_welcome_msg();
        ArrayList<String> names = ask_players_names();
        ArrayList<Player> player = game.initialize(names);
        game.play(player);
    }

    private ArrayList<String> ask_players_names() {
        System.out.println("What your name : \n");
        String Choice = console.nextLine();
        ArrayList<String> names = new ArrayList<String>();
        names.add(Choice);
        return names;
    }

    private void print_welcome_msg() {
    }
}
