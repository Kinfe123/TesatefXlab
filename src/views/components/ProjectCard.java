import javax.swing.*;

public class ProjectCard extends JPanel {
    private String message;

    public ProjectCard(String message) {
        this.message = message;
        JLabel label = new JLabel(message);
        add(label);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        JLabel label = new JLabel(message);
        removeAll();
        add(label);
        revalidate();
        repaint();
    }
}