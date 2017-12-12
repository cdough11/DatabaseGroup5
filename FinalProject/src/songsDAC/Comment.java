package songsDAC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.*;

public class Comment {
	
	public String id;
	public String date;
	public String content;
	public String userID;
	public String performanceID;
	public Performance performance;
	public User user;
	
	public Comment(String user_id, String performance_id, String date) {
		getInfoFromDB(user_id, performance_id, date);
	}
	
	public Comment(String comment_id) {
		getInfoFromDB(comment_id);
	}
	
	public Comment(String date, String content, String performanceID, String userID) {
		this.date = date;
		this.content = content;
		this.performanceID = performanceID;
		this.userID = userID;
	}
	
	public void getInfoFromDB(String user_id, String performance_id, String date) {
		String query = "SELECT * FROM Comments WHERE user_id = '" + user_id + "' AND performance_id = '" + performance_id +
				"' AND date = '" + date + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				id = results.getString("comment_id");
				content = results.getString("content");
				date = (results.getString("date"));
			}
			else {
				id = "";
				content = "";
				date = null;
			}
			conn.close();
		}
		catch(SQLException e) {
			id = "";
			content = "";
			date = null;
		}
		user = new User(user_id);
		performance = new Performance(performance_id);
	}
	
	public void getInfoFromDB(String commentID) {
		String query = "SELECT * FROM Comments, Users, Performances WHERE comment_id = '" + commentID + "' AND Comments.user_id = Users.user_id AND Comments.user_id = Performances.user_id;";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				id = results.getString("comment_id");
				content = results.getString("content");
				date = (results.getString("date"));
				String user_id = results.getString("Comments.user_id");
				String performance_id = results.getString("Comments.performance_id");
				user = new User(user_id);
				performance = new Performance(performance_id);
			}
			else {
				id = "";
				content = "";
				date = null;
			}
			conn.close();
		}
		catch(SQLException e) {
			id = "";
			content = "";
			date = null;
		}
	}
	
	public static void deleteFromDB(String commentID) {
		String query = "DELETE FROM Comments WHERE comment_id = " + commentID + ";";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement;
			statement = conn.createStatement();
			statement.execute(query);
			conn.close();
		}
			catch(SQLException e) {
				e.printStackTrace();
		}
	}
	
	public static void addCommentToDB(String date, String userID, String performanceID, String contents) {
		try {
			String query = "INSERT INTO Comments (date, user_id, performance_id, contents) VALUES ('" + date + "', '" + userID + "', " +
					performanceID + ", '" + contents + "');";
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement;
			statement = conn.createStatement();
			statement.execute(query);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Comment> getAllComments() {
		List<Comment> comments = new ArrayList<Comment>();
		String query = "SELECT * FROM Comments;";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				String newDate = "";
				try {
					newDate = (results.getString("date"));
				}
				catch(Exception e) {;}
				String content = results.getString("contents");
				String performanceID = results.getString("performance_id");
				String userID = results.getString("user_id");
				comments.add(new Comment(newDate, content, performanceID, userID));
			}
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}
}
