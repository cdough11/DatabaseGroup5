import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import songsDAC.User;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterUser {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField age;
	private JTextField email;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUser window = new RegisterUser();
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
	public RegisterUser() {
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
		
		firstName = new JTextField();
		firstName.setBounds(204, 11, 86, 20);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(136, 14, 58, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lastName = new JTextField();
		lastName.setBounds(204, 40, 86, 20);
		frame.getContentPane().add(lastName);
		lastName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(136, 43, 56, 14);
		frame.getContentPane().add(lblLastName);
		
		age = new JTextField();
		age.setBounds(204, 71, 86, 20);
		frame.getContentPane().add(age);
		age.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(136, 74, 46, 14);
		frame.getContentPane().add(lblAge);
		
		email = new JTextField();
		email.setBounds(204, 101, 86, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(136, 104, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		password = new JTextField();
		password.setBounds(204, 132, 86, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(136, 135, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JCheckBox chckbxModerator = new JCheckBox("Moderator?");
		chckbxModerator.setBounds(160, 169, 97, 23);
		frame.getContentPane().add(chckbxModerator);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				User.addUserToDB(firstName.getText(), lastName.getText(), Integer.parseInt(age.getText()), email.getText(), chckbxModerator.isSelected(), password.getText());
			}
		});
		btnSubmit.setBounds(168, 211, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
