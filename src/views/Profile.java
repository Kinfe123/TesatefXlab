package views;

import views.CreateProject;
import views.Profile;
import views.components.IssueCard;
import views.components.TaskCard;
import views.Profile;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;

import DB_CONN.*;
import controllers.ProjectController;

import javax.swing.JDesktopPane;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.List;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Profile {

	public JFrame frmProfile;
	public static JTextField fullname = new JTextField();

	public JButton Profile;
	public JTextField name;
	public JTextField mobile;
	public static JTextField email = new JTextField();
	public JTextField firId;
	public JTextField textField_7;
	public JTextField city;
    public static JComboBox act = new JComboBox();
    public static JTextField usernameFeild = new JTextField();
	private JTextField dateAdded;
	public static ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
                    ProjectController projectApi = new ProjectController();
                    ArrayList<String> result = projectApi.dumpSpecificUser(1);
                    usernameFeild.setText(result.get(0));
                    fullname.setText(result.get(1));
                    
                    email.setText(result.get(2));
                    act.setSelectedItem(result.get(3));
					window.frmProfile.setVisible(true);
					window.frmProfile.setSize(1650,1080);
					window.frmProfile.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Profile() throws ClassNotFoundException, SQLException {
		Profile =  new JButton("Update A Profile") {
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		// CrimeDB_Functions db = new CrimeDB_Functions();
		ProjectController projectApi = new ProjectController();
        ArrayList<String> result = projectApi.dumpSpecificUser(1);
        System.out.println("The resulr : " + result);
        // for(int i=0; i<result.size(); i++){
        //     if(result.get(i) != null){
        //         if(i == 0){
        //             usernameFeild.set()
        //         }
        //     }
        // // }

        // usernameFeild.setText(result.get(0));
        // fullname.setText(result.get(1));
        // email.setText(result.get(2));
        // act.setSelectedItem(result.get(3));

		frmProfile = new JFrame();
		
		frmProfile.getContentPane().setBackground(Color.WHITE);
		frmProfile.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -118, 300, 1080);
		frmProfile.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel TesatefXLab = new JLabel("TESATEF X Lab. ");
		TesatefXLab.setBounds(36, 147, 252, 31);
		TesatefXLab.setForeground(new Color(255, 255, 255));
		panel.add(TesatefXLab);
		TesatefXLab.setFont(new Font("Chandas", Font.BOLD, 16));
		
		JLabel label = new JLabel("________________________________________________");
		label.setBounds(36, 166, 276, 31);
		label.setFont(new Font("Dialog", Font.BOLD, 10));
		label.setForeground(new Color(255, 255, 255));
		panel.add(label);
		
		JLabel lblFir = new JLabel("📚 Projects ");
		lblFir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Profile.main(null);
				frmProfile.repaint();
				// frmProfile.setVisible(false);

				
			}
		});
		lblFir.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblFir.setForeground(new Color(255, 255, 255));
		lblFir.setBackground(new Color(255, 255, 255));
		lblFir.setBounds(36, 236, 99, 15);
		panel.add(lblFir);
		
		JLabel userLabel = new JLabel("🤼 Users.");
		userLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Users.main(null);
			frmProfile.setVisible(false);

				
			}
		});
		userLabel.setFont(new Font("Chilanka", Font.BOLD, 14));
		userLabel.setForeground(new Color(255, 255, 255));
		userLabel.setBounds(36, 266, 139, 15);
		panel.add(userLabel);
		
		JLabel lblCases = new JLabel("🤔 Issue");
		lblCases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateIssue.main(null);
				frmProfile.setVisible(false);

				
			}
		});
		JLabel tasklLabel = new JLabel("💼 Tasks");
		tasklLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateTask.main(null);
				frmProfile.setVisible(false);
				// frmHome.setVisible(false);

				
			}
		});
		JLabel profile = new JLabel("👤 Profil");
		profile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmProfile.repaint();
				frmProfile.setVisible(false);
				// frmHome.setVisible(false);

				
			}
		});
		tasklLabel.setFont(new Font("Chilanka", Font.BOLD, 14));
		tasklLabel.setForeground(new Color(255, 255, 255));
		tasklLabel.setBounds(36, 320, 70, 15);
		panel.add(tasklLabel);
		lblCases.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblCases.setForeground(new Color(255, 255, 255));
		lblCases.setBounds(36, 293, 70, 15);
		panel.add(lblCases);
		
		JLabel userProfile = new JLabel("");
		userProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userProfile.setForeground(Color.WHITE);
		userProfile.setText(Login.userProfile);
	
		userProfile.setBounds(36, 758, 214, 31);
		panel.add(userProfile);
		String username = projectApi.fetchUsername(userProfile.getText());
		JLabel usernameLabel = new JLabel(username);
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setBounds(36, 770, 70, 15);
		panel.add(usernameLabel);
		
		
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Login.main(null);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frmProfile, "Succesfully Logout.");

				frmProfile.setVisible(false);

				
			}
		});
		lblLogOut.setToolTipText("BACK to login");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmProfile.getContentPane().add(lblLogOut);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("Menu.acceleratorForeground"));
		tabbedPane.setBounds(353, 12, 895, 600);
		frmProfile.getContentPane().add(tabbedPane);
		// Image im = new ImageIcon(this.getClass().getResource("/fir.jpg")).getImage();
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		tabbedPane.addTab("Update Profile", null, desktopPane, null);
		
		JLabel fullNameLbl = new JLabel("* Full Name  ");
		fullNameLbl.setFont(new Font("Chilanka", Font.BOLD, 13));
		fullNameLbl.setBounds(52, 54, 174, 21);
		desktopPane.add(fullNameLbl);
		
		JLabel emailLbl = new JLabel("* Email ");
		emailLbl.setFont(new Font("Chilanka", Font.BOLD, 13));
		emailLbl.setBounds(52, 87, 300, 15);
		desktopPane.add(emailLbl);
		
		JLabel versionControlSelects = new JLabel("* Version Control ");
		versionControlSelects.setFont(new Font("Chilanka", Font.BOLD, 13));
		versionControlSelects.setBounds(52, 114, 300, 15);
		desktopPane.add(versionControlSelects);
		
	
		JLabel usernameLbl = new JLabel("* Username  ");
		usernameLbl.setFont(new Font("Chilanka", Font.BOLD, 13));
		usernameLbl.setBounds(52, 141, 300, 15);
		desktopPane.add(usernameLbl);
	
	
		
		fullname = new JTextField();
		fullname.setBounds(244, 53, 413, 19);
		desktopPane.add(fullname);
		fullname.setColumns(10);
		
		email = new JTextField();
		email.setBounds(244, 83, 271, 19);
		desktopPane.add(email);
		email.setColumns(10);

	    usernameFeild = new JTextField();
		usernameFeild.setBounds(244, 143, 271, 19);
		desktopPane.add(usernameFeild );
		usernameFeild.setColumns(10);

        act =  new JComboBox();
            
		act.setBounds(244, 107, 261, 24);
        desktopPane.add(act);
        act.addItem("None");
        act.addItem("Github");
        act.addItem("Gitlab");
        act.addItem("BitBucket");
        act.addItem("SourceForge");
        act.addItem("CodeBase");

			
			
				
						
				JLabel lblNewLabel = new JLabel("Project label");
				lblNewLabel.setBounds(675, 35, 203, 169);
				// desktopPane.add(lblNewLabel);
				// lblNewLabel.setIcon(new ImageIcon(im));
				
				// JLabel lblDetails = new JLabel("* README Text");
				// lblDetails.setFont(new Font("Chilanka", Font.BOLD, 13));
				// lblDetails.setBounds(52, 378, 70, 15);
				// desktopPane.add(lblDetails);
				
				// JTextArea details = new JTextArea();
				// details.setToolTipText("Enter Here");
				// details.setBackground(Color.LIGHT_GRAY);
				// details.setBounds(244, 376, 413, 76);
				// decresktopPane.add(details);
				
				// JTextArea taskDetails = new JTextArea();
				// taskDetails.setToolTipText("Enter here");
				// taskDetails.setBackground(Color.LIGHT_GRAY);
				// taskDetails.setBounds(244, 168, 413, 51);
				// desktopPane.add(taskDetails);
				Profile.setPreferredSize(new Dimension(250,35));
				Profile.setBackground(new Color(66, 245, 114));
				Profile.setFocusPainted(false);
				
				JButton btnSubmit = new JButton("Submit");
				Profile.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//create the fir
						// String firIdString = firId.getText();
						String fullNames = fullname.getText();
						String emails = email.getText();
						String versionControls = act.getSelectedItem().toString();
						// String acts = act.getSelectedItem().toString();
						// String caseName = name.getText();
						String usernameLbls = usernameFeild.getText();
						

						try {
							if(projectApi.updateUserProfile(1, usernameLbls, emails,  fullNames , versionControls )) {
								JOptionPane.showMessageDialog(frmProfile, "Profile has been created successfully!");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(frmProfile, "Profile is already uptodate!");
							e1.printStackTrace();
						}
					}
				});
				
				btnSubmit.setForeground(Color.WHITE);
				btnSubmit.setBackground(Color.BLUE);
				btnSubmit.setFont(new Font("Chilanka", Font.BOLD, 14));
				Profile.setBounds(244, 458, 120
				
				, 40);
				desktopPane.add(Profile);
				
				JLabel lblFirId = new JLabel(" 🆔 Project ID");
				lblFirId.setFont(new Font("Chilanka", Font.BOLD, 13));
				lblFirId.setBounds(52, 22, 70, 15);
				desktopPane.add(lblFirId);
				
				// firId = new JTextField();
				// firId.setBounds(244, 22, 114, 19);
				// desktopPane.add(firId);
				// firId.setColumns(10);
				
				// city = new JTextField();
				// city.setBounds(244, 245, 195, 21);
				// desktopPane.add(city);
				// city.setColumns(10);
				
				// dateAdded = new JTextField();
				// dateAdded.setColumns(10);
				// dateAdded.setBounds(244, 277, 114, 19);
				// desktopPane.add(dateAdded);
				
				// JLabel label_1 = new JLabel("DD/MM/YYYY");
				// label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
				// label_1.setBounds(373, 279, 99, 15);
				// desktopPane.add(label_1);
				
				// JLabel lblDate = new JLabel("* Date");
				// lblDate.setFont(new Font("Dialog", Font.BOLD, 13));
				// lblDate.setBounds(52, 280, 126, 15);
				// desktopPane.add(lblDate);
				
						
						
					
	
	
					
	
		
		frmProfile.setName("Profile Update ");
		frmProfile.setBounds(100, 100, 1366, 732);
		frmProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});

    
	}
}
