package org.game.model;


import java.util.Comparator;
import java.util.List;


public class PokerGame {
    public String determineWinner(List<Card> player1Hand, List<Card> player2Hand) {
        PokerHandEvaluator evaluator = new PokerHandEvaluator();


        HandRank player1Rank = evaluator.evaluateHand(player1Hand);
        HandRank player2Rank = evaluator.evaluateHand(player2Hand);


        if (player1Rank.ordinal() < player2Rank.ordinal()) {
            return "Player 1 wins!";
        } else if (player1Rank.ordinal() > player2Rank.ordinal()) {
            return "Player 2 wins!";
        } else {
            // Tie-breaking logic
            return compareHighCards(player1Hand, player2Hand);
        }
    }


    private String compareHighCards(List<Card> player1Hand, List<Card> player2Hand) {
        // Sort hands by rank in descending order
        player1Hand.sort(Comparator.comparing(Card::getRank).reversed());
        player2Hand.sort(Comparator.comparing(Card::getRank).reversed());


        for (int i = 0; i < Math.min(player1Hand.size(), player2Hand.size()); i++) {
            if (player1Hand.get(i).getRank().ordinal() > player2Hand.get(i).getRank().ordinal()) {
                return "Player 1 wins!";
            } else if (player1Hand.get(i).getRank().ordinal() < player2Hand.get(i).getRank().ordinal()) {
                return "Player 2 wins!";
            }
        }
        return "It's a tie!";
    }
}

