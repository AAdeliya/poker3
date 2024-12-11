package poker52upTo10players.view;

import poker52upTo10players.model.Card;
import poker52upTo10players.model.Player;
import java.util.List;

public class View {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayPlayerHand(Player player) {
        System.out.println(player);
    }

    public void displayCommunityCards(List<Card> communityCards) {
        System.out.println(STR."Community Cards: \{communityCards}");
    }
}
