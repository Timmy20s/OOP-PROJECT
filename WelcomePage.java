package ui;

import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame {

    JTextField player1Input, player2Input;
    JButton startButton;

    public WelcomePage() {
        setTitle("Welcome to X and O Showdown 🎮");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //JPanel bgPanel = new BackgroundPanel("src/resources/XandObackground.jpeg"); // background
        //setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(0x1e272e)); // Dark background

        // 🎉 Top banner
        JLabel title = new JLabel("🔥 Welcome to the Ultimate X and O Showdown 🔥");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // 👥 Player input form
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 20, 60));

        JLabel p1Label = new JLabel("👤 Player 1 Name:");
        p1Label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        p1Label.setForeground(Color.WHITE);
        JLabel p2Label = new JLabel("👤 Player 2 Name:");
        p2Label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        p2Label.setForeground(Color.WHITE);

        player1Input = new JTextField();
        player1Input.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        player2Input = new JTextField();
        player2Input.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        formPanel.add(p1Label);
        formPanel.add(player1Input);
        formPanel.add(p2Label);
        formPanel.add(player2Input);
        //formPanel.add(bgPanel);
        add(formPanel, BorderLayout.CENTER);

        // 🚀 Start button
        startButton = new JButton("Start the Battle 🕹️");
        startButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        startButton.setBackground(new Color(0x34ace0)); // Vibrant blue
        startButton.setForeground(Color.WHITE);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));

        // Button container
        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        btnPanel.add(startButton);
        add(btnPanel, BorderLayout.SOUTH);

        // 💫 On click: store names and go
        startButton.addActionListener(e -> {
            GameState.playerOneName = player1Input.getText().trim().isEmpty() ? "Player 1" : player1Input.getText().trim();
            GameState.playerTwoName = player2Input.getText().trim().isEmpty() ? "Player 2" : player2Input.getText().trim();
            dispose();
            new XandO();
        });

        setVisible(true);
    }
}
