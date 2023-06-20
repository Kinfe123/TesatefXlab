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

public class CreateTask{
	JFrame jframe;
	// Register register;
	JButton registerButton;
	JButton taskButton;
	JTextField taskNam;
    JTextField taskStatus;
	JLabel headerText;
	JPasswordField password;
    JTextField taskDetail;
	JLabel usernameError;
	JLabel passwordError;
	
	
	public CreateTask() throws IOException{
		jframe = new JFrame("Create Task");
		taskNam = new JTextField() {
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
		taskDetail = new JTextField() {
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
		taskStatus = new JTextField() {
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
		
		taskButton = new JButton("CREATE TASK") {
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
		taskButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "Username: " + taskNam.getText();
				data += "\n" + "Password: " + taskDetail.getText();
				JOptionPane.showMessageDialog(null, data);
			}
		});
		
		//taskNam validation listener
		taskNam.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(taskNam.getText().length() > 0 && !taskNam.getText().equals("Enter your task name")) {
					if(taskNam.getText().length() > 5) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("task name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("task name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(taskNam.getText().length() > 0 && !taskNam.getText().equals("Enter your task name")) {
					if((taskNam.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("proect name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("task name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(taskNam.getText().length() > 0  && !taskNam.getText().equals("Enter your task name")) {
					if((taskNam.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("task name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("task name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
		});
		taskDetail.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(taskDetail.getText().length() > 0 && !taskDetail.getText().equals("Enter your task name")) {
					if(taskDetail.getText().length() > 5) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("task name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("task name is not valid");
					}
				}
				else {
					usernameError.setText("");
                    
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(taskDetail.getText().length() > 0 && !taskDetail.getText().equals("Enter your task name")) {
					if((taskDetail.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("proect name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("task name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(taskDetail.getText().length() > 0  && !taskDetail.getText().equals("Enter your task name")) {
					if((taskDetail.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("task name is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("task name is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
		});
		
		taskStatus.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				if(taskStatus.getText().length() > 0 && !taskStatus.getText().equals("Enter your task status")) {
					if(taskStatus.getText().length() > 5) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("task status is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("task status is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void insertUpdate(DocumentEvent e) {
				if(taskStatus.getText().length() > 0 && !taskStatus.getText().equals("Enter your task status ")) {
					if((taskStatus.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("proect status is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("task status is not valid");
					}
				}
				else {
					usernameError.setText("");
				}
			}
			
			public void changedUpdate(DocumentEvent e) {
				if(taskStatus.getText().length() > 0  && !taskStatus.getText().equals("Enter your task status")) {
					if((taskStatus.getText().length() > 5)) {
						usernameError.setForeground(new Color(50, 168, 58));
						usernameError.setText("task status is valid");
					}
					else {
						usernameError.setForeground(Color.RED);
						usernameError.setText("task status is not valid");
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
		taskButton.addActionListener(new ActionListener() {
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
		
		
		taskNam.addFocusListener(new FocusListener() {	
			public void focusLost(FocusEvent e) {
                // taskNam.setText("");
				if(taskNam.getText().equals("")) {
					taskNam.setText("Enter your task name");
					taskNam.setForeground(Color.gray);
				}
			}
			
			public void focusGained(FocusEvent e) {
                taskNam.setText("");
				if(taskNam.getText().equals("Enter your task name")) {
					taskNam.setText("");
					taskNam.setForeground(Color.black);
				}
			}
		});
		taskDetail.addFocusListener(new FocusListener() {	
			public void focusLost(FocusEvent e) {
				if(taskDetail.getText().equals("")) {
					taskDetail.setText("Enter your task details");
					taskDetail.setForeground(Color.gray);
				}
			}
			
			public void focusGained(FocusEvent e) {
                taskDetail.setText("");
				if(taskDetail.getText().equals("Enter your task details")) {
					taskDetail.setText("");
					taskDetail.setForeground(Color.black);
				}
			}
		});
		taskStatus.addFocusListener(new FocusListener() {	
			public void focusLost(FocusEvent e) {
				if(taskStatus.getText().equals("")) {
					taskStatus.setText("Enter your task status");
					taskStatus.setForeground(Color.gray);
				}
			}
			
			public void focusGained(FocusEvent e) {
                taskStatus.setText("");
				if(taskStatus.getText().equals("Enter your task status ")) {
					taskStatus.setText("");
					taskStatus.setForeground(Color.black);
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
		taskNam.setPreferredSize(new Dimension(320,35));
		taskDetail.setPreferredSize(new Dimension(320,35));
		taskStatus.setPreferredSize(new Dimension(320,35));
		taskButton.setPreferredSize(new Dimension(320,35));
		taskButton.setBackground(new Color(66, 245, 114));
		taskButton.setFocusPainted(false);
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
		
		headerText.setText("LOGIN");
		// headerText.setFont(new Font(headerText.getFont().getName(), Font.BOLD, 24));

		

		
		
		taskNam.setText("Enter your task name ");
		taskNam.setForeground(Color.gray);
		taskDetail.setText("Enter your task details");
		taskDetail.setForeground(Color.gray);
		taskStatus.setText("Enter your task status[DONE , STARTED , ON_PROGRESS]");
		taskStatus.setForeground(Color.gray);
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
		jframe.add(taskNam,input);
		
		input.gridy = 2;
		input.insets = errorInsets;
		input.anchor = GridBagConstraints.WEST;
		jframe.add(usernameError,input);
		
		input.gridy = 3;
		input.insets = textInsets;
		input.anchor = GridBagConstraints.CENTER;
		jframe.add(taskDetail,input);
		input.gridy = 4;
		input.insets = textInsets;
		input.anchor = GridBagConstraints.CENTER;
		jframe.add(taskStatus,input);
		
		input.gridy = 5;
		input.insets = errorInsets;
		input.anchor = GridBagConstraints.WEST;
		jframe.add(passwordError,input);
		
		input.insets = buttonInsets;
		input.anchor = GridBagConstraints.WEST;
		input.gridx = 0;
		input.gridy = 6;
		
		// jframe.add(taskButton,input);
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);

		jframe.add(taskButton , input);
	
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
			new CreateTask();
		} catch (IOException e) {
            System.out.println("Error has occured");
			e.printStackTrace();
		}
	}
}
