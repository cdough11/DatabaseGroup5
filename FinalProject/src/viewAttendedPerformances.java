import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class viewAttendedPerformances {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewAttendedPerformances window = new viewAttendedPerformances();
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
	public viewAttendedPerformances() {
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
		
		JLabel lblPerformacesAttended = new JLabel("Performaces Attended");
		lblPerformacesAttended.setBounds(10, 11, 116, 14);
		frame.getContentPane().add(lblPerformacesAttended);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 34, 414, 63);
		frame.getContentPane().add(panel);
		
		JLabel lblPerormcaneId = new JLabel("Performance ID:");
		lblPerormcaneId.setBounds(10, 108, 84, 14);
		frame.getContentPane().add(lblPerormcaneId);
		
		textField = new JTextField();
		textField.setBounds(104, 105, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(10, 133, 62, 14);
		frame.getContentPane().add(lblComments);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 158, 414, 92);
		frame.getContentPane().add(panel_1);
	}

}
