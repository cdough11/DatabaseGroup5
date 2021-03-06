package songsDAC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.*;

public class Band {
	
	public String id, name;
	public Date formationDate, breakupDate;
	public List<Member> members;
	public List<Album> albums;
	
	public Band(String name, String formationDate) {
		getInfoFromDB(name, formationDate);
	}
	
	public Band(String songID) {
		getInfoFromDB(songID);
	}
	
	public void getInfoFromDB(String titleString, String artistString) {
		String query = "SELECT * FROM Songs WHERE name = '" + titleString + "' AND formationDate = '" + artistString + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				id = results.getString("band_id");
				name = results.getString("name");
				formationDate = Date.valueOf(results.getString("formationDate"));
				breakupDate = Date.valueOf(results.getString("track_number"));
				
				String bandMembersQuery = "SELECT * FROM BandMembers WHERE band_id = '" + id + "';";
				Statement bandMembersStatement = conn.createStatement();
				ResultSet bandMembersResults = bandMembersStatement.executeQuery(bandMembersQuery);
				members = new ArrayList<Member>();
				while(bandMembersResults.next()) {
					String fName = bandMembersResults.getString("fName");
					String lName = bandMembersResults.getString("lName");
					members.add(new Member(fName, lName, id));
				}
				
				String albumsQuery = "SELECT * FROM Albums WHERE band_id = '" + id + "';";
				Statement albumsStatement = conn.createStatement();
				ResultSet albumsResults = albumsStatement.executeQuery(albumsQuery);
				albums = new ArrayList<Album>();
				while(albumsResults.next()) {
					String albumID = albumsResults.getString("album_id");
					albums.add(new Album(albumID));
				}
			}
			else {
				id = "";
				name = "";
				formationDate = null;
				breakupDate = null;
				members = new ArrayList<Member>();
			}
		}
		catch(SQLException e) {
			id = "";
			name = "";
			formationDate = null;
			breakupDate = null;
			members = new ArrayList<Member>();
		}
	}
	
	public void getInfoFromDB(String bandID) {
		String query = "SELECT * FROM Bands WHERE band_id = '" + bandID + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				id = results.getString("band_id");
				name = results.getString("band_name");
				formationDate = Date.valueOf(results.getString("formationDate"));
				breakupDate = Date.valueOf(results.getString("track_number"));
				
				String bandMembersQuery = "SELECT * FROM BandMembers WHERE band_id = '" + id + "';";
				Statement bandMembersStatement = conn.createStatement();
				ResultSet bandMembersResults = bandMembersStatement.executeQuery(bandMembersQuery);
				members = new ArrayList<Member>();
				while(bandMembersResults.next()) {
					String fName = bandMembersResults.getString("fName");
					String lName = bandMembersResults.getString("lName");
					members.add(new Member(fName, lName, id));
				}
			}
			else {
				id = "";
				name = "";
				formationDate = null;
				breakupDate = null;
				members = new ArrayList<Member>();
			}
		}
		catch(SQLException e) {
			id = "";
			name = "";
			formationDate = null;
			breakupDate = null;
			members = new ArrayList<Member>();
		}
	}
	
	public class Member{
		public String fName;
		public String lName;
		public String bandID;
		
		public Member(String f, String l, String id) {
			fName = f;
			lName = l;
			bandID = id;
		}
	}
	public static void addBandToDB(String bandName) {
		try {
			String query = "INSERT INTO Bands (band_fname, band_lname, formation_date, breakup_date) VALUES ('" + bandName + "', null, null);";
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement;
			statement = conn.createStatement();
			statement.execute(query);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteBandFromDB(String bandName) {
		try {
			String query = "DELETE FROM Bands WHERE band_name = '" + bandName + "';";
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
