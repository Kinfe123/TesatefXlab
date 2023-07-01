package views;

import views.CreateProject;
import views.CreateIssue;
import views.CreateTask;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import DB_CONN.*;
import controllers.ProjectController;

import javax.swing.JDesktopPane;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.List;
import java.awt.TextArea;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Users {

	private JFrame frmUsers;
	private JTextField policeStationName;
	private JTextField title;
	private JTextField name;
	private JTextField mobile;
	private JTextField email;
	private JTextField firId;
	private JTextField textField_7;
	private JTextField city;
	private JTextField dateAdded;
	public static ResultSet rs;
    private JList<String> list;
    private  DefaultListModel<String> listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users window = new Users();
					window.frmUsers.setVisible(true);
					window.frmUsers.setSize(1650,1080);
					window.frmUsers.setLocationRelativeTo(null);
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
	public Users() throws ClassNotFoundException, SQLException {
		initialize();
       

    
        // setLocationRelativeTo(null);
        // setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		// CrimeDB_Functions db = new CrimeDB_Functions();
		ProjectController projectApi = new ProjectController();

		frmUsers = new JFrame();


		
		frmUsers.getContentPane().setBackground(Color.WHITE);
		frmUsers.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -118, 300, 1080);
		frmUsers.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCrimeInvestigationSystem = new JLabel("TESATEF X Lab. ");
		lblCrimeInvestigationSystem.setBounds(36, 147, 252, 31);
		lblCrimeInvestigationSystem.setForeground(new Color(255, 255, 255));
		panel.add(lblCrimeInvestigationSystem);
		lblCrimeInvestigationSystem.setFont(new Font("Chandas", Font.BOLD, 16));
		
		JLabel label = new JLabel("________________________________________________");
		label.setBounds(36, 166, 276, 31);
		label.setFont(new Font("Dialog", Font.BOLD, 10));
		label.setForeground(new Color(255, 255, 255));
		panel.add(label);
		
		JLabel lblFir = new JLabel("📚 Projects ");
		lblFir.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblFir.setForeground(new Color(255, 255, 255));
		lblFir.setBackground(new Color(255, 255, 255));
		lblFir.setBounds(36, 236, 99, 15);
		panel.add(lblFir);
		
		JLabel labelUser = new JLabel("🤼 Users.");
		labelUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Home.main(null);
			frmUsers.setVisible(false);

				
			}
		});
		labelUser.setFont(new Font("Chilanka", Font.BOLD, 14));
		labelUser.setForeground(new Color(255, 255, 255));
		labelUser.setBounds(36, 266, 139, 15);
		panel.add(labelUser);
		
		JLabel lblCases = new JLabel("🤔 Issue");
		lblCases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateIssue.main(null);
				frmUsers.setVisible(false);

				
			}
		});
		lblCases.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblCases.setForeground(new Color(255, 255, 255));
		lblCases.setBounds(36, 293, 70, 15);
		panel.add(lblCases);
		
		JLabel userProfile = new JLabel("");
		userProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userProfile.setForeground(Color.WHITE);
		userProfile.setText(Login.userProfile);
		System.out.println(Login.userProfile);
		userProfile.setBounds(36, 758, 214, 31);
		panel.add(userProfile);
		
		
		
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
				JOptionPane.showMessageDialog(frmUsers, "Succesfully Logout.");

				frmUsers.setVisible(false);

				
			}
		});
		lblLogOut.setToolTipText("Bck to Officer login login?");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmUsers.getContentPane().add(lblLogOut);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("Menu.acceleratorForeground"));
		tabbedPane.setBounds(353, 12, 895, 600);
		frmUsers.getContentPane().add(tabbedPane);
		// Image im = new ImageIcon(this.getClass().getResource("/fir.jpg")).getImage();
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		tabbedPane.addTab("User Contributing", null, desktopPane, null);
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data = projectApi.fetchUsers();
        JPanel panels = new JPanel(new GridLayout(data.size(), 1)); // create a JPanel with a GridLayout that can hold all the users
        JLabel userContri = new JLabel();
        JLabel lblHeyUser = new JLabel("🤼 Active Contributors and Collaborators");
		lblHeyUser.setForeground(new Color(25, 25, 112));
		lblHeyUser.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblHeyUser.setBounds(350, 277, 515, 24);

       
		// frmUsers.getContentPane().add(lblHeyUser);
        // int start = 50;
        // for (ArrayList<String> user : data) {
        //     if(user.size() == 2){
        //         String name = user.get(0);
        //         String labelText =  ", Name: " + user.get(0) + ", Email: " + user.get(1); // create a label text
        //         userContri = new JLabel(name);
        //         userContri.setBounds(350 + start, 277 + start, 515, 24);
                
        //         // create a JLabel with the label text
        //         panels.add(userContri); // add the JLabel to the panel
        //         start+=100;
        //         System.out.println(name);
        //     }
        // }
       
    
        JFrame frame = new JFrame( );
 
      
        // Create the list model
        listModel = new DefaultListModel<String>();

        // Iterate through the list and add the items to the list model
        String[] items = {"Item 1", "Item 2", "Item 3"};
        for (String item : items) {
            listModel.addElement(item);
        }

        // Create the JList and set its model
        list = new JList<String>(listModel);

        // Add the JList to the content pane
        frame.getContentPane().add(new JScrollPane(list));

        frame.add(list);












        // JScrollPane scrollPane = new JScrollPane(panels);
        // desktopPane.add(scrollPane);
     



        // frame.add(scrollPane);



		JLabel label1 = new JLabel("💻 KINFEMICHAEL TARIKU ➡ Frontend & MVC guy ");
		label1.setFont(new Font("Chilanka", Font.BOLD, 13));
		label1.setBounds(52, 64, 400, 21);
		desktopPane.add(label1);
		
		JLabel label2 = new JLabel("💻 SAMMY GOOSA  ➡  Frontend & SQL guy.");
		label2.setFont(new Font("Chilanka", Font.BOLD, 13));
		label2.setBounds(52, 87, 400, 15);
		desktopPane.add(label2);
		
		JLabel label3 = new JLabel("💻 YEAMLAKNEH. ➡  Frontend & Cordinator guy ");
		label3.setFont(new Font("Chilanka", Font.BOLD, 13));
		label3.setBounds(52, 114, 400, 15);
		desktopPane.add(label3);
		
		JLabel label4 = new JLabel("💻 YARED BITEWLIGN. ➡  Frontend & SQL guy ");
		label4.setFont(new Font("Chilanka", Font.BOLD, 13));
		label4.setBounds(52, 141, 400, 15);
		desktopPane.add(label4);
		
		// JLabel lblName = new JLabel("* Name ");
		// lblName.setFont(new Font("Chilanka", Font.BOLD, 13));
		// lblName.setBounds(52, 141, 70, 15);
		// desktopPane.add(lblName);
		
		// JLabel lblAddress = new JLabel("* Address");
		// lblAddress.setFont(new Font("Chilanka", Font.BOLD, 13));
		// lblAddress.setBounds(52, 179, 154, 15);
		// desktopPane.add(lblAddress);
		
		// JLabel lblCity = new JLabel("* City Area");
		// lblCity.setFont(new Font("Chilanka", Font.BOLD, 13));
		// lblCity.setBounds(52, 247, 126, 15);
		// desktopPane.add(lblCity);
		
		// JLabel lblPhone = new JLabel("* Phone");
		// lblPhone.setFont(new Font("Chilanka", Font.BOLD, 13));
		// lblPhone.setBounds(52, 313, 70, 15);
		// desktopPane.add(lblPhone);
		
		// JLabel lblEmail = new JLabel("* Email ");
		// lblEmail.setFont(new Font("Chilanka", Font.BOLD, 13));
		// lblEmail.setBounds(52, 340, 70, 15);
		// desktopPane.add(lblEmail);
		
		// policeStationName = new JTextField();
		// policeStationName.setBounds(244, 53, 413, 19);
		// desktopPane.add(policeStationName);
		// policeStationName.setColumns(10);
		
		// title = new JTextField();
		// title.setBounds(244, 83, 271, 19);
		// desktopPane.add(title);
		// title.setColumns(10);
		
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
		
		// //int act[]= {301,302,303,304};
		//Using array set of combobox is not working till ....we will fix this problem .
		// JComboBox act = new JComboBox();
		// act.setBounds(244, 107, 261, 24);
		// desktopPane.add(act);
		// act.addItem("None");
		// act.addItem(301);
		// act.addItem(302);
		// act.addItem(303);
				
		// 		JLabel lblNewLabel = new JLabel("FIR label");
		// 		lblNewLabel.setBounds(675, 35, 203, 169);
		// 		// desktopPane.add(lblNewLabel);
		// 		// lblNewLabel.setIcon(new ImageIcon(im));
				
		// 		JLabel lblDetails = new JLabel("* Details");
		// 		lblDetails.setFont(new Font("Chilanka", Font.BOLD, 13));
		// 		lblDetails.setBounds(52, 378, 70, 15);
		// 		desktopPane.add(lblDetails);
				
		// 		JTextArea details = new JTextArea();
		// 		details.setToolTipText("Enter Here");
		// 		details.setBackground(Color.LIGHT_GRAY);
		// 		details.setBounds(244, 376, 413, 76);
		// 		desktopPane.add(details);
				
		// 		JTextArea address = new JTextArea();
		// 		address.setToolTipText("Enter here");
		// 		address.setBackground(Color.LIGHT_GRAY);
		// 		address.setBounds(244, 168, 413, 51);
		// 		desktopPane.add(address);
				
		// 		JButton btnSubmit = new JButton("Submit");
		// 		btnSubmit.addMouseListener(new MouseAdapter() {
		// 			@Override
		// 			public void mouseClicked(MouseEvent e) {
		// 				//create the fir
		// 				String firIdString = firId.getText();
		// 				String policeSN = policeStationName.getText();
		// 				String titles = title.getText();
		// 				String acts = act.getSelectedItem().toString();
		// 				String caseName = name.getText();
		// 				String Address = address.getText();
		// 				String dateAdd = dateAdded.getText();
		// 				String city1 = city.getText();
		// 				String phone = mobile.getText();
		// 				String Email = email.getText();
		// 				String detail = details.getText();
						
		// 				// try {
		// 				// 	if(projectApi.registerUser(firIdString, policeSN, titles, acts, caseName, Address, dateAdd, city1, phone, Email, detail)) {
		// 				// 		JOptionPane.showMessageDialog(frmUsers, "FIR created successfully!");
		// 				// 	}
		// 				// } catch (SQLException e1) {
		// 				// 	// TODO Auto-generated catch block
		// 				// 	JOptionPane.showMessageDialog(frmUsers, "FIR id already exists!");
		// 				// 	e1.printStackTrace();
		// 				// }
		// 			}
		// 		});
		// 		btnSubmit.setForeground(Color.WHITE);
		// 		btnSubmit.setBackground(Color.BLUE);
		// 		btnSubmit.setFont(new Font("Chilanka", Font.BOLD, 14));
		// 		btnSubmit.setBounds(244, 458, 117, 25);
		// 		desktopPane.add(btnSubmit);
				
		// 		JLabel lblFirId = new JLabel("* FIR ID");
		// 		lblFirId.setFont(new Font("Chilanka", Font.BOLD, 13));
		// 		lblFirId.setBounds(52, 22, 70, 15);
		// 		desktopPane.add(lblFirId);
				
		// 		firId = new JTextField();
		// 		firId.setBounds(244, 22, 114, 19);
		// 		desktopPane.add(firId);
		// 		firId.setColumns(10);
				
		// 		city = new JTextField();
		// 		city.setBounds(244, 245, 195, 21);
		// 		desktopPane.add(city);
		// 		city.setColumns(10);
				
		// 		dateAdded = new JTextField();
		// 		dateAdded.setColumns(10);
		// 		dateAdded.setBounds(244, 277, 114, 19);
		// 		desktopPane.add(dateAdded);
				
		// 		JLabel label_1 = new JLabel("DD/MM/YYYY");
		// 		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		// 		label_1.setBounds(373, 279, 99, 15);
		// 		desktopPane.add(label_1);
				
		// 		JLabel lblDate = new JLabel("* Date");
		// 		lblDate.setFont(new Font("Dialog", Font.BOLD, 13));
		// 		lblDate.setBounds(52, 280, 126, 15);
		// 		desktopPane.add(lblDate);
				
						
		// 				JDesktopPane desktopPane_1 = new JDesktopPane();
		// 				tabbedPane.addTab("Search FIR", null, desktopPane_1, null);
						
		// 				JLabel lblHelloUser = new JLabel("* Hello user You can search FIR stored among the Database .");
		// 				lblHelloUser.setForeground(Color.GREEN);
		// 				lblHelloUser.setBackground(Color.GREEN);
		// 				lblHelloUser.setFont(new Font("Chilanka", Font.BOLD, 14));
		// 				lblHelloUser.setBounds(48, 80, 517, 15);
		// 				desktopPane_1.add(lblHelloUser);
						
		// 				JLabel lblEnterFirId = new JLabel("Enter FIR ID ");
		// 				lblEnterFirId.setFont(new Font("Chilanka", Font.BOLD, 13));
		// 				lblEnterFirId.setBounds(58, 129, 115, 15);
		// 				desktopPane_1.add(lblEnterFirId);
						
		// 				textField_7 = new JTextField();
		// 				textField_7.setBounds(172, 125, 205, 19);
		// 				desktopPane_1.add(textField_7);
		// 				textField_7.setColumns(10);
						
		// 				JButton btnNewButton = new JButton("Search");
		// 				btnNewButton.addMouseListener(new MouseAdapter() {
		// 					// @Override
		// 					// public void mouseClicked(MouseEvent arg0) {
		// 					// 	String firId = textField_7.getText();
		// 					// 	try {
		// 					// 		// rs = db.search_fir(firId);
		// 					// 		if(rs == null) {
		// 					// 			JOptionPane.showMessageDialog(frmUsers, "FIR not found");
		// 					// 		}else {
		// 					// 			frmUsers.setVisible(false);
		// 					// 			// FIRdisplay.main(null);
		// 					// 		}
		// 					// 	} catch (SQLException e) {
		// 					// 		// TODO Auto-generated catch block
		// 					// 		JOptionPane.showMessageDialog(frmUsers, "Server not responding");
		// 					// 		e.printStackTrace();
		// 					// 	}
		// 					// }
		// 				});
		// 				btnNewButton.setForeground(Color.WHITE);
		// 				btnNewButton.setBackground(Color.BLUE);
		// 				btnNewButton.setBounds(416, 122, 117, 25);
		// 				desktopPane_1.add(btnNewButton);
						
		// 				JLabel lblOr = new JLabel("OR");
		// 				lblOr.setForeground(Color.RED);
		// 				lblOr.setFont(new Font("FreeSerif", Font.BOLD, 17));
		// 				lblOr.setBounds(230, 201, 70, 15);
		// 				desktopPane_1.add(lblOr);
						
		// 				JLabel lblSelectAct = new JLabel("Select ACT");
		// 				lblSelectAct.setBounds(58, 304, 98, 15);
		// 				desktopPane_1.add(lblSelectAct);
						
		// 				JComboBox comboBox_2 = new JComboBox();
		// 				comboBox_2.setBounds(172, 299, 205, 24);
		// 				desktopPane_1.add(comboBox_2);
						
		// 				JButton btnSearch = new JButton("Search");
		// 				btnSearch.setForeground(Color.WHITE);
		// 				btnSearch.setBounds(416, 299, 117, 25);
		// 				desktopPane_1.add(btnSearch);
		
	
	
		
		
		frmUsers.setTitle("User Contribution. ");
		frmUsers.setBounds(100, 100, 1366, 732);
		frmUsers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
