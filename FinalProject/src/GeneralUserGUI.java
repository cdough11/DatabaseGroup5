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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		editBandName = new JTextField();
		editBandName.setText("Enter Band Name");
		editBandName.setBounds(146, 16, 263, 20);
		frame.getContentPane().add(editBandName);
		editBandName.setColumns(10);
		
		JButton newFav = new JButton("Add To Favorites");
		newFav.setBounds(26, 54, 139, 23);
		frame.getContentPane().add(newFav);
		
		JButton deleteFav = new JButton("Delete From Favorites");
		deleteFav.setBounds(350, 54, 172, 23);
		frame.getContentPane().add(deleteFav);
		
		JButton showFavs = new JButton("Show Favorite Bands");
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
		
		JButton bandCommentsBtn = new JButton("View Band Comments");
		bandCommentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bandCommentsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewComments window = new ViewComments();
				window.makeVisible();
			}
		});
		bandCommentsBtn.setBounds(48, 124, 180, 23);
		frame.getContentPane().add(bandCommentsBtn);
		
		JButton performanceCommentsBtn = new JButton("View Performace Comments");
		performanceCommentsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewComments window = new ViewComments();
				window.makeVisible();
			}
		});
		performanceCommentsBtn.setBounds(268, 123, 240, 23);
		frame.getContentPane().add(performanceCommentsBtn);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUIlogin window = new GUIlogin();
				window.makeVisible();
			}
		});
		btnDeleteAccount.setBounds(350, 320, 172, 23);
		frame.getContentPane().add(btnDeleteAccount);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(68, 164, 414, 144);
		frame.getContentPane().add(textPane);
	}
}
