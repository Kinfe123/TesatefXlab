package views;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Dashboard {
    private static final String CARD_HOME = "home";
    private static final String CARD_PROFILE = "profile";
    private static final String CARD_SETTINGS = "settings";
    private static final String VERSION_CONTROL = "version_control";
    private static final String PROJECT = "project";

    private static final String task = "task";
    private static final String issk = "issue";


    private JFrame frame;
    private JPanel contentPanel;
    private JPanel cardPanel;


    public Dashboard() {
        frame = new JFrame("Dashboard Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create content panel with buttons and card panel
        JPanel buttonPanel = createButtonPanel();
        cardPanel = createCardPanel();
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(buttonPanel, BorderLayout.WEST);
        contentPanel.add(cardPanel, BorderLayout.CENTER);

        frame.add(contentPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createButtonPanel() {
        // Create buttons for each card
        JButton homeButton = createButton("Home");
        homeButton.addActionListener(e -> showCard(CARD_HOME));
        JButton profileButton = createButton("Profile");
        profileButton.addActionListener(e -> showCard(CARD_PROFILE));
        JButton settingsButton = createButton("Settings");
        settingsButton.addActionListener(e -> showCard(CARD_SETTINGS));
        JButton projecButton = createButton("project");
        settingsButton.addActionListener(e -> showCard(PROJECT));

        // Create button panel and add buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setPreferredSize(new Dimension(280, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
        buttonPanel.setBackground(new Color(41, 43, 44));
        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(homeButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(profileButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(settingsButton);
        buttonPanel.add(Box.createVerticalGlue());

        return buttonPanel;
    }

    private JPanel createCardPanel() {
        // Create cards
        JPanel homeCard = createHomeCard();
        JPanel profileCard = createProfileCard();
        JPanel settingsCard = createSettingsCard();

        // Create card panel and add cards
        JPanel cardPanel = new JPanel(new CardLayout());
        cardPanel.add(homeCard, CARD_HOME);
        cardPanel.add(profileCard, CARD_PROFILE);
        cardPanel.add(settingsCard, CARD_SETTINGS);

        return cardPanel;
    }

    private JPanel createHomeCard() {
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);

        // Add title label
        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        card.add(titleLabel, gbc);

        // Add content
        JLabel contentLabel = new JLabel("<html><body style='width: 300px;'><p>Welcome to the dashboard! This is the home page.</p></body></html>");
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        card.add(contentLabel, gbc);

        return card;
    }

    private JPanel createProfileCard() {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);

        // Add title label
        JLabel titleLabel = new JLabel("Profile");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        card.add(titleLabel, BorderLayout.NORTH);

        // Add content
        JLabel contentLabel = new JLabel("<html><body style='width: 300px;'><p>This is the profile page.</p></body></html>");
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        // contentLabel.setBorder(BorderFactory.createEmptyborder(20, 20, 20, 20));
        card.add(contentLabel, BorderLayout.CENTER);

        return card;
    }

    private JPanel createSettingsCard() {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);

        // Add title label
        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        card.add(titleLabel, BorderLayout.NORTH);

        // Add content
        JLabel contentLabel = new JLabel("<html><body style='width: 300px;'><p>This is the settings page.</p></body></html>");
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        contentLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        card.add(contentLabel, BorderLayout.CENTER);

        return card;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        // button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(41, 43, 44));
        button.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10));
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        button.setAlignmentX(JButton.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));
        return button;
    }

    private void showCard(String cardName) {
        CardLayout layout = (CardLayout) cardPanel.getLayout();
        layout.show(cardPanel, cardName);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}