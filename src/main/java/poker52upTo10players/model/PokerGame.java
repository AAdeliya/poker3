
package poker52upTo10players.model;
import java.util.ArrayList;
import java.util.List;


public class PokerGame {
    public Player determineWinner(List<Player> players, List<Card> communityCards) {
        Player winner = null;
        HandRank bestRank = null;


        PokerHandEvaluator evaluator = new PokerHandEvaluator();


        for (Player player : players) {
            List<Card> combinedHand = combinePlayerAndCommunityCards(player.getHand(), communityCards);
            HandRank rank = evaluator.evaluateHand(combinedHand);


            if (bestRank == null || rank.ordinal() < bestRank.ordinal()) {
                bestRank = rank;
                winner = player;
            }
        }


        return winner;
    }


    private List<Card> combinePlayerAndCommunityCards(List<Card> playerHand, List<Card> communityCards) {
        List<Card> combined = new ArrayList<>(playerHand);
        combined.addAll(communityCards);
        return combined;
    }
}


