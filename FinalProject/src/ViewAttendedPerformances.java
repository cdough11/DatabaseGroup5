import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ViewAttendedPerformances {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAttendedPerformances window = new ViewAttendedPerformances();
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
	public ViewAttendedPerformances() {
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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 414, 65);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 158, 414, 92);
		frame.getContentPane().add(textPane_1);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
