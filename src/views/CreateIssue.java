package views;

import views.CreateProject;
import views.CreateIssue;
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
import java.awt.List;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class CreateIssue {

	private JFrame frmCreateIssue;
	private JTextField issueName;
	private JTextField title;
	public JButton createProjectBtn;
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
					CreateIssue window = new CreateIssue();
					window.frmCreateIssue.setVisible(true);
					window.frmCreateIssue.setSize(1650,1080);
					window.frmCreateIssue.setLocationRelativeTo(null);
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
	public CreateIssue() throws ClassNotFoundException, SQLException {
		createProjectBtn =  new JButton("Create An Issue") {
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

		frmCreateIssue = new JFrame();
		
		frmCreateIssue.getContentPane().setBackground(Color.WHITE);
		frmCreateIssue.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -118, 300, 1080);
		frmCreateIssue.getContentPane().add(panel);
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
				// CreateIssue.main(null);
				frmCreateIssue.repaint();
				// frmCreateIssue.setVisible(false);

				
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
			frmCreateIssue.setVisible(false);

				
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
				frmCreateIssue.setVisible(false);

				
			}
		});
		JLabel tasklLabel = new JLabel("� Tasks");
		tasklLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateTask.main(null);
				frmCreateIssue.setVisible(false);
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
				JOptionPane.showMessageDialog(frmCreateIssue, "Succesfully Logout.");

				frmCreateIssue.setVisible(false);

				
			}
		});
		lblLogOut.setToolTipText("BACK to login");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmCreateIssue.getContentPane().add(lblLogOut);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("Menu.acceleratorForeground"));
		tabbedPane.setBounds(353, 12, 895, 600);
		frmCreateIssue.getContentPane().add(tabbedPane);
		// Image im = new ImageIcon(this.getClass().getResource("/fir.jpg")).getImage();
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		tabbedPane.addTab("Create An Issuee", null, desktopPane, null);
		
		JLabel lblissueName = new JLabel("* Issue Name ");
		lblissueName.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblissueName.setBounds(52, 54, 174, 21);
		desktopPane.add(lblissueName);
		
		JLabel lblSubject = new JLabel("* Issued Subject");
		lblSubject.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblSubject.setBounds(52, 87, 300, 15);
		desktopPane.add(lblSubject);
		
		JLabel lblComplaintUder = new JLabel("* Select A Project ");
		lblComplaintUder.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblComplaintUder.setBounds(52, 114, 300, 15);
		desktopPane.add(lblComplaintUder);
		
		JLabel lblName = new JLabel("* Issue slug ");
		lblName.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblName.setBounds(52, 141, 300, 15);
		desktopPane.add(lblName);
		
		JLabel lblAddress = new JLabel("* Issue Details");
		lblAddress.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblAddress.setBounds(52, 179, 300, 15);
		desktopPane.add(lblAddress);
		
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
		
		issueName = new JTextField();
		issueName.setBounds(244, 53, 413, 19);
		desktopPane.add(issueName);
		issueName.setColumns(10);
		
		title = new JTextField();
		title.setBounds(244, 83, 271, 19);
		desktopPane.add(title);
		title.setColumns(10);
		
		name = new JTextField();
		name.setBounds(243, 137, 272, 19);
		desktopPane.add(name);
		name.setColumns(10);
		
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
		JComboBox act = new JComboBox();
		act.setBounds(244, 107, 261, 24);
		desktopPane.add(act);
		act.addItem("None");
		act.addItem("Project 1");
		act.addItem("Project 2");
		act.addItem("Project 3");
		act.addItem("Project 4");
		act.addItem("Project 5");
				
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
				// desktopPane.add(details);
				
				JTextArea address = new JTextArea();
				address.setToolTipText("Enter here");
				address.setBackground(Color.LIGHT_GRAY);
				address.setBounds(244, 168, 413, 51);
				desktopPane.add(address);
				createProjectBtn.setPreferredSize(new Dimension(250,35));
				createProjectBtn.setBackground(new Color(66, 245, 114));
				createProjectBtn.setFocusPainted(false);
				
				JButton btnSubmit = new JButton("Submit");
				btnSubmit.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//create the fir
						String firIdString = firId.getText();
						String policeSN = issueName.getText();
						String titles = title.getText();
						String acts = act.getSelectedItem().toString();
						String caseName = name.getText();
						String Address = address.getText();
						String dateAdd = dateAdded.getText();
						String city1 = city.getText();
						String phone = mobile.getText();
						String Email = email.getText();
						// String detail = details.getText();
						
						// try {
						// 	if(projectApi.registerUser(firIdString, policeSN, titles, acts, caseName, Address, dateAdd, city1, phone, Email, detail)) {
						// 		JOptionPane.showMessageDialog(frmCreateIssue, "FIR created successfully!");
						// 	}
						// } catch (SQLException e1) {
						// 	// TODO Auto-generated catch block
						// 	JOptionPane.showMessageDialog(frmCreateIssue, "FIR id already exists!");
						// 	e1.printStackTrace();
						// }
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
						tabbedPane.addTab("Issues So Far.", null, desktopPane_1, null);
						
						JLabel lblHelloUser = new JLabel("* Hello user You can search FIR stored among the Database .");
						lblHelloUser.setForeground(Color.BLACK);
						lblHelloUser.setBackground(Color.BLACK);
						lblHelloUser.setFont(new Font("Chilanka", Font.BOLD, 14));
						lblHelloUser.setBounds(48, 80, 517, 15);
						desktopPane_1.add(lblHelloUser);
						
						JLabel lblEnterFirId = new JLabel("Enter FIR ID ");
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
							// 			JOptionPane.showMessageDialog(frmCreateIssue, "FIR not found");
							// 		}else {
							// 			frmCreateIssue.setVisible(false);
							// 			// FIRdisplay.main(null);
							// 		}
							// 	} catch (SQLException e) {
							// 		// TODO Auto-generated catch block
							// 		JOptionPane.showMessageDialog(frmCreateIssue, "Server not responding");
							// 		e.printStackTrace();
							// 	}
							// }
						});
						
						btnNewButton.setForeground(Color.WHITE);
						btnNewButton.setBackground(Color.BLUE);
						btnNewButton.setBounds(416, 122, 117, 25);
						desktopPane_1.add(btnNewButton);
						
						JLabel lblOr = new JLabel("OR");
						lblOr.setForeground(Color.RED);
						lblOr.setFont(new Font("FreeSerif", Font.BOLD, 17));
						lblOr.setBounds(230, 201, 70, 15);
						desktopPane_1.add(lblOr);
						
						JLabel lblSelectAct = new JLabel("Select ACT");
						lblSelectAct.setBounds(58, 304, 98, 15);
						desktopPane_1.add(lblSelectAct);
						
						JComboBox comboBox_2 = new JComboBox();
						comboBox_2.setBounds(172, 299, 205, 24);
						desktopPane_1.add(comboBox_2);
						
						JButton btnSearch = new JButton("Search");
						btnSearch.setForeground(Color.WHITE);
						btnSearch.setBounds(416, 299, 117, 25);
						desktopPane_1.add(btnSearch);
		
	
	
		
		
		frmCreateIssue.setTitle("Officer CreateIssue ");
		frmCreateIssue.setBounds(100, 100, 1366, 732);
		frmCreateIssue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
