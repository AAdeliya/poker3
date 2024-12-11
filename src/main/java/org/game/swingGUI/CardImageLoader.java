package org.game.swingGUI;


import org.game.model.Card;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
public class CardImageLoader {
    private static final Map<String, ImageIcon> cardImages = new HashMap<>();

    // Load images when the class is loaded
    static {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                String imageName = rank.name().toLowerCase() + "_of_" + suit.name().toLowerCase() + ".png";
                String imagePath = "/cards/" + imageName;
                cardImages.put(imageName, new ImageIcon(CardImageLoader.class.getResource(imagePath)));
            }
        }
    }

    public static ImageIcon getCardImage(Card card) {
        String imageName = card.getRank().name().toLowerCase() + "_of_" + card.getSuit().name().toLowerCase() + ".png";
        return cardImages.get(imageName);
    }
}
