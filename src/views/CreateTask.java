package views;

import views.CreateProject;
import views.CreateTask;
import views.components.IssueCard;
import views.components.TaskCard;
import views.CreateTask;

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

public class CreateTask {

	private JFrame frmCreateTask;
	private JTextField taskNames;
	private JTextField subjects;
	public JButton createTask;
	private JTextField name;
	private JTextField mobile;
	private JTextField email;
	private JTextField firId;
	private JTextField textField_7;
	private JTextField city;
	private JTextField dateAdded;
	public static ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTask window = new CreateTask();
					window.frmCreateTask.setVisible(true);
					window.frmCreateTask.setSize(1650,1080);
					window.frmCreateTask.setLocationRelativeTo(null);
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
	public CreateTask() throws ClassNotFoundException, SQLException {
		createTask =  new JButton("Create An Task") {
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

		frmCreateTask = new JFrame();
		
		frmCreateTask.getContentPane().setBackground(Color.WHITE);
		frmCreateTask.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -118, 300, 1080);
		frmCreateTask.getContentPane().add(panel);
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
				// CreateTask.main(null);
				frmCreateTask.repaint();
				// frmCreateTask.setVisible(false);

				
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
			frmCreateTask.setVisible(false);

				
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
				CreateTask.main(null);
				frmCreateTask.setVisible(false);

				
			}
		});
		JLabel tasklLabel = new JLabel("💼 Tasks");
		tasklLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateTask.main(null);
				frmCreateTask.setVisible(false);
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
				JOptionPane.showMessageDialog(frmCreateTask, "Succesfully Logout.");

				frmCreateTask.setVisible(false);

				
			}
		});
		lblLogOut.setToolTipText("BACK to login");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmCreateTask.getContentPane().add(lblLogOut);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("Menu.acceleratorForeground"));
		tabbedPane.setBounds(353, 12, 895, 600);
		frmCreateTask.getContentPane().add(tabbedPane);
		// Image im = new ImageIcon(this.getClass().getResource("/fir.jpg")).getImage();
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		tabbedPane.addTab("Create An Issuee", null, desktopPane, null);
		
		JLabel taskLabelName = new JLabel("* Task Name ");
		taskLabelName.setFont(new Font("Chilanka", Font.BOLD, 13));
		taskLabelName.setBounds(52, 54, 174, 21);
		desktopPane.add(taskLabelName);
		
		JLabel lblSubject = new JLabel("* Task Subject");
		lblSubject.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblSubject.setBounds(52, 87, 300, 15);
		desktopPane.add(lblSubject);
		
		JLabel selectProject = new JLabel("* Select A Project ");
		selectProject.setFont(new Font("Chilanka", Font.BOLD, 13));
		selectProject.setBounds(52, 114, 300, 15);
		desktopPane.add(selectProject);
		
		JLabel taskAssigned = new JLabel("* Task Being Assingned to ");
		taskAssigned.setFont(new Font("Chilanka", Font.BOLD, 13));
		taskAssigned.setBounds(52, 141, 300, 15);
		desktopPane.add(taskAssigned);
		
		JLabel taskLabelDetail = new JLabel("* Task Details");
		taskLabelDetail.setFont(new Font("Chilanka", Font.BOLD, 13));
		taskLabelDetail.setBounds(52, 179, 300, 15);
		desktopPane.add(taskLabelDetail);
		
		// JLabel lblCity = new JLabel("* Licensed Under");
		// lblCity.setFont(new Font("Chilanka", Font.BOLD, 13));
		// lblCity.setBounds(52, 247, 300, 15);
		// desktopPane.add(lblCity);
		
		// JLabel lblPhone = new JLabel("* Phone");
		// lblPhone.setFont(new Font("Chilanka", Font.BOLD, 13));
		// lblPhone.setBounds(52, 313, 300 , 15);
		// desktopPane.add(lblPhone);
		
		// JLabel lblEmail = new JLabel("* Version C. Repo Url ");
		// lblEmail.setFont(new Font("Chilanka", Font.BOLD, 13));
		// lblEmail.setBounds(52, 340, 300, 15);
		// desktopPane.add(lblEmail);
		
		taskNames = new JTextField();
		taskNames.setBounds(244, 53, 413, 19);
		desktopPane.add(taskNames);
		taskNames.setColumns(10);
		
		subjects = new JTextField();
		subjects.setBounds(244, 83, 271, 19);
		desktopPane.add(subjects);
		subjects.setColumns(10);
		
		// name = new JTextField();
		// name.setBounds(243, 137, 272, 19);
		// desktopPane.add(name);
		// name.setColumns(10);
		
		// mobile = new JTextField();
		// mobile.setBounds(244, 309, 271, 19);
		// desktopPane.add(mobile);
		// mobile.setColumns(10);
		
		// email = new JTextField();
		// email.setBounds(244, 336, 271, 19);
		// desktopPane.add(email);
		// email.setColumns(10);
		
		//int act[]= {301,302,303,304};
		//Using array set of combobox is not working till ....we will fix this problem .
				ArrayList<ArrayList<String>> listOfProjects = new ArrayList<ArrayList<String>>();
				ArrayList<ArrayList<String>> listOfUsers = new ArrayList<ArrayList<String>>();
				listOfProjects = projectApi.fetchProjects();
				listOfUsers = projectApi.fetchUsers();


			
				JComboBox comboBox = new JComboBox<>();
				DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
				for(int i = 0; i<listOfProjects.size(); i++){
					ArrayList<String> temp = listOfProjects.get(i);
					
					model.addElement(temp.get(0));
				}
				JComboBox comboBox1 = new JComboBox<>();
				DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>();
				for(int i = 0; i<listOfUsers.size(); i++){
					ArrayList<String> temp = listOfUsers.get(i);
					
					model2.addElement(temp.get(0));
				}
				comboBox.setModel(model);
				comboBox1.setBounds(243, 137, 272, 19);
				comboBox1.setModel(model2);
				comboBox.setBounds(244, 107, 261, 24);
				desktopPane.add(comboBox);
				desktopPane.add(comboBox1);
						
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
				
				JTextArea taskDetails = new JTextArea();
				taskDetails.setToolTipText("Enter here");
				taskDetails.setBackground(Color.LIGHT_GRAY);
				taskDetails.setBounds(244, 168, 413, 51);
				desktopPane.add(taskDetails);
				createTask.setPreferredSize(new Dimension(250,35));
				createTask.setBackground(new Color(66, 245, 114));
				createTask.setFocusPainted(false);
				
				JButton btnSubmit = new JButton("Submit");
				createTask.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//create the fir
						// String firIdString = firId.getText();
						String taskName = taskNames.getText();
						String subject = subjects.getText();
						String selectedUser = comboBox1.getSelectedItem().toString();
						String selectedProject = comboBox.getSelectedItem().toString();
						// String acts = act.getSelectedItem().toString();
						// String caseName = name.getText();
						String taskDetail = taskDetails.getText();
						// String dateAdd = dateAdded.getText();
						// String city1 = city.getText();
						// String phone = mobile.getText();
						// String Email = email.getText();
						// String detail = details.getText();
						// System.out.println(taskName);
						// System.out.println(subject);
						// System.out.println(caseName);
						// System.out.println(taskDetails);
						// System.out.println(Email);

						try {
							if(projectApi.createTask(taskName, taskDetail, selectedUser,  selectedProject)) {
								JOptionPane.showMessageDialog(frmCreateTask, "Task has been created successfully!");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(frmCreateTask, "Task id already exists!");
							e1.printStackTrace();
						}
					}
				});
				
				btnSubmit.setForeground(Color.WHITE);
				btnSubmit.setBackground(Color.BLUE);
				btnSubmit.setFont(new Font("Chilanka", Font.BOLD, 14));
				createTask.setBounds(244, 458, 120
				
				, 40);
				desktopPane.add(createTask);
				
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
				
						
						JDesktopPane desktopPane_1 = new JDesktopPane();
						tabbedPane.addTab("Tasks So Far.", null, desktopPane_1, null);
						
						// JLabel lblHelloUser = new JLabel("* Hello user You can search FIR stored among the Database .");
						// lblHelloUser.setForeground(Color.BLACK);
						// lblHelloUser.setBackground(Color.BLACK);
						// lblHelloUser.setFont(new Font("Chilanka", Font.BOLD, 14));
						// lblHelloUser.setBounds(48, 80, 517, 15);
						// desktopPane_1.add(lblHelloUser);
						
						// JLabel lblEnterFirId = new JLabel("Enter FIR ID ");
						// lblEnterFirId.setFont(new Font("Chilanka", Font.BOLD, 13));
						// lblEnterFirId.setBounds(58, 129, 115, 15);
						// desktopPane_1.add(lblEnterFirId);
						
						// textField_7 = new JTextField();
						// textField_7.setBounds(172, 125, 205, 19);
						// desktopPane_1.add(textField_7);
						// textField_7.setColumns(10);
						
						// JButton btnNewButton = new JButton("Search");
						// btnNewButton.addMouseListener(new MouseAdapter() {
						// 	// @Override
							// public void mouseClicked(MouseEvent arg0) {
							// 	String firId = textField_7.getText();
							// 	try {
							// 		// rs = db.search_fir(firId);
							// 		if(rs == null) {
							// 			JOptionPane.showMessageDialog(frmCreateTask, "FIR not found");
							// 		}else {
							// 			frmCreateTask.setVisible(false);
							// 			// FIRdisplay.main(null);
							// 		}
							// 	} catch (SQLException e) {
							// 		// TODO Auto-generated catch block
							// 		JOptionPane.showMessageDialog(frmCreateTask, "Server not responding");
							// 		e.printStackTrace();
							// 	}
							// }
						// });
						
						// btnNewButton.setForeground(Color.WHITE);
						// btnNewButton.setBackground(Color.BLUE);
						// btnNewButton.setBounds(416, 122, 117, 25);
						// desktopPane_1.add(btnNewButton);
						
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
		
	
	
		      			ArrayList<ArrayList<String>> taskAssignedToU = projectApi.fetchTasks(Login.userProfile);

						
                        // JDesktopPane desktopPane_2= new JDesktopPane();
						tabbedPane.addTab("Task Assigned To You", null, desktopPane_1, null);
						int start = 70;
						if(taskAssignedToU.size() == 0){
							
							JLabel labels = new JLabel("<html><body><p style='width: 320px; height:500px; background-color:white;'> <h1 style='font-weight:'bold'; color:red;'>❌ You dont have any task assigned to you.</h1></p></body></html>");
							labels.setBounds(0 , start+20 , 600 , 2000);
							desktopPane_1.add(labels);
						}
						else {
							
						
						for(int i = 0; i < taskAssignedToU.size(); i ++) {
								ArrayList<String> temp = taskAssignedToU.get(0);
								String res ;
								JLabel labels = new JLabel("Hello");
							
								// res = apiController.fetchUserProjectDetails(Integer.parseInt(temp.get(6)));
							    TaskCard newCard = new views.components.TaskCard(temp.get(0) , temp.get(1) , temp.get(2) , temp.get(3) , temp.get(4) , new Dimension(500 , 200 )) ;
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
					}
	
		
		frmCreateTask.setName("Create Task ");
		frmCreateTask.setBounds(100, 100, 1366, 732);
		frmCreateTask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
