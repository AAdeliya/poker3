package poker52upTo10players.model;
import java.util.ArrayList;
import java.util.List;

public class Player {
        private String name;
        private List<Card> hand;

        public Player(String name) {
            this.name = name;
            this.hand = new ArrayList<>();
        }

        public void addCardToHand(Card card) {
            hand.add(card);
        }

        public List<Card> getHand() {
            return hand;
        }

        public String getName() {
            return name;
        }

        public void clearHand() {
            hand.clear();
        }

        @Override
        public String toString() {
            return name + "'s hand: " + hand;
        }
    }
