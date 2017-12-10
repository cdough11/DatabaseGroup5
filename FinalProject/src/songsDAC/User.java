package songsDAC;
import java.sql.*;
import java.util.*;

import org.sqlite.*;

public class User {

	public String fName, lName, userID, emailAddress;
	public int age;
	public boolean isModerator;
	List<Band> favoriteBands;
	public static boolean currentUserIsModerator;
	
	public User(String userID) {
		getInfoFromDB(userID);
	}
	
	public User(String username, String password) {
		String query = "SELECT * FROM Users WHERE Email = '" + username + "' and password = '" + password + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				fName = results.getString("fName");
				lName = results.getString("lName");
				userID = results.getString("user_id");
				emailAddress = results.getString("Email");
				age = results.getInt("Age");
				isModerator = results.getInt("is_Moderator") == 1;
				
				String favoriteSongsQuery = "SELECT * FROM FavoriteSongs WHERE user_id = '" + userID + "';";
				Statement favoriteSongsStatement = conn.createStatement();
				ResultSet favoriteSongsResults = favoriteSongsStatement.executeQuery(favoriteSongsQuery);
				favoriteBands = new ArrayList<Band>();
				while(favoriteSongsResults.next()) {
					String band = favoriteSongsResults.getString("band_id");
					favoriteBands.add(new Band(band));
				}		
			}
			else {
				fName = "";
				lName = "";
				userID = "";
				emailAddress = "";
				age = 0;
				isModerator = false;
			}
		}
		catch(SQLException e) {
			fName = "";
			lName = "";
			userID = "";
			emailAddress = "";
			age = 0;
			isModerator = false;
		}
	}
	
	public void getInfoFromDB(String userIDString) {
		String query = "SELECT * FROM Users WHERE user_id = '" + userIDString + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				fName = results.getString("fName");
				lName = results.getString("lName");
				userID = results.getString("user_id");
				emailAddress = results.getString("Email");
				age = results.getInt("Age");
				isModerator = results.getInt("is_Moderator") == 1;
				
				String favoriteSongsQuery = "SELECT * FROM FavoriteSongs WHERE user_id = '" + userID + "';";
				Statement favoriteSongsStatement = conn.createStatement();
				ResultSet favoriteSongsResults = favoriteSongsStatement.executeQuery(favoriteSongsQuery);
				favoriteBands = new ArrayList<Band>();
				while(favoriteSongsResults.next()) {
					String band = favoriteSongsResults.getString("band_id");
					favoriteBands.add(new Band(band));
				}		
			}
			else {
				fName = "";
				lName = "";
				userID = "";
				emailAddress = "";
				age = 0;
				isModerator = false;
			}
		}
		catch(SQLException e) {
			fName = "";
			lName = "";
			userID = "";
			emailAddress = "";
			age = 0;
			isModerator = false;
		}
	}
	
	public static boolean login(String email, String pWord) {
		String query = "SELECT is_Moderator FROM Users WHERE Email = '" + email + "' AND password = '" + pWord + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				currentUserIsModerator = results.getInt("is_Moderator") == 1;
				return true;
			}
			else
				currentUserIsModerator = false;
				return false;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		currentUserIsModerator = false;
		return false;
	}
}
