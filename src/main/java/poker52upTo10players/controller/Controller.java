package poker52upTo10players.controller;

import poker52upTo10players.model.Card;
import poker52upTo10players.model.Deck;
import poker52upTo10players.model.Player;
import poker52upTo10players.model.PokerGame;
import poker52upTo10players.view.View;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Deck deck;
    private final List<Player> players;
    private final List<Card> communityCards;
    private final View view;

    public Controller(int numPlayers) {
        if (numPlayers > 10 || numPlayers < 2) {
            throw new IllegalArgumentException("Number of players must be between 2 and 10.");
        }

        deck = new Deck();
        deck.shuffle();

        players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player " + i));
        }

        communityCards = new ArrayList<>();
        view = new View();
    }

    public void startGame() {
        // Deal two cards to each player
        for (Player player : players) {
            for (int i = 0; i < 2; i++) {
                player.addCardToHand(deck.dealCard());
            }
        }

        // Deal five community cards
        for (int i = 0; i < 5; i++) {
            communityCards.add(deck.dealCard());
        }

        // Display player hands and community cards
        for (Player player : players) {
            view.displayPlayerHand(player);
        }
        view.displayCommunityCards(communityCards);

        // Determine the winner
        PokerGame pokerGame = new PokerGame();
        Player winner = pokerGame.determineWinner(players, communityCards);
        view.displayMessage(winner.getName() + " wins!");
    }
}

