import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class generalUserGUI {

	private JFrame frame;
	private JTextField editBandName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generalUserGUI window = new generalUserGUI();
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
	public generalUserGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		editBandName = new JTextField();
		editBandName.setText("Enter Band Name");
		editBandName.setBounds(10, 11, 263, 20);
		frame.getContentPane().add(editBandName);
		editBandName.setColumns(10);
		
		JButton newFav = new JButton("Add To Favorites");
		newFav.setBounds(10, 31, 123, 23);
		frame.getContentPane().add(newFav);
		
		JButton deleteFav = new JButton("Delete From Favorites");
		deleteFav.setBounds(134, 31, 139, 23);
		frame.getContentPane().add(deleteFav);
		
		JButton showFavs = new JButton("Show Favorite Bands");
		showFavs.setBounds(283, 10, 141, 23);
		frame.getContentPane().add(showFavs);
		
		JButton addPerformaceBtn = new JButton("Add Performance...");
		addPerformaceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPerformance window = new AddPerformance();
				window.makeVisible();
			}
		});
		addPerformaceBtn.setBounds(10, 65, 139, 23);
		frame.getContentPane().add(addPerformaceBtn);
		JButton btnNewButton_1 = new JButton("View Attended Performaces...");
		btnNewButton_1.setBounds(144, 65, 214, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Band Comments");
		btnNewButton_2.setBounds(10, 99, 180, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Performace Comments");
		btnNewButton_3.setBounds(200, 99, 188, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setBounds(310, 285, 114, 23);
		frame.getContentPane().add(btnDeleteAccount);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 133, 414, 144);
		frame.getContentPane().add(textPane);
	}
}
