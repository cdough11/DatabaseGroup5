package songsDAC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import org.sqlite.*;

public class Comment {
	
	String id;
	Date date;
	String content;
	Performance performance;
	User user;
	
	public Comment(String user_id, String performance_id, Date date) {
		getInfoFromDB(user_id, performance_id, date);
	}
	
	public Comment(String comment_id) {
		getInfoFromDB(comment_id);
	}
	
	public void getInfoFromDB(String user_id, String performance_id, Date date) {
		String query = "SELECT * FROM Comments WHERE user_id = '" + user_id + "' AND performance_id = '" + performance_id +
				"' AND date = '" + date + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				id = results.getString("comment_id");
				content = results.getString("content");
				date = Date.valueOf(results.getString("date"));
			}
			else {
				id = "";
				content = "";
				date = null;
			}
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
				date = Date.valueOf(results.getString("date"));
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
		}
		catch(SQLException e) {
			id = "";
			content = "";
			date = null;
		}
	}
	
	public static void deleteFromDB(String commentID) {
		String query = "DELETE FROM Comments WHERE comment_id = '" + commentID + "';";
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
	
	public static void addCommentToDB(Date date, String userID, String performanceID, String contents) {
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
}
