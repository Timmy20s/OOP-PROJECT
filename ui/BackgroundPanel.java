package ui;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("XandObackground.jpeg"))).getImage();
        } catch (Exception e) {
            System.out.println("Image not found!");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
