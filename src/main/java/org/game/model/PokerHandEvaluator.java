package org.game.model;

import java.util.List;

public class PokerHandEvaluator {
    public HandRank evaluateHand(List<Card> hand) {
        //each combination has a unique rank based on its position in the list
        if (isRoyalFlush(hand)) return HandRank.ROYAL_FLUSH;
        if (isStraightFlush(hand)) return HandRank.STRAIGHT_FLUSH;
        if (isFourOfAKind(hand)) return HandRank.FOUR_OF_A_KIND;
        if (isFullHouse(hand)) return HandRank.FULL_HOUSE;
        if (isFlush(hand)) return HandRank.FLUSH;
        if (isStraight(hand)) return HandRank.STRAIGHT;
        if (isThreeOfAKind(hand)) return HandRank.THREE_OF_A_KIND;
        if (isTwoPair(hand)) return HandRank.TWO_PAIR;
        if (isOnePair(hand)) return HandRank.ONE_PAIR;
        //stops whenever first true is emerged
        return HandRank.HIGH_CARD;
    }


private boolean isRoyalFlush(List<Card> hand) {
        //combines isFlush and isStraight and ensures the highest card is an ACE
    return isFlush(hand) && isStraight(hand) && hand.stream().
            anyMatch(card-> card.getRank() == Card.Rank.ACE);
}

private boolean isStraightFlush(List<Card> hand) {

    return false;
}

private boolean isFourOfAKind(List<Card> hand) {
    //count the occurrence of each rank in the end
    //check if any rank appears exactly 4 times
    int[] rankCount = new int[Card.Rank.values().length];

    for (Card card: hand) {
        rankCount[card.getRank().ordinal()]++;
    }

    for (int count : rankCount) {
        if (count == 4) {
            return true;
        }
    }

    return false;
}

private boolean isFullHouse(List<Card> hand) {
    // Check if  hand has  three cards of the one rank
    // two cards of another rank
    return false;
}

private boolean isFlush(List<Card> hand) {
    //check if all cards in the hand have the same suit
    if (hand.isEmpty()) return false;

    Card.Suit suit = hand.getFirst().getSuit();
    for (Card card: hand) {
        if (card.getSuit() != suit) {
            return false;
        }
    }
    return true;
}

private boolean isStraight(List<Card> hand) {
    // sort the hand by rank
    //check if each card is one rank higher than the previous
    if (hand.size() < 5) return false;

    //sort cards
    for (int i = 0; i < hand.size(); i++) {
        if (hand.get(i+1).getRank().ordinal() != hand.get(i).getRank().ordinal()) {
            return false;
        }
    }
    return true;
}

private boolean isThreeOfAKind(List<Card> hand) {
    // check whether a hand contains exactly three cards of the same rank
    return false;
}

private boolean isTwoPair(List<Card> hand) {
   //checks whether a hand contains two distinct pairs of cards with the same rank
    return false;
}

private boolean isOnePair(List<Card> hand) {
    // Check if hand has One Pair
    return false;
}

}
