package org.game.view;

import org.game.model.Card;
import org.game.model.Player;

import java.util.List;

public class View {

    public void displayMessage(String message) {
        System.out.println(message);
    }
    public void displayPlayerHand(Player player) {
        System.out.println(STR."\{player.getName()}'s hand: \{player.getHand()}");
    }

    public void displayCommunityCards(List<Card> communityCards) {
        System.out.println(STR."Community Cards: \{communityCards}");
    }

}

