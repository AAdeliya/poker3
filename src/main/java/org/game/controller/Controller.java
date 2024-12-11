package org.game.controller;
import org.game.model.Card;
import org.game.model.Deck;
import org.game.model.PokerGame;
import org.game.view.View;
import org.game.model.Player;
import java.util.ArrayList;
import java.util.List;

public class Controller {
        private final Deck deck;
        private final Player player1;
        private final Player player2;
        private final List<Card> communityCards;
        private final View view;

        public Controller() {
            deck = new Deck();
            deck.shuffle();

            player1 = new Player("Player 1");
            player2 = new Player("Player 2");
            communityCards = new ArrayList<>();
            view = new View();
        }

        public void startGame() {

            for (int i = 0; i < 2; i++) {
                player1.addCardToHand(deck.dealCard());
                player2.addCardToHand(deck.dealCard());
            }

            for (int i = 0; i < 5; i++) {
                communityCards.add(deck.dealCard());
            }


            view.displayPlayerHand(player1);
            view.displayPlayerHand(player2);
            view.displayCommunityCards(communityCards);

            // Determine the winner
            determineWinner();
        }

        public  String determineWinner() {
        PokerGame pokerGame = new PokerGame();
        String winner = pokerGame.determineWinner(
                combinePlayerAndCommunityCards(player1.getHand(), communityCards),
                combinePlayerAndCommunityCards(player2.getHand(), communityCards));
        view.displayMessage(winner);
            return winner;
        }

    private List<Card> combinePlayerAndCommunityCards(List<Card> playerHand, List<Card> communityCards) {
        List<Card> combined = new ArrayList<>(playerHand);
        combined.addAll(communityCards);
        return combined;
    }


    public List<Card> getCommunityCards() {
        return communityCards;
    }
}
