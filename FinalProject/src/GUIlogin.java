import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import songsDAC.User;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GUIlogin {

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	public static User loggedInUser;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIlogin window = new GUIlogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 282);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Email:");
		lblUsername.setBounds(198, 31, 59, 14);
		frame.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setBounds(108, 57, 221, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(187, 89, 88, 14);
		frame.getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setBounds(108, 115, 221, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton loginBtn = new JButton("Submit");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean valid = User.login(username.getText(), password.getText());
				if(valid) {
					loggedInUser = new User(username.getText(), password.getText());
					if(User.currentUserIsModerator) {
						ModeratorGUI window = new ModeratorGUI();
						window.makeVisible();
					}
					else {
						GeneralUserGUI window = new GeneralUserGUI();
						window.makeVisible();
					}
				}
					
			}
		});
		loginBtn.setBounds(168, 171, 89, 23);
		frame.getContentPane().add(loginBtn);
		
		btnNewButton = new JButton("Register New User");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterUser window = new RegisterUser();
				window.makeVisible();
			}
		});
		btnNewButton.setBounds(154, 194, 121, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
