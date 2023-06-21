package views;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controllers.ProjectController;
import views.RoundedCornerBorder;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.*;
import java.io.*;
import java.io.File;
import java.awt.event.*;

import java.util.regex.Pattern;

public class Register{
	JFrame jframe;
	// Register register;
	JButton registerButton;
	JButton loginButton;
	JTextField email;
	JLabel headerText;
	JPasswordField password;
    JTextField username;
	JLabel usernameError;
	JLabel passwordError;
	JTextField fullname;

	
	
	public Register() throws IOException ,  ClassNotFoundException , SQLException{
		jframe = new JFrame("Register Form");
		ProjectController projectApi = new ProjectController();
		email = new JTextField() {
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
		fullname = new JTextField() {
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
		username = new JTextField() {
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
		password = new JPasswordField() {
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
		
		loginButton = new JButton("LOGIN") {
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
		registerButton = new JButton("REGISTER") {
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
		usernameError = new JLabel();
		passwordError = new JLabel();
		headerText = new JLabel();
	
		
		jframe.setContentPane(new JPanel() {
			BufferedImage bufferedImage = ImageIO.read(this.getClass().getResource("../res/image/background.jpg"));
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bufferedImage,0,0,this);
			}
		});
		init();
	}
	
	public void addEventListeners() throws ClassNotFoundException, SQLException {	
	    ProjectController projectApi = new ProjectController();
		//submit button action listener
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "Username: " + email.getText();
				data += "\n" + "Password: " + password.getText();
				JOptionPane.showMessageDialog(null, data);
			}
		});
		
		//email validation listener
		email.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(email.getText().length() > 0 && !email.getText().equals("Enter your email")) {
					if(validateMail(email.getText())) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("Email is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("Email is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(email.getText().length() > 0 && !email.getText().equals("Enter your email")) {
					if(validateMail(email.getText())) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("Email is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("Email is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(email.getText().length() > 0  && !email.getText().equals("Enter your email")) {
					if(validateMail(email.getText())) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("Email is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("Email is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
		});
		
		username.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(username.getText().length() > 0 && !username.getText().equals("Enter your username")) {
					if((username.getText().length()>8)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("username is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("username is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(username.getText().length() > 0 && !username.getText().equals("Enter your username")) {
					if((username.getText().length() > 6)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("username is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("username is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(username.getText().length() > 0  && !username.getText().equals("Enter your username")) {
					if((username.getText().length() > 8)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("username is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("username is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
		});
		fullname.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(fullname.getText().length() > 0 && !fullname.getText().equals("Enter your fullname")) {
					if((fullname.getText().length() > 6)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("fullname is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("fullname is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(fullname.getText().length() > 0 && !fullname.getText().equals("Enter your fullname")) {
					if((fullname.getText().length() > 6)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("fullname is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("fullname is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(fullname.getText().length() > 0  && !fullname.getText().equals("Enter your fullname")) {
					if((fullname.getText().length() > 6)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("fullname is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("fullnaame is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
		});
		
		//password validation listener
		password.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(password.getText().length() > 0  && !password.getText().equals("Enter your password")) {
					if(validatePassword(password.getText())) {
						passwordError.setForeground(new Color(50, 168, 58));
						passwordError.setText("Password is valid");
					}
				}
				else {
					passwordError.setText("");
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(password.getText().length() > 0  && !password.getText().equals("Enter your password")) {
					if(validatePassword(password.getText())) {
						passwordError.setForeground(new Color(50, 168, 58));
						passwordError.setText("Password is valid");
					}
				}
				else {
					passwordError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(password.getText().length() > 0  && !password.getText().equals("Enter your password")) {
					if(validatePassword(password.getText())) {
						passwordError.setForeground(new Color(50, 168, 58));
						passwordError.setText("Password is valid");
					}
				}
				else {
					passwordError.setText("");
				}
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 jframe.dispose(); // Close the login window
           		//   new Register(); // Open the registration window
				
			}
		});
		registerButton.addActionListener(new ActionListener() {
			// ProjectController projectApi = newe ProjectController()
			@Override
            public void actionPerformed(ActionEvent e) {
				System.out.println("USername: " + email.getText());
				System.out.println("Password: " +  password.getText());

                String email_ = email.getText();
                String passcode = new String(password.getText());
				String fullName = fullname.getText();
                String words[] = fullname.getText().split(" ");
				// String username = words[0] + "tesatef";
				String userName = username.getText();



			

               try {
				    
					if(projectApi.registerUser(userName, fullName ,  email_ ,passcode  )) {
						
						Home.main(null);
						jframe.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(jframe.getContentPane(), "Please enter valid login details");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
				
				//  jframe.dispose(); // Close the login window
           		//   new Register(); // Open the registration window
				
		
		});
		
		
		email.addFocusListener(new FocusListener() {	
			public void focusLost(FocusEvent e) {
				if(email.getText().equals("")) {
					email.setText("Enter your email");
					email.setForeground(Color.gray);
				}
			}
			
			public void focusGained(FocusEvent e) {
				if(email.getText().equals("Enter your email")) {
					email.setText("");
					email.setForeground(Color.black);
				}
			}
		});
		username.addFocusListener(new FocusListener() {	
			public void focusLost(FocusEvent e) {
				if(username.getText().equals("")) {
					username.setText("Enter your username");
					username.setForeground(Color.gray);
				}
			}
			
			public void focusGained(FocusEvent e) {
				if(username.getText().equals("Enter your username")) {
					username.setText("");
					username.setForeground(Color.black);
				}
			}
		});
		fullname.addFocusListener(new FocusListener() {	
			public void focusLost(FocusEvent e) {
				if(fullname.getText().equals("")) {
					fullname.setText("Enter your fullanme");
					fullname.setForeground(Color.gray);
				}
			}
			
			public void focusGained(FocusEvent e) {
				if(fullname.getText().equals("Enter your fullname")) {
					fullname.setText("");
					fullname.setForeground(Color.black);
				}
			}
		});

		
		password.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				if(password.getText().equals("")) {
					password.setText("Enter your password");
					password.setForeground(Color.gray);
					password.setEchoChar((char)0);
				}
			}
			
			public void focusGained(FocusEvent e) {
				if(password.getText().equals("Enter your password")) {
					password.setText("");
					password.setEchoChar('*');
					password.setForeground(Color.black);
				}
			}
		});
	}
	
	private boolean validateMail(String mail) {
		String regExp = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                        "[a-zA-Z0-9_+&*-]+)*@" + 
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                        "A-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regExp);
		return pattern.matcher(mail).matches();
	}
	
	private boolean validatePassword(String text) {
		passwordError.setForeground(Color.RED);
		if(text.length() < 8) {
			passwordError.setText("Password must be of length 8");
			return false;
		}
		else if(!text.matches(".*[a-zA-Z]+.*")) {
			passwordError.setText("Password must contain alphabates");
			return false;
		}
		else if(!text.matches(".*\\d.*")) {
			passwordError.setText("Password must contain digits");
			return false;
		}
		
		else 
			return true;
	}
	
	public void init() throws ClassNotFoundException, SQLException {
		email.setPreferredSize(new Dimension(250,35));
		password.setPreferredSize(new Dimension(250,35));
		username.setPreferredSize(new Dimension(250,35));
		fullname.setPreferredSize(new Dimension(250,35));
		loginButton.setPreferredSize(new Dimension(250,35));
		loginButton.setBackground(new Color(66, 245, 114));
		loginButton.setFocusPainted(false);
		registerButton.setPreferredSize(new Dimension(250,35));
		registerButton.setBackground(new Color(230, 210, 255));
		registerButton.setFocusPainted(false);
		

		// headerText.setSize()
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins.ttf"));
			Font sizedFont = customFont.deriveFont(24f);
			headerText.setForeground(Color.	WHITE);
			headerText.setText("LOGIN");
			headerText.setFont(sizedFont);
			
		}catch(IOException | FontFormatException e) {
            e.printStackTrace();
        }
		headerText.setSize(100,100);
    
		headerText.setForeground(Color.WHITE);
		
		headerText.setText("REGISTER");
		// headerText.setFont(new Font(headerText.getFont().getName(), Font.BOLD, 24));

		

		
		
		email.setText("Enter your email");
		email.setForeground(Color.gray);
		password.setText("Enter your password");
		password.setForeground(Color.gray);
    
		username.setText("Enter your username");
		username.setForeground(Color.gray);
		fullname.setText("Enter your fullname");
		fullname.setForeground(Color.gray);
    
		password.setEchoChar((char)0);
		
		usernameError.setFont(new Font("SansSerif", Font.BOLD, 11));
		usernameError.setForeground(Color.RED);
		
		passwordError.setFont(new Font("SansSerif", Font.BOLD, 11));
		passwordError.setForeground(Color.RED);
		jframe.add(headerText);
		
		jframe.setLayout(new GridBagLayout());
		
		Insets textInsets = new Insets(10, 10, 5, 10);
		Insets buttonInsets = new Insets(20, 10, 10, 10);
		Insets errorInsets = new Insets(0,20,0,0);
		
		GridBagConstraints input = new GridBagConstraints();
        input.anchor = GridBagConstraints.CENTER;
		input.insets = textInsets;
		input.gridy = 1;
		jframe.add(email,input);

		input.anchor = GridBagConstraints.CENTER;
		input.insets = textInsets;
		input.gridy = 2;
		jframe.add(username,input);
		
		input.gridy = 3;
		input.insets = errorInsets;
		input.anchor = GridBagConstraints.WEST;
		jframe.add(usernameError,input);
		
		
		input.gridy = 4;
		input.insets = textInsets;
		input.anchor = GridBagConstraints.CENTER;
		jframe.add(password,input);
		input.gridy = 5;
		input.insets = textInsets;
		input.anchor = GridBagConstraints.CENTER;
		jframe.add(fullname,input);
		input.gridy = 6;
		input.insets = errorInsets;
		input.anchor = GridBagConstraints.WEST;
		jframe.add(passwordError,input);
		
		input.insets = buttonInsets;
		input.anchor = GridBagConstraints.WEST;
		input.gridx = 0;
		input.gridy = 7;
		
		

		
		
		jframe.setSize(950,650);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		// jframe.add(registerButton , input);
		input.insets = buttonInsets;
		input.anchor = GridBagConstraints.WEST;
		input.gridx = 0;
		input.gridy = 8;
		jframe.add(registerButton , input);
		
		jframe.requestFocus();
		addEventListeners();
	}


    

	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		try {
			new Register();
		} catch (IOException e) {
            System.out.println("Error has occured");
			e.printStackTrace();
		}
	}
}
