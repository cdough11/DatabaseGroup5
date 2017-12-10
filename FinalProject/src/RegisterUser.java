import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class RegisterUser {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		textField = new JTextField();
		textField.setBounds(204, 11, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(136, 14, 58, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 40, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(136, 43, 56, 14);
		frame.getContentPane().add(lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 71, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(136, 74, 46, 14);
		frame.getContentPane().add(lblAge);
		
		textField_3 = new JTextField();
		textField_3.setBounds(204, 101, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(136, 104, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setBounds(204, 132, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(136, 135, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		JCheckBox chckbxModerator = new JCheckBox("Moderator?");
		chckbxModerator.setBounds(160, 169, 97, 23);
		frame.getContentPane().add(chckbxModerator);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(168, 211, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
