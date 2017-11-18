import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class addPerformance {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addPerformance window = new addPerformance();
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
	public addPerformance() {
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
		textField.setBounds(10, 29, 374, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNameOfBand = new JLabel("Name of Band");
		lblNameOfBand.setBounds(10, 11, 109, 14);
		frame.getContentPane().add(lblNameOfBand);
		
		JLabel lblNewLabel = new JLabel("Date Attended (MM/DD/YYYY)");
		lblNewLabel.setBounds(10, 60, 150, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 82, 150, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(10, 113, 109, 14);
		frame.getContentPane().add(lblComments);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 138, 414, 71);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton addBtn = new JButton("Add");
		addBtn.setBounds(10, 216, 89, 23);
		frame.getContentPane().add(addBtn);
	}

}
