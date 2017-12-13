import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import songsDAC.Performance;
import songsDAC.Song;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class EditSetlist {

	private JFrame frame;
	private JTextField performanceIDField;
	private JTextField songIDField;
	private JTextField setListValues;
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblBandName = new JLabel("performance_id");
		lblBandName.setBounds(10, 11, 101, 14);
		frame.getContentPane().add(lblBandName);
		
		performanceIDField = new JTextField();
		performanceIDField.setBounds(10, 36, 142, 20);
		frame.getContentPane().add(performanceIDField);
		performanceIDField.setColumns(10);
		
		JLabel songIDLabel = new JLabel("song_id");
		songIDLabel.setBounds(10, 67, 51, 14);
		frame.getContentPane().add(songIDLabel);
		
		songIDField = new JTextField();
		songIDField.setBounds(10, 92, 142, 20);
		frame.getContentPane().add(songIDField);
		songIDField.setColumns(10);
		
		setListValues = new JTextField();
		setListValues.setBounds(10, 130, 414, 86);
		frame.getContentPane().add(setListValues);
		setListValues.setColumns(10);
		
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
		btnAddToSetlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String songID  = songIDField.getText();
				String performanceID = performanceIDField.getText();
				Performance performance = new Performance(performanceID);
				List<Song> setList = performance.setList;
				boolean alreadyIn = false;
				for(Song song: setList)
					if(song.id.equals(songID))
						alreadyIn = true;
				if(!alreadyIn) {
					Performance.addSongToSetList(songID, performanceID);
				}
			}
		});
		btnAddToSetlist.setBounds(269, 33, 155, 23);
		frame.getContentPane().add(btnAddToSetlist);
		
		btnDeleteFromSetlist = new JButton("Delete From Setlist");
		btnDeleteFromSetlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String songID  = songIDField.getText();
				String performanceID = performanceIDField.getText();
				Performance performance = new Performance(performanceID);
				List<Song> setList = performance.setList;
				boolean exists = false;
				for(Song song: setList)
					if(song.id.equals(songID))
						exists = true;
				if(exists) {
					Performance.deleteSongFromSetList(songID, performanceID);
				}
			}
		});
		btnDeleteFromSetlist.setBounds(269, 63, 155, 23);
		frame.getContentPane().add(btnDeleteFromSetlist);
		
		btnViewSetlist = new JButton("View Setlist");
		btnViewSetlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String songID  = songIDField.getText();
				String performanceID = performanceIDField.getText();
				Performance performance = new Performance(performanceID);
				List<Song> setList = performance.setList;
				String setListString = "";
				for(Song song: setList)
					setListString += song.title + "\n";
				setListValues.setText(setListString);
			}
		});
		btnViewSetlist.setBounds(269, 91, 155, 23);
		frame.getContentPane().add(btnViewSetlist);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
