package com.cutlet.ui;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private final int radius;
    private final Color backgroundColor;

    public RoundedPanel() {
        this(30, Color.WHITE);
    }

    public RoundedPanel(int radius, Color color) {

        this.radius = radius;
        this.backgroundColor = color;

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Shadow
        g2.setColor(new Color(0, 0, 0, 20));
        g2.fillRoundRect(
                4,
                4,
                getWidth() - 8,
                getHeight() - 8,
                radius,
                radius);

        // Main panel
        g2.setColor(backgroundColor);
        g2.fillRoundRect(
                0,
                0,
                getWidth() - 8,
                getHeight() - 8,
                radius,
                radius);

        g2.dispose();

        super.paintComponent(g);
    }
}