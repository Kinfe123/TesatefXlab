package views;

import views.CreateProject;
import views.CreateIssue;
import views.CreateTask;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;

import com.mysql.fabric.xmlrpc.base.Array;

import DB_CONN.*;
import controllers.ProjectController;
import models.ProjectModel;

import javax.swing.JDesktopPane;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.List;
import java.awt.TextArea;

import views.components.Card;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Home {

	private JFrame frmHome;
	private JTextField projectLabelName;
	private JTextField title;
	public JButton createProjectBtn;
	private JTextField name;
	private JTextField mobile;
	private JTextField repoUrls;
	private JTextField firId;
	public String selectedVersionControl;
	// public String 
	private JTextField textField_7;
	private JTextField licenses;
	private JTextField dateAdded;
	public static ResultSet rs;
	public static int  currentUserId ;
	public JButton forkButton;
	public JButton collaborateButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmHome.setVisible(true);
					window.frmHome.setSize(1650,1080);
					window.frmHome.setLocationRelativeTo(null);
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
	public Home() throws ClassNotFoundException, SQLException {
		
		createProjectBtn =  new JButton("Create Project") {
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
		forkButton =  new JButton("Fork") {
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
		currentUserId = projectApi.fetchProjectID(Login.userProfile);

		frmHome = new JFrame();
		
		frmHome.getContentPane().setBackground(Color.WHITE);
		frmHome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -118, 300, 1080);
		frmHome.getContentPane().add(panel);
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
				// Home.main(null);
				frmHome.repaint();
				// frmHome.setVisible(false);

				
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
			frmHome.setVisible(false);

				
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
				frmHome.setVisible(false);

				
			}
		});
		JLabel tasklLabel = new JLabel("💼 Tasks");
		tasklLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateTask.main(null);
				frmHome.setVisible(false);
				// frmHome.setVisible(false);

				
			}
		});
		tasklLabel.setFont(new Font("Chilanka", Font.BOLD, 14));
		tasklLabel.setForeground(new Color(255, 255, 255));
		tasklLabel.setBounds(36, 320, 70, 15);
		panel.add(tasklLabel);
		lblFir.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblFir.setForeground(new Color(255, 255, 255));
		lblFir.setBackground(new Color(255, 255, 255));
		lblFir.setBounds(36, 236, 99, 15);
		panel.add(lblFir);
		
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
				JOptionPane.showMessageDialog(frmHome, "Succesfully Logout.");

				frmHome.setVisible(false);

				
			}
		});
		
		// createProjectBtn.addActionListener(new ActionListener() {
		// 			@Override
		// 			public void actionPerformed(ActionEvent e) {
		// 				System.out.println("USername: " + repoUrls.getText());
		// 				System.out.println("Password: " +  password.getText());
		// 				String projectName = projectLabelName.getText();
		// 				String selectedVeersionControl =  act.getSelectedItem().toString();

		// 			try {
							
		// 					if(apiController.authenticateUser(username, passcode)) {
								
		// 						Home.main(null);
		// 						jframe.setVisible(false);
		// 					}
		// 					else {
		// 						System.out.println("");
		// 						JOptionPane.showMessageDialog(jframe.getContentPane(), "Please enter valid login details");
		// 					}
		// 				} catch (SQLException e1) {
		// 					// TODO Auto-generated catch block
		// 					e1.printStackTrace();
		// 				}
        //     }
		// });
		lblLogOut.setToolTipText("BACK to login");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmHome.getContentPane().add(lblLogOut);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("Menu.acceleratorForeground"));
		tabbedPane.setBounds(353, 12, 1300, 800);
		frmHome.getContentPane().add(tabbedPane);
		// Image im = new ImageIcon(this.getClass().getResource("/fir.jpg")).getImage();
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		tabbedPane.addTab("Create Projects", null, desktopPane, null);
		
		JLabel lblprojectLabelName = new JLabel("* Project Name ");
		lblprojectLabelName.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblprojectLabelName.setBounds(52, 54, 174, 21);
		desktopPane.add(lblprojectLabelName);
		
		JLabel lblSubject = new JLabel("* Subject Area");
		lblSubject.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblSubject.setBounds(52, 87, 300, 15);
		desktopPane.add(lblSubject);
		
		JLabel versionControl = new JLabel("* Version Control ");
		versionControl.setFont(new Font("Chilanka", Font.BOLD, 13));
		versionControl.setBounds(52, 114, 300, 15);
		desktopPane.add(versionControl);
		
		JLabel surename = new JLabel("* SureName Of Project Owner ");
		surename.setFont(new Font("Chilanka", Font.BOLD, 13));
		surename.setBounds(52, 141, 300, 15);
		desktopPane.add(surename);
		
		JLabel projectDesc = new JLabel("* ProjecT Description");
		projectDesc.setFont(new Font("Chilanka", Font.BOLD, 13));
		projectDesc.setBounds(52, 179, 300, 15);
		desktopPane.add(projectDesc);
		
		JLabel licenese = new JLabel("* Licensed Under");
		licenese.setFont(new Font("Chilanka", Font.BOLD, 13));
		licenese.setBounds(52, 247, 300, 15);
		desktopPane.add(licenese);
		
		JLabel phone = new JLabel("* Phone");
		phone.setFont(new Font("Chilanka", Font.BOLD, 13));
		phone.setBounds(52, 313, 300 , 15);
		desktopPane.add(phone);
		
		JLabel versionControlRepo = new JLabel("* Version C. Repo Url ");
		versionControlRepo.setFont(new Font("Chilanka", Font.BOLD, 13));
		versionControlRepo.setBounds(52, 340, 300, 15);
		desktopPane.add(versionControlRepo);
		
		projectLabelName = new JTextField();
		projectLabelName.setBounds(244, 53, 413, 19);
		desktopPane.add(projectLabelName);
		projectLabelName.setColumns(10);
		
		title = new JTextField();
		title.setBounds(244, 83, 271, 19);
		desktopPane.add(title);
		title.setColumns(10);
		
		name = new JTextField();
		name.setBounds(243, 137, 272, 19);
		desktopPane.add(name);
		name.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(244, 309, 271, 19);
		desktopPane.add(mobile);
		mobile.setColumns(10);
		
		repoUrls = new JTextField();
		repoUrls.setBounds(244, 336, 271, 19);
		desktopPane.add(repoUrls);
		repoUrls.setColumns(10);
		
		//int act[]= {301,302,303,304};
		//Using array set of combobox is not working till ....we will fix this problem .
		JComboBox act = new JComboBox();
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
				
				JLabel lblDetails = new JLabel("* README ");
				lblDetails.setFont(new Font("Chilanka", Font.BOLD, 13));
				lblDetails.setBounds(52, 378, 70, 15);
				desktopPane.add(lblDetails);
				
				JTextArea details = new JTextArea();
				details.setToolTipText("Enter Here");
				details.setBackground(Color.LIGHT_GRAY);
				details.setBounds(244, 376, 413, 76);
				desktopPane.add(details);
				
				JTextArea projectDetailDesc = new JTextArea();
				projectDetailDesc.setToolTipText("Enter here");
				projectDetailDesc.setBackground(Color.LIGHT_GRAY);
				projectDetailDesc.setBounds(244, 168, 413, 51);
				desktopPane.add(projectDetailDesc);
				
				createProjectBtn.setPreferredSize(new Dimension(250,35));
				createProjectBtn.setBackground(new Color(66, 245, 114));
				createProjectBtn.setFocusPainted(false);
				forkButton.setPreferredSize(new Dimension(120,35));
				forkButton.setBackground(new Color(66, 120, 114));
				forkButton.setFocusPainted(false);
				collaborateButton.setPreferredSize(new Dimension(120,35));
				collaborateButton.setBackground(new Color(66, 120, 114));
				collaborateButton.setFocusPainted(false);
				JButton btnSubmit = new JButton("Submit");
				createProjectBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//create the fir
						// String firIdString = firId.getText();
						// String policeSN = projectLabelName.getText();
						String projectNames = projectLabelName.getText();
						String subjectArea = title.getText();
						String versionControlSelected  = act.getSelectedItem().toString();
						String surename = name.getText();
						String projectDetails = projectDetailDesc.getText();
						String dateAdd = dateAdded.getText();
						String license = licenses.getText();
						String phone = mobile.getText();
						String repoUrl = repoUrls.getText();
						String readme = details.getText();
						

						
						// // System.out.println(selectedVersionControl);
						
						// System.out.println(projectDetailDesc);
						// System.out.println(dateAdd);
						// System.out.println(repoUrls);
						// System.out.println(detail);
						// System.out.println(versionControlSelected);
						// System.out.println(licenses1);
						// System.out.println(license);
						// System.out.println(phone);

						try {
							if(projectApi.createProject(currentUserId + 3 , projectNames, projectDetails, versionControlSelected, repoUrl , readme , currentUserId )) {
								JOptionPane.showMessageDialog(frmHome, "Project has been created successfully!");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(frmHome, "Project already exists");
							e1.printStackTrace();
						}
					}
				});
				btnSubmit.setForeground(Color.WHITE);
				btnSubmit.setBackground(Color.BLUE);
				btnSubmit.setFont(new Font("Chilanka", Font.BOLD, 14));
				createProjectBtn.setBounds(244, 458, 120
				
				, 40);
				desktopPane.add(createProjectBtn);
				
				JLabel lblFirId = new JLabel(" 🆔 Project ID");
				lblFirId.setFont(new Font("Chilanka", Font.BOLD, 13));
				lblFirId.setBounds(52, 22, 70, 15);
				desktopPane.add(lblFirId);
				
				firId = new JTextField();
				firId.setBounds(244, 22, 114, 19);
				desktopPane.add(firId);
				firId.setColumns(10);
				
				licenses = new JTextField();
				licenses.setBounds(244, 245, 195, 21);
				desktopPane.add(licenses);
				licenses.setColumns(10);
				
				dateAdded = new JTextField();
				dateAdded.setColumns(10);
				dateAdded.setBounds(244, 277, 114, 19);
				desktopPane.add(dateAdded);
				
				JLabel label_1 = new JLabel("DD/MM/YYYY");
				label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
				label_1.setBounds(373, 279, 99, 15);
				desktopPane.add(label_1);
				
				JLabel lblDate = new JLabel("* Date");
				lblDate.setFont(new Font("Dialog", Font.BOLD, 13));
				lblDate.setBounds(52, 280, 126, 15);
				desktopPane.add(lblDate);
				
						
						JDesktopPane desktopPane_1 = new JDesktopPane();
						// desktopPane_1.setLayout();
						tabbedPane.addTab("Search Projects", null, desktopPane_1, null);
						
						JLabel lblHelloUser = new JLabel("* Hello 👤 " + Login.userProfile +" You can see fire projects here 🚀 ");
						lblHelloUser.setForeground(Color.BLACK);
						lblHelloUser.setBackground(Color.BLACK);
						lblHelloUser.setFont(new Font("Chilanka", Font.BOLD, 14));
						lblHelloUser.setBounds(48, 80, 517, 15);
						desktopPane_1.add(lblHelloUser);
						
						JLabel lblEnterFirId = new JLabel("Enter Projct ID");
						lblEnterFirId.setFont(new Font("Chilanka", Font.BOLD, 13));
						lblEnterFirId.setBounds(58, 129, 115, 15);
						desktopPane_1.add(lblEnterFirId);
						
						textField_7 = new JTextField();
						textField_7.setBounds(172, 125, 205, 19);
						desktopPane_1.add(textField_7);
						textField_7.setColumns(10);
						
						JButton btnNewButton = new JButton("Search");
						btnNewButton.addMouseListener(new MouseAdapter() {
							// @Override
							// public void mouseClicked(MouseEvent arg0) {
							// 	String firId = textField_7.getText();
							// 	try {
							// 		// rs = db.search_fir(firId);
							// 		if(rs == null) {
							// 			JOptionPane.showMessageDialog(frmHome, "FIR not found");
							// 		}else {
							// 			frmHome.setVisible(false);
							// 			// FIRdisplay.main(null);
							// 		}
							// 	} catch (SQLException e) {
							// 		// TODO Auto-generated catch block
							// 		JOptionPane.showMessageDialog(frmHome, "Server not responding");
							// 		e.printStackTrace();
							// 	}
							// }
						});

						
						btnNewButton.setForeground(Color.WHITE);
						btnNewButton.setBackground(Color.BLUE);
						btnNewButton.setBounds(416, 122, 117, 25);
						desktopPane_1.add(btnNewButton);
						ProjectController apiController = new ProjectController();
						ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
						ArrayList<ArrayList<String>> test = new ArrayList<ArrayList<String>>();
						data = apiController.fetchUsers();
						test = apiController.fetchProjects();
						
						for(int i = 0; i < data.size(); i ++) {
								ArrayList<String> temp = data.get(i);
								
								// System.out.println(temp);
								
						}
						int start = 170;
						String Owner;
					    
						JPanel cardPanel = new JPanel();
						cardPanel.setLayout(new GridLayout(2, 3, 20, 20));
						cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
						
						
						for(int i = 0; i < test.size(); i ++) {
								ArrayList<String> temp = test.get(i);
								String res ;
								JLabel labels = new JLabel("Hello");

								res = apiController.fetchUserProjectDetails(Integer.parseInt(temp.get(6)));
								Card newCard = new views.components.Card("Hellow", new Dimension(500, 200) , temp.get(0) , temp.get(1) , res , temp.get(4) , temp.get(7) , currentUserId );
								newCard.setBounds(0, start  , 600, 200);
								
								desktopPane_1.add(newCard);
								labels.setBounds(0, start + 20, 600, 200);
								desktopPane_1.add(labels);
								
								// // String name = temp[1];
								// JPanel card = new JPanel();
								// card.setPreferredSize(new Dimension(200, 200));
								// // card.setBorder(new LineBorder(Color.GRAY));
								// card.setLayout(new BorderLayout());

								// JLabel titleLabel = new JLabel("Card Title " + (i+1));
								// titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 18f));
								// titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
								// card.add(titleLabel, BorderLayout.NORTH);
								// desktopPane_1.add(card);
								// JLabel titleLable = new JLabel("<html><body><p style='width: 320px;'> <h1 style='font-weight:'bold'; color:red;'> 📚 "+ temp.get(0) + "</h1></p></body></html>");
								// JLabel descLabel = new JLabel("<html><body><p style='width: 320px;'>"+ temp.get(1) + "</p></body></html>");
								// // descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
								// // desktopPane_1.add(descLabel);
								// // card.add(descLabel, BorderLayout.CENTER);
								
								// JPanel buttonPane = new JPanel();
								// buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
								
								// JButton button1 = new JButton("Button 1");
								// button1.setBackground(new Color(76, 175, 80));
								// button1.setForeground(Color.WHITE);
								// button1.setFocusPainted(false);
								// // button1.setBorder(getRoundedBorder(Color.WHITE, 16));
								// button1.setPreferredSize(new Dimension(100, 40));
								// button1.setMaximumSize(new Dimension(100, 40));
								// buttonPane.add(forkButton);
								// forkButton.setBounds(48, start + 50, 100, 40);
								
								// collaborateButton.setBounds(48, start + 50, 100, 40);
								// buttonPane.add(forkButton);
								// buttonPane.add(collaborateButton);
								// buttonPane.setBounds(48, start + 80 , 500 , 50);
								// // buttonPane.setForeground(Color.TRANSLUCENT);

								// desktopPane_1.add(buttonPane);
								
								
								// JButton button2 = new JButton("Button 2");
								// button2.setBackground(new Color(76, 175, 80));
								// button2.setForeground(Color.WHITE);
								// button2.setFocusPainted(false);
								// button2.setBorder(getRoundedBorder(Color.WHITE, 16));
								// button2.setPreferredSize(new Dimension(100, 40));
								// button2.setMaximumSize(new Dimension(100, 40));
								// buttonPane.add(collaborateButton);

								// card.add(buttonPane, BorderLayout.SOUTH);

								// // desktopPane_1.add(card);
								// cardPanel.add(card);
								// desktopPane_1.add(cardPanel);
								// JLabel dash = new JLabel("-----------------------------------------------------");
								// descLabel.setForeground(Color.BLACK);
								// descLabel.setBackground(Color.BLACK);
								// descLabel.setFont(new Font("Chilanka", Font.BOLD, 14));
								// descLabel.setBounds(48, start + 45, 517, 40);
								// desktopPane_1.add(descLabel);
								// titleLable.setForeground(Color.BLACK);
								// titleLable.setBackground(Color.BLACK);
								// titleLable.setFont(new Font("Chilanka", Font.BOLD, 14));
								// titleLable.setBounds(48, start, 517, 40);
								// desktopPane_1.add(titleLable);

								// JLabel projectName = new JLabel("📚 Proect Name -  " + temp.get(0));
								// projectName.setForeground(Color.BLACK);
								// projectName.setBackground(Color.BLACK);
								// projectName.setFont(new Font("Chilanka", Font.BOLD, 14));
								// projectName.setBounds(48, start+20, 517, 40);
								// desktopPane_1.add(projectName);
								// JLabel projectDetails = new JLabel("🧾 Project Details - " + temp.get(1));
								// projectDetails.setForeground(Color.BLACK);
								// projectDetails.setBackground(Color.BLACK);
								// projectDetails.setFont(new Font("Chilanka", Font.BOLD, 14));
								// projectDetails.setBounds(48, start + 40, 1000, 40);
								// desktopPane_1.add(projectDetails);
								// // JLabel projectIrl = new JLabel(t);
								// // projectIrl.setForeground(Color.BLACK);
								// // projectIrl.setBackground(Color.BLACK);
								// // projectIrl.setFont(new Font("Chilanka", Font.BOLD, 14));
								// // projectIrl.setBounds(48, 230, 517, 40);
								// // desktopPane_1.add(projectIrl);
								// String res ;
								// res = apiController.fetchUserProjectDetails(Integer.parseInt(temp.get(6)));
								// System.out.println("The owner : "+ res );
								// JLabel projectOwner = new JLabel("💻 Created By - " + res);
								// projectOwner.setForeground(Color.BLACK);
								// projectOwner.setBackground(Color.BLACK);
								// projectOwner.setFont(new Font("Chilanka", Font.BOLD, 14));
								// projectOwner.setBounds(48, start + 60, 517, 40);
								// desktopPane_1.add(projectOwner);
								// JLabel projectVersionControl = new JLabel("🚀 Version Control - " + temp.get(3));
								// projectVersionControl.setForeground(Color.BLACK);
								// projectVersionControl.setBackground(Color.BLACK);
								// projectVersionControl.setFont(new Font("Chilanka", Font.BOLD, 14));
								// projectVersionControl.setBounds(48, start + 80, 517, 40);
								// desktopPane_1.add(projectVersionControl);
								// JLabel projectUrl = new JLabel("🔗  Project Url - " + temp.get(4));
								// projectUrl.setForeground(Color.BLACK);
								// projectUrl.setBackground(Color.BLACK);
								// projectUrl.setFont(new Font("Chilanka", Font.BOLD, 14));
								// projectUrl.setBounds(48, start + 100, 517, 40);
								// desktopPane_1.add(projectUrl);

								// JLabel dash2 = new JLabel("-----------------------------------------------------");
								// dash2.setForeground(Color.BLACK);
								// dash2.setBackground(Color.BLACK);
								// dash2.setFont(new Font("Chilanka", Font.BOLD, 14));
								// dash2.setBounds(48, start + 120, 517, 40);
								// desktopPane_1.add(dash2);
								start = start + 130;


								// ProjectModel projectModel = new ProjectModel(temp.get(0) , temp.get(1) , temp.get(2) , temp.get(3) , temp.get(4) , temp.get(5));
								// System.out.println("Testing the projct: " + temp[1]);
								// JList<String> displayList = new JList<>(temp.toArray(new String[0]));
								// JScrollPane scrollPane = new JScrollPane(displayList);	
								
								// desktopPane_1.add(scrollPane);
						}
						// desktopPane_1.add(cardPanel);
						
						// JLabel lblOr = new JLabel("OR");
						// lblOr.setForeground(Color.RED);
						// lblOr.setFont(new Font("FreeSerif", Font.BOLD, 17));
						// lblOr.setBounds(230, 201, 70, 15);
						// desktopPane_1.add(lblOr);
						
						// JLabel lblSelectAct = new JLabel("Select ACT");
						// lblSelectAct.setBounds(58, 304, 98, 15);
						// desktopPane_1.add(lblSelectAct);
						
						// JComboBox comboBox_2 = new JComboBox();
						// comboBox_2.setBounds(172, 299, 205, 24);
						// desktopPane_1.add(comboBox_2);
						
						// JButton btnSearch = new JButton("Search");
						// btnSearch.setForeground(Color.WHITE);
						// btnSearch.setBounds(416, 299, 117, 25);
						// desktopPane_1.add(btnSearch);

		
	              		 JDesktopPane desktopPane_2 = new JDesktopPane();
						tabbedPane.addTab("Your Projects", null, desktopPane_2, null);
						
						JLabel labelHello = new JLabel("* Hello 👤 " + Login.userProfile +" You can see fire projects here 🚀 ");
						labelHello.setForeground(Color.BLACK);
						labelHello.setBackground(Color.BLACK);
						labelHello.setFont(new Font("Chilanka", Font.BOLD, 14));
						labelHello.setBounds(48, 80, 517, 15);
						desktopPane_2.add(labelHello);
						
						JLabel labelText = new JLabel("Enter Projct ID");
						labelText.setFont(new Font("Chilanka", Font.BOLD, 13));
						labelText.setBounds(58, 129, 115, 15);
						desktopPane_2.add(labelText);
						
						textField_7 = new JTextField();
						textField_7.setBounds(172, 125, 205, 19);
						desktopPane_2.add(textField_7);
						textField_7.setColumns(10);
						
						JButton buttonSearch = new JButton("Search");
						buttonSearch.addMouseListener(new MouseAdapter() {
							// @Override
							// public void mouseClicked(MouseEvent arg0) {
							// 	String firId = textField_7.getText();
							// 	try {
							// 		// rs = db.search_fir(firId);
							// 		if(rs == null) {
							// 			JOptionPane.showMessageDialog(frmHome, "FIR not found");
							// 		}else {
							// 			frmHome.setVisible(false);
							// 			// FIRdisplay.main(null);
							// 		}
							// 	} catch (SQLException e) {
							// 		// TODO Auto-generated catch block
							// 		JOptionPane.showMessageDialog(frmHome, "Server not responding");
							// 		e.printStackTrace();
							// 	}
							// }
						});
						
						
						JDesktopPane desktopPane_3 = new JDesktopPane();
					 tabbedPane.addTab("Forked Projects", null, desktopPane_3, null);
					 
					 JLabel labelHelllo1 = new JLabel("* Hello 👤 " + Login.userProfile +" You can see fire projects here 🚀 ");
					 labelHelllo1.setForeground(Color.BLACK);
					 labelHelllo1.setBackground(Color.BLACK);
					 labelHelllo1.setFont(new Font("Chilanka", Font.BOLD, 14));
					 labelHelllo1.setBounds(48, 80, 517, 15);
					 desktopPane_3.add(labelHelllo1);
					 
					 JLabel labelHello1 = new JLabel("Enter Projct ID");
					 labelHello1.setFont(new Font("Chilanka", Font.BOLD, 13));
					 labelHello1.setBounds(58, 129, 115, 15);
					 desktopPane_3.add(labelHello1);
					 
					 textField_7 = new JTextField();
					 textField_7.setBounds(172, 125, 205, 19);
					 desktopPane_3.add(textField_7);
					 textField_7.setColumns(10);
					 
					 JButton buttonSearch1 = new JButton("Search");
					 buttonSearch.addMouseListener(new MouseAdapter() {
						 // @Override
						 // public void mouseClicked(MouseEvent arg0) {
						 // 	String firId = textField_7.getText();
						 // 	try {
						 // 		// rs = db.search_fir(firId);
						 // 		if(rs == null) {
						 // 			JOptionPane.showMessageDialog(frmHome, "FIR not found");
						 // 		}else {
						 // 			frmHome.setVisible(false);
						 // 			// FIRdisplay.main(null);
						 // 		}
						 // 	} catch (SQLException e) {
						 // 		// TODO Auto-generated catch block
						 // 		JOptionPane.showMessageDialog(frmHome, "Server not responding");
						 // 		e.printStackTrace();
						 // 	}
						 // }
					 });
		
					 
					 JDesktopPane desktopPane_4 = new JDesktopPane();
				  tabbedPane.addTab("Programming Lanaguage Used", null, desktopPane_4, null);
				  
				  JLabel labelHome2 = new JLabel("* Hello 👤 " + Login.userProfile +" You can see fire projects here 🚀 ");
				  labelHome2.setForeground(Color.BLACK);
				  labelHome2.setBackground(Color.BLACK);
				  labelHome2.setFont(new Font("Chilanka", Font.BOLD, 14));
				  labelHome2.setBounds(48, 80, 517, 15);
				  desktopPane_4.add(labelHome2);
				  
				  JLabel labelHello2 = new JLabel("Enter Projct ID");
				  labelHello2.setFont(new Font("Chilanka", Font.BOLD, 13));
				  labelHello2.setBounds(58, 129, 115, 15);
				  desktopPane_4.add(labelHello2);
				  
				  textField_7 = new JTextField();
				  textField_7.setBounds(172, 125, 205, 19);
				  desktopPane_4.add(textField_7);
				  textField_7.setColumns(10);
				  
				  JButton buttonSearch3 = new JButton("Search");
				  buttonSearch.addMouseListener(new MouseAdapter() {
					  // @Override
					  // public void mouseClicked(MouseEvent arg0) {
					  // 	String firId = textField_7.getText();
					  // 	try {
					  // 		// rs = db.search_fir(firId);
					  // 		if(rs == null) {
					  // 			JOptionPane.showMessageDialog(frmHome, "FIR not found");
					  // 		}else {
					  // 			frmHome.setVisible(false);
					  // 			// FIRdisplay.main(null);
					  // 		}
					  // 	} catch (SQLException e) {
					  // 		// TODO Auto-generated catch block
					  // 		JOptionPane.showMessageDialog(frmHome, "Server not responding");
					  // 		e.printStackTrace();
					  // 	}
					  // }
				  });
					 JDesktopPane desktopPane_5 = new JDesktopPane();
				  tabbedPane.addTab("Your Gists", null, desktopPane_5, null);
				  
				  JLabel labelHome3 = new JLabel("* Hello 👤 " + Login.userProfile +" You can see fire projects here 🚀 ");
				  labelHome3.setForeground(Color.BLACK);
				  labelHome3.setBackground(Color.BLACK);
				  labelHome3.setFont(new Font("Chilanka", Font.BOLD, 14));
				  labelHome3.setBounds(48, 80, 517, 15);
				  desktopPane_5.add(labelHome3);
				  
				  JLabel labelHome5 = new JLabel("Enter Projct ID");
				  labelHome5.setFont(new Font("Chilanka", Font.BOLD, 13));
				  labelHome5.setBounds(58, 129, 115, 15);
				  desktopPane_5.add(labelHome5);
				  
				  textField_7 = new JTextField();
				  textField_7.setBounds(172, 125, 205, 19);
				  desktopPane_5.add(textField_7);
				  textField_7.setColumns(10);
				  
				  JButton buttonSearch4 = new JButton("Search");
				  buttonSearch.addMouseListener(new MouseAdapter() {
					  // @Override
					  // public void mouseClicked(MouseEvent arg0) {
					  // 	String firId = textField_7.getText();
					  // 	try {
					  // 		// rs = db.search_fir(firId);
					  // 		if(rs == null) {
					  // 			JOptionPane.showMessageDialog(frmHome, "FIR not found");
					  // 		}else {
					  // 			frmHome.setVisible(false);
					  // 			// FIRdisplay.main(null);
					  // 		}
					  // 	} catch (SQLException e) {
					  // 		// TODO Auto-generated catch block
					  // 		JOptionPane.showMessageDialog(frmHome, "Server not responding");
					  // 		e.printStackTrace();
					  // 	}
					  // }
				  });
		
		
		frmHome.setTitle("Home");
		frmHome.setBounds(100, 100, 1500, 732);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
