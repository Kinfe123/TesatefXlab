package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Card UI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(2, 3, 20, 20));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 0; i < 6; i++) {
            JPanel card = new JPanel();
            card.setPreferredSize(new Dimension(200, 200));
            // card.setBorder(new LineBorder(Color.GRAY));
            card.setLayout(new BorderLayout());

            JLabel titleLabel = new JLabel("Card Title " + (i+1));
            titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18f));
            titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(titleLabel, BorderLayout.NORTH);

            JLabel descLabel = new JLabel("<html><body><p style='width: 150px;'>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p></body></html>");
            descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            card.add(descLabel, BorderLayout.CENTER);

            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

            JButton button1 = new JButton("Button 1");
            button1.setBackground(new Color(76, 175, 80));
            button1.setForeground(Color.WHITE);
            button1.setFocusPainted(false);
            button1.setBorder(getRoundedBorder(Color.WHITE, 16));
            button1.setPreferredSize(new Dimension(100, 40));
            button1.setMaximumSize(new Dimension(100, 40));
            buttonPane.add(button1);

            JButton button2 = new JButton("Button 2");
            button2.setBackground(new Color(76, 175, 80));
            button2.setForeground(Color.WHITE);
            button2.setFocusPainted(false);
            button2.setBorder(getRoundedBorder(Color.WHITE, 16));
            button2.setPreferredSize(new Dimension(100, 40));
            button2.setMaximumSize(new Dimension(100, 40));
            buttonPane.add(button2);

            card.add(buttonPane, BorderLayout.SOUTH);

            cardPanel.add(card);
        }

        frame.getContentPane().add(cardPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static Border getRoundedBorder(final Color color, final int radius) {
        return new Border() {
            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(radius, radius, radius, radius);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }

            @Override
            public void paintBorder(Component c, java.awt.Graphics g, int x, int y, int width, int height) {
                g.setColor(color);
                g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            }
        };
    }
}