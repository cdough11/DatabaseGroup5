import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageComments {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField userId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageComments window = new ManageComments();
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
	public ManageComments() {
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
		
		JLabel lblUserId = new JLabel("Band Name");
		lblUserId.setBounds(10, 11, 73, 14);
		frame.getContentPane().add(lblUserId);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 306, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Date of Performace (MM/DD/YYYY)");
		lblNewLabel.setBounds(10, 67, 173, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 92, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 123, 414, 97);
		frame.getContentPane().add(panel);
		
		JLabel lblDeleteCommentFrom = new JLabel("Delete Comment from User");
		lblDeleteCommentFrom.setBounds(10, 231, 137, 14);
		frame.getContentPane().add(lblDeleteCommentFrom);
		
		userId = new JTextField();
		userId.setBounds(157, 228, 110, 20);
		frame.getContentPane().add(userId);
		userId.setColumns(10);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModeratorGUI window = new ModeratorGUI();
				window.makeVisible();
			}
		});
		submitBtn.setBounds(335, 231, 89, 23);
		frame.getContentPane().add(submitBtn);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
