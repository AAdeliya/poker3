package poker52upTo10players;

import poker52upTo10players.controller.Controller;

public class Main {
    public static void main(String[] args) {
        int numPlayers = 10; // Players between 2 and 10
        Controller controller = new Controller(numPlayers);
        controller.startGame();
    }
}
