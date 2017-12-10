import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import songsDAC.Band;
import songsDAC.User;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextPane;

public class ModeratorGUI {

	private JFrame frame;
	private JTextField bandNameTF;
	private JTextField txtEnterFormationDate;
	private JTextField txtEnterBreakupDate;

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
		frame.setBounds(100, 100, 550, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		bandNameTF = new JTextField();
		bandNameTF.setText("Enter Band");
		bandNameTF.setBounds(18, 11, 131, 20);
		frame.getContentPane().add(bandNameTF);
		bandNameTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(18, 121, 414, 137);
		frame.getContentPane().add(textPane);
		
		JButton addBand = new JButton("Add Band");
		addBand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String bandName = bandNameTF.getText();
				String formationDate = txtEnterFormationDate.getText();
				String breakupDate = txtEnterBreakupDate.getText();
				Band.addBandToDB(bandName, formationDate, breakupDate);
			}
		});
		addBand.setBounds(10, 51, 89, 23);
		frame.getContentPane().add(addBand);
		
		JButton deleteBand = new JButton("Delete Band");
		deleteBand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String bandName = bandNameTF.getText();
				Band.deleteBandFromDB(bandName);
			}
		});
		deleteBand.setBounds(130, 51, 105, 23);
		frame.getContentPane().add(deleteBand);
		
		JButton editSetlist = new JButton("Edit Setlist");
		editSetlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditSetlist window = new EditSetlist();
				window.makeVisible();
			}
		});
		editSetlist.setBounds(166, 270, 116, 23);
		frame.getContentPane().add(editSetlist);
		
		JButton manageComments = new JButton("Manage Comments");
		manageComments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageComments window = new ManageComments();
				window.makeVisible();
			}
		});
		manageComments.setBounds(231, 305, 181, 23);
		frame.getContentPane().add(manageComments);
		
		JButton btnAddToFavorites = new JButton("Add to Favorites");
		btnAddToFavorites.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Band band = new Band(bandNameTF.getText());
				GUIlogin.loggedInUser.addNewFavoriteBand(band);
			}
		});
		btnAddToFavorites.setBounds(10, 86, 139, 23);
		frame.getContentPane().add(btnAddToFavorites);
		
		JButton btnDeleteFromFavorites = new JButton("Delete from Favorites");
		btnDeleteFromFavorites.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Band band = new Band(bandNameTF.getText());
				GUIlogin.loggedInUser.deleteFavoriteBand(band);
			}
		});
		btnDeleteFromFavorites.setBounds(166, 86, 169, 23);
		frame.getContentPane().add(btnDeleteFromFavorites);
		
		JButton showFavorites = new JButton("Show Favorites");
		showFavorites.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Band> favoriteBands = GUIlogin.loggedInUser.favoriteBands;
				String favBandNames = "";
				for(Band band: favoriteBands) {
					favBandNames += band.name + "\n";
				}
				textPane.setText(favBandNames);
			}
		});
		showFavorites.setBounds(368, 86, 124, 23);
		frame.getContentPane().add(showFavorites);
		
		JButton addPerformaceBtn = new JButton("Add Performance");
		addPerformaceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddPerformance window = new AddPerformance();
				window.makeVisible();
			}
		});
		addPerformaceBtn.setBounds(10, 270, 139, 23);
		frame.getContentPane().add(addPerformaceBtn);
		
		JButton perfCommentsBtn = new JButton("View Performace Comments");
		perfCommentsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewComments window = new ViewComments();
				window.makeVisible();
			}
		});
		perfCommentsBtn.setBounds(10, 305, 209, 23);
		frame.getContentPane().add(perfCommentsBtn);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				User.deleteFromDB(GUIlogin.loggedInUser.userID);
				GUIlogin window = new GUIlogin();
				window.makeVisible();
			}
		});
		btnDeleteAccount.setBounds(10, 339, 139, 23);
		frame.getContentPane().add(btnDeleteAccount);
		
		txtEnterFormationDate = new JTextField();
		txtEnterFormationDate.setText("Enter Formation Date");
		txtEnterFormationDate.setBounds(159, 11, 123, 20);
		frame.getContentPane().add(txtEnterFormationDate);
		txtEnterFormationDate.setColumns(10);
		
		txtEnterBreakupDate = new JTextField();
		txtEnterBreakupDate.setText("Enter Breakup Date");
		txtEnterBreakupDate.setBounds(292, 11, 120, 20);
		frame.getContentPane().add(txtEnterBreakupDate);
		txtEnterBreakupDate.setColumns(10);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
