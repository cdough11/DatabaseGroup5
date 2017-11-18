package FinalProject;
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;

import org.sqlite.*;

public class User {

	public String fName, lName, userID, emailAddress, favoriteSongsID;
	public int age;
	public boolean isModerator;
	List<Song> favoriteSongs;
	
	public Song(String userID) {
		getInfoFromDB(userID);
	}
	
	public void getInfoFromDB(String userIDString) {
		String query = "SELECT * FROM Users WHERE userID = '" + userIDString + "';";
		SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
		Statement statement = conn.createStatement();
		ResultSet results = statement.executeQuery(query);
		if(results.next()) {
			fName = results.getString("fName");
			lName = results.getString("lName");
			userID = results.getString("userID");
			emailAddress = results.getString("Email");
			age = results.getInt("Age");
			isModerator = results.getInt("is_Moderator") == 1;
			favoriteSongsID = results.getString("favoriteSongsID");
			
			String favoriteSongsQuery = "SELECT * FROM FavoriteSongs WHERE user_id = '" + userID = "';";
			Statement favoriteSongsStatement = conn.createStatement();
			ResultsSet favoriteSongsResults = favoriteSongsStatement.executeQuery(favoriteSongsQuery);
			favoriteSongs = new ArrayList<Song>();
			while(favoriteSongsResults.next()) {
				String songID = favoriteSongsResults.getString("song_id");
				favoriteSongs.add(new Song(songID));
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
}
