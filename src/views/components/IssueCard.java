package views.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.SQLException;

import views.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.PanelUI;
import javax.swing.plaf.basic.BasicPanelUI;

import controllers.ProjectController;

public class IssueCard extends JPanel {
    Dimension size;
    String projectId;
    String projectName;
    String projectDetails;
    String ownerName;
    String repoUrl;
    

    JButton collaborateButton;
    JButton issueAccept ;

  

    public IssueCard(String projectName , String projectDetails ,String projectId ,  String ownerName , String repoUrl  , Dimension size) throws ClassNotFoundException, SQLException{
        this.size = size;
        this.projectId= projectId;
        this.projectName = projectName;
    
        this.repoUrl = repoUrl;
        this.ownerName = ownerName;
        this.projectDetails = projectDetails;
        this.setVisible(true);
        this.setPreferredSize(this.size);
        // issueAccept.addActionListener(e -> showMessageDialog("You have su"));
        ProjectController apiController = new ProjectController();
       
        issueAccept =  new JButton("Issue Accept") {
			protected void paintComponent(Graphics g) {
			    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
			      Graphics2D g2 = (Graphics2D) g.create();
			      g2.setPaint(getBackground());
			      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
			          0, 0, getWidth() - 1, getHeight() - 1));
			      g2.dispose();
			    }
			    super.paintComponent(g);
			}
			  public void updateUI() {
			    super.updateUI();
			    setOpaque(false);
			    setBorder(new RoundedCornerBorder());
			  }
		};
		collaborateButton =  new JButton("Collaborate") {
			protected void paintComponent(Graphics g) {
			    if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
			      Graphics2D g2 = (Graphics2D) g.create();
			      g2.setPaint(getBackground());
			      g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
			          0, 0, getWidth() - 1, getHeight() - 1));
			      g2.dispose();
			    }
			    super.paintComponent(g);
			}
			  public void updateUI() {
			    super.updateUI();
			    setOpaque(false);
			    setBorder(new RoundedCornerBorder());
			  }
		};
        

        // this.setBackground(c);
        this.setFont(new Font("Roboto",Font.BOLD,50));
         JFrame frame = new JFrame("IssueCard UI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel cardPanel = new JPanel();
        // cardPanel.setLayout(new GridLayout(2, 3, 20, 20));
        // cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // for (int i = 0; i < 6; i++) {
        //     JPanel card = new JPanel();
        //     card.setPreferredSize(new Dimension(200, 200));
        //     // card.setBorder(new LineBorder(Color.GRAY));
        //     card.setLayout(new BorderLayout());

        //     JLabel titleLabel = new JLabel("IssueCard Title " + (i+1));
        //     titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18f));
        //     titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        //     card.add(titleLabel, BorderLayout.NORTH);

        //     JLabel descLabel = new JLabel("<html><body><p style='width: 150px;'>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p></body></html>");
        //     descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        //     card.add(descLabel, BorderLayout.CENTER);

        //     JPanel buttonPane = new JPanel();
        //     buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));

        //     JButton button1 = new JButton("Button 1");
        //     button1.setBackground(new Color(76, 175, 80));
        //     button1.setForeground(Color.WHITE);
        //     button1.setFocusPainted(false);
        //     button1.setBorder(getRoundedBorder(Color.WHITE, 16));
        //     button1.setPreferredSize(new Dimension(100, 40));
        //     button1.setMaximumSize(new Dimension(100, 40));
        //     buttonPane.add(button1);

        //     JButton button2 = new JButton("Button 2");
        //     button2.setBackground(new Color(76, 175, 80));
        //     button2.setForeground(Color.WHITE);
        //     button2.setFocusPainted(false);
        //     button2.setBorder(getRoundedBorder(Color.WHITE, 16));
        //     button2.setPreferredSize(new Dimension(100, 40));
        //     button2.setMaximumSize(new Dimension(100, 40));
        //     buttonPane.add(button2);

        //     card.add(buttonPane, BorderLayout.SOUTH);

        //     cardPanel.add(card);
        // }
        // this.setForeground(c.darker());
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonPane.setBackground(Color.WHITE);
        buttonPane.add(issueAccept);
        buttonPane.add(collaborateButton);
        issueAccept.setPreferredSize(new Dimension(120,35));
		issueAccept.setBackground(Color.BLUE);
		issueAccept.setFocusPainted(false);
		collaborateButton.setPreferredSize(new Dimension(120,35));
		collaborateButton.setBackground(Color.BLUE);
		collaborateButton.setFocusPainted(false);
        
        
        this.setBackground(Color.WHITE);
								// buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JLabel titleLable = new JLabel("<html><body><p style='width: 320px; height:500px; background-color:white;'> <h1 style='font-weight:'bold'; color:red;'> 📚 "+ projectName + "</h1></p></body></html>");
		JLabel descLabel = new JLabel("<html><body><p style='width: 320px; height:500px;'> Issue Details - "+ projectDetails + "</p></body></html>");
		JLabel descLabel1 = new JLabel("<html><body><p style='width: 320px; height:500px;'> Issued by - "+ ownerName + "</p></body></html>");
    
        this.add(titleLable);
        this.add(descLabel);
        this.add(descLabel1);
   
        // this.add(buttonPane);

        collaborateButton.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				try {
                URI uri = new URI(repoUrl);
                Desktop.getDesktop().browse(uri);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            }
		});
        // issueAccept.addActionListener(new ActionListener() {
        
        
        //     int projectID = Integer.parseInt(projectId);
         
        //     boolean createFork;
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         try {
        //             createFork = apiController.createForks(name , desc  , userId , projectID);
        //         } catch (SQLException e1) {
        //             // TODO Auto-generated catch block
        //             e1.printStackTrace();
        //         }
        //         if(createFork){
        //             // showMessageDialog("You jave successfully created a folks");
                    
                    
                   
        //         }


        //     }
        // });
        this.setForeground(Color.WHITE);
        this.setUI(new BasicPanelUI() {
            protected void paintBorderedPanel(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected){
                g.drawRoundRect(x, y, width, height, 20, 20);
                g.setColor(Color.WHITE);
            }
            

        });
       

    }



    // private Object showMessageDialog(String string) {
    //     JOptionPane.showMessageDialog(this, string);
    //     return null;
    // }



 
    
}