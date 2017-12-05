import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditSetlist {

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
					EditSetlist window = new EditSetlist();
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
	public EditSetlist() {
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
		
		JLabel lblBandName = new JLabel("Band Name");
		lblBandName.setBounds(10, 11, 87, 14);
		frame.getContentPane().add(lblBandName);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 367, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDateOfPerformace = new JLabel("Date of Performace (MM/DD/YYYY)");
		lblDateOfPerformace.setBounds(10, 67, 220, 14);
		frame.getContentPane().add(lblDateOfPerformace);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 92, 142, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSetlist = new JLabel("Setlist");
		lblSetlist.setBounds(10, 123, 46, 14);
		frame.getContentPane().add(lblSetlist);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 148, 414, 68);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton saveBtn = new JButton("Save Changes");
		saveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModeratorGUI window = new ModeratorGUI();
				window.makeVisible();
			}
		});
		saveBtn.setBounds(162, 227, 110, 23);
		frame.getContentPane().add(saveBtn);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
