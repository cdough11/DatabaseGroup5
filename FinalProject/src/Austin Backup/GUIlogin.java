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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Email:");
		lblUsername.setBounds(181, 14, 59, 14);
		frame.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setBounds(149, 39, 120, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(181, 70, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setBounds(149, 95, 120, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton loginBtn = new JButton("Submit");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean valid = User.login(username.getText(), password.getText());
				if(valid) {
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
		loginBtn.setBounds(168, 143, 89, 23);
		frame.getContentPane().add(loginBtn);
	}
}