package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class XandO {

    JFrame window = new JFrame("🔥 X and O Game 🔥");
    JPanel boardPanel = new JPanel(new GridLayout(3, 3));
    JLabel turnLabel;

    JButton[] buttons = new JButton[9];

    ArrayList<Integer> playerOneMoves = new ArrayList<>();
    ArrayList<Integer> playerTwoMoves = new ArrayList<>();

    int flag = 0; // 0 = P1, 1 = P2

    public XandO() {
        drawGame();
    }

    void drawGame() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(450, 500);
        window.setLayout(new BorderLayout());

        // 🌟 Turn label
        turnLabel = new JLabel(GameState.playerOneName + "'s Turn (X)");
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnLabel.setFont(new Font("Arial", Font.BOLD, 22));
        turnLabel.setForeground(new Color(0x3b3b98));
        turnLabel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        window.add(turnLabel, BorderLayout.NORTH);

        // 🎨 Board styling
        boardPanel.setBackground(new Color(0xf1f2f6));
        boardPanel.setBorder(BorderFactory.createLineBorder(new Color(0x2f3542), 2));

        // 🎮 Game buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Segoe UI", Font.BOLD, 48));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setFocusPainted(false);
            int cell = i + 1;

            buttons[i].addActionListener(e -> handleClick((JButton) e.getSource(), cell));
            boardPanel.add(buttons[i]);
        }

        window.add(boardPanel, BorderLayout.CENTER);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    void handleClick(JButton btn, int cell) {
        if (btn.getText().equals("")) {
            if (flag == 0) {
                btn.setText("X");
                btn.setForeground(new Color(0x0c2461));
                playerOneMoves.add(cell);
                flag = 1;
                turnLabel.setText(GameState.playerTwoName + "'s Turn (O)");
                turnLabel.setForeground(new Color(0xB33771));
            } else {
                btn.setText("O");
                btn.setForeground(new Color(0xB33771));
                playerTwoMoves.add(cell);
                flag = 0;
                turnLabel.setText(GameState.playerOneName + "'s Turn (X)");
                turnLabel.setForeground(new Color(0x0c2461));
            }
            btn.setEnabled(false);
            checkWin();
        }
    }

    void checkWin() {
        int[][] winCombos = {
                {1,2,3}, {4,5,6}, {7,8,9},
                {1,4,7}, {2,5,8}, {3,6,9},
                {1,5,9}, {3,5,7}
        };

        for (int[] combo : winCombos) {
            if (playerOneMoves.contains(combo[0]) && playerOneMoves.contains(combo[1]) && playerOneMoves.contains(combo[2])) {
                GameState.playerOneScore++;
                showResult(GameState.playerOneName + " wins!", GameState.playerOneName + ": You win, keep flying 🚀");
                return;
            } else if (playerTwoMoves.contains(combo[0]) && playerTwoMoves.contains(combo[1]) && playerTwoMoves.contains(combo[2])) {
                GameState.playerTwoScore++;
                showResult(GameState.playerTwoName + " wins!", GameState.playerTwoName + ": You win, keep flying 🚀");
                return;
            }
        }

        if ((playerOneMoves.size() + playerTwoMoves.size()) == 9) {
            GameState.draws++;
            showResult("It’s a Draw!", "Draw: Go again and break the tie 🔁");
        }
    }

    void showResult(String title, String message) {
        JOptionPane.showMessageDialog(window, title + "\n" + message);
        window.dispose();
        new ScorePage();
    }
    }
