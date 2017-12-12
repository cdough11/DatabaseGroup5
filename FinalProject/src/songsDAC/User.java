package songsDAC;
import java.sql.*;
import java.util.*;

import org.sqlite.*;

public class User {

	public String fName, lName, userID, emailAddress;
	public int age;
	public boolean isModerator;
	public List<Band> favoriteBands;
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
				
				String favoriteSongsQuery = "SELECT * FROM FavoriteBands WHERE user_id = '" + userID + "';";
				Statement favoriteSongsStatement = conn.createStatement();
				ResultSet favoriteSongsResults = favoriteSongsStatement.executeQuery(favoriteSongsQuery);
				favoriteBands = new ArrayList<Band>();
				while(favoriteSongsResults.next()) {
					int band = Integer.parseInt(favoriteSongsResults.getString("band_id"));
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
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
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
				
				String favoriteBandsQuery = "SELECT * FROM FavoriteBands WHERE user_id = '" + userID + "';";
				Statement favoriteBandsStatement = conn.createStatement();
				ResultSet favoriteBandsResults = favoriteBandsStatement.executeQuery(favoriteBandsQuery);
				favoriteBands = new ArrayList<Band>();
				while(favoriteBandsResults.next()) {
					String band = favoriteBandsResults.getString("band_id");
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
			conn.close();
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
				conn.close();
				return true;
			}
			else {
				currentUserIsModerator = false;
				conn.close();
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		currentUserIsModerator = false;
		return false;
	}
	
	public static void deleteFromDB(String userID) {
		String query = "DELETE FROM Users WHERE user_id = '" + userID + "';";
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
	
	public static void addUserToDB(String firstName, String lastName, int age, String email, boolean isModerator, String password) {
		try {
			int isMod = isModerator ? 1:0;
			String query = "INSERT INTO Users (fName, lName, Age, Email, is_Moderator, password) VALUES ('" + firstName + "', '" + lastName + "', " +
					age + ", '" + email + "', " + isMod + ", '" + password + "');";
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement;
			statement = conn.createStatement();
			statement.execute(query);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addNewFavoriteBand(Band band) {
		boolean containsBand = false;
		for(Band existingBand: this.favoriteBands)
			if(existingBand.id.equals(band.id))
				containsBand = true;
		if(!containsBand) {
			this.favoriteBands.add(band);
			String query = "INSERT INTO FavoriteBands (band_id, user_id) VALUES ('" + band.id + "', '" + this.userID + "');";	
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
	}

	public void deleteFavoriteBand(Band band) {
		boolean containsBand = false;
		int index = 0;
		int i = 0;
		for(Band existingBand: this.favoriteBands) {
			if(existingBand.id.equals(band.id)) {
				containsBand = true;
				index = i;
			}
			i++;
		}
		if(containsBand) {
			this.favoriteBands.remove(index);
			String query = "DELETE FROM FavoriteBands WHERE band_id = '" + band.id + "' AND user_id = '" + this.userID + "';";	
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
	}
}
