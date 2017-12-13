import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import songsDAC.Band;
import songsDAC.User;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GeneralUserGUI {

	private JFrame frame;
	private JTextField editBandName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralUserGUI window = new GeneralUserGUI();
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
	public GeneralUserGUI() {
		initialize();
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 386);
		frame.getContentPane().setLayout(null);
		
		editBandName = new JTextField();
		editBandName.setText("Enter Band Name");
		editBandName.setBounds(146, 16, 263, 20);
		frame.getContentPane().add(editBandName);
		editBandName.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(68, 164, 414, 144);
		frame.getContentPane().add(textPane);
		
		JButton newFav = new JButton("Add To Favorites");
		newFav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Band band = new Band(editBandName.getText());
				GUIlogin.loggedInUser.addNewFavoriteBand(band);
			}
		});
		newFav.setBounds(26, 54, 139, 23);
		frame.getContentPane().add(newFav);
		
		JButton deleteFav = new JButton("Delete From Favorites");
		deleteFav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Band band = new Band(editBandName.getText());
				GUIlogin.loggedInUser.deleteFavoriteBand(band);
			}
		});
		deleteFav.setBounds(350, 54, 172, 23);
		frame.getContentPane().add(deleteFav);
		
		JButton showFavs = new JButton("Show Favorite Bands");
		showFavs.addMouseListener(new MouseAdapter() {
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
		showFavs.setBounds(48, 89, 172, 23);
		frame.getContentPane().add(showFavs);
		
		JButton addPerformaceBtn = new JButton("Add Performance");
		addPerformaceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPerformance window = new AddPerformance();
				window.makeVisible();
			}
		});
		addPerformaceBtn.setBounds(187, 54, 139, 23);
		frame.getContentPane().add(addPerformaceBtn);
		JButton viewAttendedBtn = new JButton("View Attended Performaces");
		viewAttendedBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewAttendedPerformances window = new ViewAttendedPerformances();
				window.makeVisible();
			}
		});
		viewAttendedBtn.setBounds(268, 89, 214, 23);
		frame.getContentPane().add(viewAttendedBtn);
		
		JButton performanceCommentsBtn = new JButton("View Performace Comments");
		performanceCommentsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewComments window = new ViewComments();
				window.makeVisible();
			}
		});
		performanceCommentsBtn.setBounds(144, 125, 240, 23);
		frame.getContentPane().add(performanceCommentsBtn);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User.deleteFromDB(GUIlogin.loggedInUser.userID);
				GUIlogin window = new GUIlogin();
				window.makeVisible();
			}
		});
		btnDeleteAccount.setBounds(350, 320, 172, 23);
		frame.getContentPane().add(btnDeleteAccount);
	}
}
