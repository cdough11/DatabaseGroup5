import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import songsDAC.Comment;

public class ViewComments {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewComments window = new ViewComments();
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
	public ViewComments() {
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
		
		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(10, 11, 77, 14);
		frame.getContentPane().add(lblComments);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 36, 414, 214);
		frame.getContentPane().add(textPane);
		
		List<Comment> comments = Comment.getAllComments();
		String commentsString = "";
		for(Comment comment: comments) {
			commentsString += "Performance ID: " + comment.performance.id + ", User ID: " + comment.user.userID + "\nContents: " + comment.content + "\n\n";
		}
		textPane.setText(commentsString);
	}
	
	public void makeVisible() {
		this.frame.setVisible(true);
	}
}
