package views;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import views.RoundedCornerBorder;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;
import java.io.*;
import java.io.File;
import java.awt.event.*;

import java.util.regex.Pattern;

public class CreateIssue{
	JFrame jframe;
	// Register register;
	JButton registerButton;
	JButton issueButton;
	JTextField issueTitle;
    JTextField proId;
    JTextField issueSeverity;
	JLabel headerText;
	JPasswordField password;
    JTextField issueDetails;
	JLabel usernameError;
    JTextField assignedTo;
	JLabel passwordError;
	
	
	public CreateIssue() throws IOException{
		jframe = new JFrame("Create issue");
		issueTitle = new JTextField() {
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
		issueDetails = new JTextField() {
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
		assignedTo = new JTextField() {
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
		issueSeverity = new JTextField() {
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
		
		issueButton = new JButton("CREATE ISSUE") {
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
			BufferedImage bufferedImage = ImageIO.read(this.getClass().getResource("../res/image/971.jpg"));
			protected void paintComponent(Graphics g) {
                super.paintComponent(g);
             int x = (getWidth() - bufferedImage.getWidth(this)) / 3;
             int y = (getHeight() - bufferedImage.getHeight(this)) / 3;
				// super.paintComponent(g);
				g.drawImage(bufferedImage,x,y,this);
			}
		});
		init();
	}
	
	public void addEventListeners() {	
		//submit button action listener
		issueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "Username: " + issueTitle.getText();
				data += "\n" + "Password: " + issueDetails.getText();
				JOptionPane.showMessageDialog(null, data);
			}
		});
		
		//issueTitle validation listener
		issueTitle.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(issueTitle.getText().length() > 0 && !issueTitle.getText().equals("Enter your issue name")) {
					if(issueTitle.getText().length() > 5) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("issue name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(issueTitle.getText().length() > 0 && !issueTitle.getText().equals("Enter your issue name")) {
					if((issueTitle.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("proect name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(issueTitle.getText().length() > 0  && !issueTitle.getText().equals("Enter your issue name")) {
					if((issueTitle.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("issue name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
		});
		issueSeverity.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(issueSeverity.getText().length() > 0 && !issueSeverity.getText().equals("Enter your issue name")) {
					if(issueSeverity.getText().length() > 5) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("issue name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(issueSeverity.getText().length() > 0 && !issueSeverity.getText().equals("Enter your issue name")) {
					if((issueSeverity.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("proect name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(issueSeverity.getText().length() > 0  && !issueSeverity.getText().equals("Enter your issue name")) {
					if((issueSeverity.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("issue name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
		});
		issueDetails.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(issueDetails.getText().length() > 0 && !issueDetails.getText().equals("Enter your issue name")) {
					if(issueDetails.getText().length() > 5) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("issue name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue name is not valid");
					}
				}
				else {
					usernameError.setText("");
                    
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(issueDetails.getText().length() > 0 && !issueDetails.getText().equals("Enter your issue name")) {
					if((issueDetails.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("proect name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(issueDetails.getText().length() > 0  && !issueDetails.getText().equals("Enter your issue name")) {
					if((issueDetails.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("issue name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
		});
		
		issueSeverity.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(issueSeverity.getText().length() > 0 && !issueSeverity.getText().equals("Enter your issue status")) {
					if(issueSeverity.getText().length() > 5) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("issue status is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue status is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(issueSeverity.getText().length() > 0 && !issueSeverity.getText().equals("Enter your issue status ")) {
					if((issueSeverity.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("proect status is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue status is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(issueSeverity.getText().length() > 0  && !issueSeverity.getText().equals("Enter your issue status")) {
					if((issueSeverity.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("issue status is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("issue status is not valid");
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
		issueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 jframe.dispose(); // Close the login window
           		//   new Register(); // Open the registration window
				
			}
		});
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 jframe.dispose(); // Close the login window
           		//   new Register(); // Open the registration window
				
			}
		});
		
		
		issueTitle.addFocusListener(new FocusListener() {	
			public void focusLost(FocusEvent e) {
                // issueTitle.setText("");
				if(issueTitle.getText().equals("")) {
					issueTitle.setText("Enter your issue name");
					issueTitle.setForeground(Color.gray);
				}
			}
			
			public void focusGained(FocusEvent e) {
                issueTitle.setText("");
				if(issueTitle.getText().equals("Enter your issue name")) {
					issueTitle.setText("");
					issueTitle.setForeground(Color.black);
				}
			}
		});
		issueDetails.addFocusListener(new FocusListener() {	
			public void focusLost(FocusEvent e) {
				if(issueDetails.getText().equals("")) {
					issueDetails.setText("Enter your issue details");
					issueDetails.setForeground(Color.gray);
				}
			}
			
			public void focusGained(FocusEvent e) {
                issueDetails.setText("");
				if(issueDetails.getText().equals("Enter your issue details")) {
					issueDetails.setText("");
					issueDetails.setForeground(Color.black);
				}
			}
		});
		issueSeverity.addFocusListener(new FocusListener() {	
			public void focusLost(FocusEvent e) {
				if(issueSeverity.getText().equals("")) {
					issueSeverity.setText("Enter your issue status");
					issueSeverity.setForeground(Color.gray);
				}
			}
			
			public void focusGained(FocusEvent e) {
                issueSeverity.setText("");
				if(issueSeverity.getText().equals("Enter your issue status ")) {
					issueSeverity.setText("");
					issueSeverity.setForeground(Color.black);
				}
			}
		});

		
		// password.addFocusListener(new FocusListener() {
			
		// 	public void focusLost(FocusEvent e) {
		// 		if(password.getText().equals("")) {
		// 			password.setText("Enter your password");
		// 			password.setForeground(Color.gray);
		// 			password.setEchoChar((char)0);
		// 		}
		// 	}
			
		// 	public void focusGained(FocusEvent e) {
		// 		if(password.getText().equals("Enter your password")) {
		// 			password.setText("");
		// 			password.setEchoChar('*');
		// 			password.setForeground(Color.black);
		// 		}
		// 	}
		// });
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
	
	public void init() {
		issueTitle.setPreferredSize(new Dimension(320,35));
		issueDetails.setPreferredSize(new Dimension(320,35));
		issueSeverity.setPreferredSize(new Dimension(320,35));
		issueButton.setPreferredSize(new Dimension(320,35));
		issueButton.setBackground(new Color(66, 245, 114));
		issueButton.setFocusPainted(false);
		registerButton.setPreferredSize(new Dimension(250,35));
		registerButton.setBackground(new Color(230, 210, 255));
		registerButton.setFocusPainted(false);
		

		// headerText.setSize()
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Poppins.ttf") );
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
			Font sizedFont = customFont.deriveFont(24f);
			
			headerText.setFont(sizedFont);
			
		}catch(IOException | FontFormatException e) {
            e.printStackTrace();
        }
		headerText.setSize(40,40);
		headerText.setForeground(Color.WHITE);
		
		headerText.setText("Creating Issue?");
		// headerText.setFont(new Font(headerText.getFont().getName(), Font.BOLD, 24));

		

		
		
		issueTitle.setText("Enter your issue name ");
		issueTitle.setForeground(Color.gray);
		issueDetails.setText("Enter your issue details");
		issueDetails.setForeground(Color.gray);
		issueSeverity.setText("Enter your issue status[DONE , STARTED , ON_PROGRESS]");
		issueSeverity.setForeground(Color.gray);
		// password.setEchoChar((char)0);
		
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
		jframe.add(issueTitle,input);
		
		input.gridy = 2;
		input.insets = errorInsets;
		input.anchor = GridBagConstraints.WEST;
		jframe.add(usernameError,input);
		
		input.gridy = 3;
		input.insets = textInsets;
		input.anchor = GridBagConstraints.CENTER;
		jframe.add(issueDetails,input);
		input.gridy = 4;
		input.insets = textInsets;
		input.anchor = GridBagConstraints.CENTER;
		jframe.add(issueSeverity,input);
		
		input.gridy = 5;
		input.insets = errorInsets;
		input.anchor = GridBagConstraints.WEST;
		jframe.add(passwordError,input);
		
		input.insets = buttonInsets;
		input.anchor = GridBagConstraints.WEST;
		input.gridx = 0;
		input.gridy = 6;
		
		// jframe.add(issueButton,input);
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);

		jframe.add(issueButton , input);
	
		panel.add(Box.createVerticalStrut(10)); // Add 10-pixel vertical spacing
		
		
		jframe.pack();
		jframe.setVisible(true);
		
		
		jframe.setSize(950,650);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		// jframe.add(registerButton , input);
		input.insets = buttonInsets;
		input.anchor = GridBagConstraints.WEST;
		input.gridx = 0;
		input.gridy = 6;
		// jframe.add(registerButton , input);
		
		jframe.requestFocus();
		addEventListeners();
	}


    

	
	public static void main(String args[]) {
		try {
			new CreateIssue();
		} catch (IOException e) {
            System.out.println("Error has occured");
			e.printStackTrace();
		}
	}
}
