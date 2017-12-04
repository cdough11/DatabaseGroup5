import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ModeratorGUI {

	private JFrame frame;
	private JTextField txtEnterBand;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModeratorGUI window = new ModeratorGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public ModeratorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEnterBand = new JTextField();
		txtEnterBand.setText("Enter Band");
		txtEnterBand.setBounds(10, 11, 280, 20);
		frame.getContentPane().add(txtEnterBand);
		txtEnterBand.setColumns(10);
		
		JButton addBand = new JButton("Add Band");
		addBand.setBounds(10, 31, 89, 23);
		frame.getContentPane().add(addBand);
		
		JButton deleteBand = new JButton("Delete Band");
		deleteBand.setBounds(105, 31, 105, 23);
		frame.getContentPane().add(deleteBand);
		
		JButton editSetlist = new JButton("Edit Setlist...");
		editSetlist.setBounds(10, 276, 116, 23);
		frame.getContentPane().add(editSetlist);
		
		JButton manageComments = new JButton("Manage Comments...");
		manageComments.setBounds(10, 310, 139, 23);
		frame.getContentPane().add(manageComments);
		
		JButton btnAddToFavorites = new JButton("Add to Favorites");
		btnAddToFavorites.setBounds(10, 56, 139, 23);
		frame.getContentPane().add(btnAddToFavorites);
		
		JButton btnDeleteFromFavorites = new JButton("Delete from Favorites");
		btnDeleteFromFavorites.setBounds(158, 56, 139, 23);
		frame.getContentPane().add(btnDeleteFromFavorites);
		
		JButton btnNewButton = new JButton("Show Favorites");
		btnNewButton.setBounds(300, 10, 124, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 86, 414, 145);
		frame.getContentPane().add(panel);
		
		JButton button = new JButton("Add Performance...");
		button.setBounds(10, 242, 139, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("View Performace Comments");
		button_1.setBounds(158, 242, 188, 23);
		frame.getContentPane().add(button_1);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.setBounds(308, 340, 116, 23);
		frame.getContentPane().add(btnDeleteAccount);
		
		JButton btnShowBands = new JButton("Show Bands");
		btnShowBands.setBounds(220, 31, 116, 23);
		frame.getContentPane().add(btnShowBands);
	}

}
