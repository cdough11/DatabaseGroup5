package songsDAC;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.*;

import songsDAC.Band.Member;

public class Performance {

	public List<Song> setList;
	String duration;
	Date date;
	String venue;
	public String id;
	Band band;
	
	public Performance(String performanceID) {
		getInfoFromDB(performanceID);
	}
	
	public Performance(Date date, String bandID) {
		getInfoFromDB(date, bandID);
	}
	
	public void getInfoFromDB(String performanceID) {
		String query = "SELECT * FROM Performances WHERE band_id = '" + performanceID + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				id = results.getString("performance_id");
				duration = results.getString("duration");
				date = Date.valueOf(results.getString("date"));
				String band_id = results.getString("band_id");
				band = new Band(band_id);
				
				String setListQuery = "SELECT * FROM Songs, SetLists, Performances WHERE" + 
				" SetLists.performance_id = '" + id + "' AND Songs.song_id = SetLists.song_id;";
				Statement setListStatement = conn.createStatement();
				ResultSet setListResults = setListStatement.executeQuery(setListQuery);
				setList = new ArrayList<Song>();
				while(setListResults.next()) {
					String song_id = setListResults.getString("Songs.song_id");
					setList.add(new Song(song_id));
				}
				
				
			}
			else {
				id = "";
				duration = "";
				date = null;
				band = null;
				setList = new ArrayList<Song>();
			}
		}
		catch(SQLException e) {
			id = "";
			duration = "";
			date = null;
			band = null;
			setList = new ArrayList<Song>();
		}
	}

	public void getInfoFromDB(Date performanceDate, String bandID) {
		String query = "SELECT * FROM Performances WHERE date = '" + performanceDate + "' AND band_ id = '" + bandID + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				id = results.getString("performance_id");
				duration = results.getString("duration");
				date = Date.valueOf(results.getString("date"));
				String band_id = results.getString("band_id");
				band = new Band(band_id);
				
				String setListQuery = "SELECT * FROM Songs, SetLists, Performances WHERE" + 
				" SetLists.performance_id = '" + id + "' AND Songs.song_id = SetLists.song_id;";
				Statement setListStatement = conn.createStatement();
				ResultSet setListResults = setListStatement.executeQuery(setListQuery);
				setList = new ArrayList<Song>();
				while(setListResults.next()) {
					String song_id = setListResults.getString("Songs.song_id");
					setList.add(new Song(song_id));
				}
				
				
			}
			else {
				id = "";
				duration = "";
				date = null;
				band = null;
				setList = new ArrayList<Song>();
			}
		}
		catch(SQLException e) {
			id = "";
			duration = "";
			date = null;
			band = null;
			setList = new ArrayList<Song>();
		}
	}
	
	public static void addPerformanceToDB(String duration, Date date, String venue, String bandID) {
		try {
			String query = "INSERT INTO Performances (duration, date, venue, band_id) VALUES ('" + duration + "', '" + date + "', " +
					venue + ", '" + bandID + "');";
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement;
			statement = conn.createStatement();
			statement.execute(query);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addSongToSetList(String songID, String performanceID) {
		try {
			String query = "INSERT INTO SetLists (song_id, performance_id) VALUES ('" + songID + "', '" + performanceID + "');";
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement;
			statement = conn.createStatement();
			statement.execute(query);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void deleteSongFromSetList(String songID, String performanceID) {
		try {
			String query = "DELETE FROM SetLists WHERE song_id = '" + songID + "' AND performance_id = '" + performanceID + "');";
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
