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
	private JButton btnAddToSetlist;
	private JButton btnDeleteFromSetlist;
	private JButton btnViewSetlist;

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
		
		JLabel lblBandName = new JLabel("performance_id");
		lblBandName.setBounds(10, 11, 87, 14);
		frame.getContentPane().add(lblBandName);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 142, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDateOfPerformace = new JLabel("song_id");
		lblDateOfPerformace.setBounds(10, 67, 51, 14);
		frame.getContentPane().add(lblDateOfPerformace);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 92, 142, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 130, 414, 86);
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
		
		btnAddToSetlist = new JButton("Add To Setlist");
		btnAddToSetlist.setBounds(269, 33, 110, 23);
		frame.getContentPane().add(btnAddToSetlist);
		
		btnDeleteFromSetlist = new JButton("Delete From Setlist");
		btnDeleteFromSetlist.setBounds(269, 63, 123, 23);
		frame.getContentPane().add(btnDeleteFromSetlist);
		
		btnViewSetlist = new JButton("View Setlist");
		btnViewSetlist.setBounds(269, 91, 89, 23);
		frame.getContentPane().add(btnViewSetlist);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
