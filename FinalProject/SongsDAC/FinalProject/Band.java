package FinalProject;
import java.sql.ResultSet;
import java.sql.Statement;

import org.sqlite.*;

public class Band {
	
	public String id, title, artist;
	public int trackNumber, length;
	
	public Song(String title, String artist) {
		getInfoFromDB(title, artist);
	}
	
	public Song(String songID) {
		getInfoFromDB(songID);
	}
	
	public void getInfoFromDB(String titleString, String artistString) {
		String query = "SELECT * FROM Songs WHERE title = '" + titleString + "' AND artist = '" + artistString + "';";
		SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
		Statement statement = conn.createStatement();
		ResultSet results = statement.executeQuery(query);
		if(results.next()) {
			id = results.getString("song_id");
			title = results.getString("title");
			artist = results.getString("artist");
			trackNumber = results.getInt("track_number");
			length = results.getInt("length");
		}
		else {
			id = "";
			title = "";
			artist = "";
			trackNumber = 0;
			length = 0;
		}
	}
	
	public void getInfoFromDB(String songID) {
		String query = "SELECT * FROM Songs WHERE song_id = '" + songID + "';";
		SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
		Statement statement = conn.createStatement();
		ResultSet results = statement.executeQuery(query);
		if(results.next()) {
			id = results.getString("song_id");
			title = results.getString("title");
			artist = results.getString("artist");
			trackNumber = results.getInt("track_number");
			length = results.getInt("length");
		}
		else {
			id = "";
			title = "";
			artist = "";
			trackNumber = 0;
			length = 0;
		}
	}
	
}
