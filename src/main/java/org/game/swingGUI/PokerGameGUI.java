package org.game.swingGUI;

import org.game.controller.Controller;
import org.game.model.Card;
import org.game.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;
public class PokerGameGUI {
    private JFrame frame;
    private JPanel playerPanel;
    private JPanel communityPanel;
    private JLabel winnerLabel;
    private JButton startButton;
    private Controller controller;

    public PokerGameGUI() {
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Poker Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Player Hands Panel
        playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(10, 1)); // Up to 10 players
        frame.add(new JScrollPane(playerPanel), BorderLayout.WEST);

        // Community Cards Panel
        communityPanel = new JPanel();
        communityPanel.setLayout(new FlowLayout());
        frame.add(communityPanel, BorderLayout.CENTER);

        // Winner Panel
        JPanel winnerPanel = new JPanel();
        winnerLabel = new JLabel("Press 'Start Game' to play!");
        winnerPanel.add(winnerLabel);
        frame.add(winnerPanel, BorderLayout.SOUTH);

        // Start Button
        startButton = new JButton("Start Game");
        startButton.addActionListener(e -> startGame());
        frame.add(startButton, BorderLayout.NORTH);
    }

    private void startGame() {
        int numPlayers = 4; // You can change this to 2-10
        controller = new Controller();
        controller.startGame();


        updateCommunityCards(controller.getCommunityCards());
        updateWinnerLabel(controller.determineWinner());
    }

    private void updatePlayerHands(Player player1, Player player2) {
        JPanel player1Panel = new JPanel(new FlowLayout());
        player1Panel.add(new JLabel(player1.getName()));
        for (Card card : player1.getHand()) {
            JLabel cardLabel = new JLabel(CardImageLoader.getCardImage(card));
            player1Panel.add(cardLabel);
        }

        JPanel player2Panel = new JPanel(new FlowLayout());
        player2Panel.add(new JLabel(player2.getName()));
        for (Card card : player2.getHand()) {
            JLabel cardLabel = new JLabel(CardImageLoader.getCardImage(card));
            player2Panel.add(cardLabel);
        }

        playerPanel.add(player1Panel);
        playerPanel.add(player2Panel);

        playerPanel.revalidate();
        playerPanel.repaint();
    }
    private void updateCommunityCards(List<Card> communityCards) {
        communityPanel.removeAll();

        for (Card card : communityCards) {
            JLabel cardLabel = new JLabel(CardImageLoader.getCardImage(card));
            communityPanel.add(cardLabel);
        }

        communityPanel.revalidate();
        communityPanel.repaint();
    }

    private void updateWinnerLabel(String winner) {
        winnerLabel.setText(winner);
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PokerGameGUI gui = new PokerGameGUI();
            gui.display();
        });
    }
}