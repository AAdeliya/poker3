package poker52upTo10players.model;

import java.util.List;

public class PokerHandEvaluator {
    public HandRank evaluateHand(List<Card> hand) {
        if (isRoyalFlush(hand)) return HandRank.ROYAL_FLUSH;
        if (isStraightFlush(hand)) return HandRank.STRAIGHT_FLUSH;
        if (isFourOfAKind(hand)) return HandRank.FOUR_OF_A_KIND;
        if (isFullHouse(hand)) return HandRank.FULL_HOUSE;
        if (isFlush(hand)) return HandRank.FLUSH;
        if (isStraight(hand)) return HandRank.STRAIGHT;
        if (isThreeOfAKind(hand)) return HandRank.THREE_OF_A_KIND;
        if (isTwoPair(hand)) return HandRank.TWO_PAIR;
        if (isOnePair(hand)) return HandRank.ONE_PAIR;
        return HandRank.HIGH_CARD;
    }

    private boolean isRoyalFlush(List<Card> hand) {
    // Check if hand is a Royal Flush
    return false;
}

private boolean isStraightFlush(List<Card> hand) {
    // Check if hand is a Straight Flush
    return false;
}

private boolean isFourOfAKind(List<Card> hand) {
    // Check if hand has Four of a Kind
    return false;
}

private boolean isFullHouse(List<Card> hand) {
    // Check if hand is a Full House
    return false;
}

private boolean isFlush(List<Card> hand) {
    // Check if hand is a Flush
    return false;
}

private boolean isStraight(List<Card> hand) {
    // Check if hand is a Straight
    return false;
}

private boolean isThreeOfAKind(List<Card> hand) {
    // Check if hand has Three of a Kind
    return false;
}

private boolean isTwoPair(List<Card> hand) {
    // Check if hand has Two Pair
    return false;
}

private boolean isOnePair(List<Card> hand) {
    // Check if hand has One Pair
    return false;
}
}
