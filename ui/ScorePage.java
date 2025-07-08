package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameState;

public class ScorePage extends JFrame {

    JLabel name1, name2, score1, score2, drawLabel;
    JButton playAgainBtn, QuitBtn;

    public ScorePage() {
        setTitle("Game Score");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        setLocationRelativeTo(null);

        // Player 1 labels
        name1 = new JLabel("Player 1: " + GameState.playerOneName);
        score1 = new JLabel("Wins: " + GameState.playerOneScore);

        // Player 2 labels
        name2 = new JLabel("Player 2: " + GameState.playerTwoName);
        score2 = new JLabel("Wins: " + GameState.playerTwoScore);

        // Draws
        drawLabel = new JLabel("Draws: " + GameState.draws);

        // Play Again Button
        playAgainBtn = new JButton("Play Again");
        playAgainBtn.setFont(new Font("Segoe UI", Font.BOLD, 10));
        playAgainBtn.setBackground(new Color(0x34ace0)); // Vibrant blue
        playAgainBtn.setForeground(Color.WHITE);
        playAgainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close score page
                new XandO(); // Restart game page
            }
        });
        // Quit button
        QuitBtn = new JButton("Quit");
        QuitBtn.setFont(new Font("Segoe UI", Font.BOLD, 10));
        QuitBtn.setBackground(new Color(0x34ace0)); // Vibrant blue
        QuitBtn.setForeground(Color.WHITE);
        QuitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exits the entire program
            }
        });

        // Add to Frame
        add(name1); add(score1);
        add(name2); add(score2);
        add(drawLabel);
        add(new JLabel()); // empty cell
        add(playAgainBtn);
        add(QuitBtn);

        setVisible(true);
    }
}
