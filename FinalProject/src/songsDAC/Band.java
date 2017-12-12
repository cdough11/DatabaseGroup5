package songsDAC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.*;

public class Band {
	
	public String id, name;
	public String formationDate, breakupDate;
	public List<Member> members;
	public List<Album> albums;
	
	public Band(String name) {
		getInfoFromDB(name);
	}
	
	public Band(int bandID) {
		getInfoFromDB(bandID);
	}
	
	public void getInfoFromDB(String bandName) {
		String query = "SELECT * FROM Bands WHERE band_name = '" + bandName + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				id = results.getString("band_id");
				name = results.getString("band_name");
				formationDate = results.getString("formation_date");
				breakupDate = results.getString("breakup_date");
				
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
				ArrayList<Integer> albumIDs = new ArrayList<Integer>();
				while(albumsResults.next()) {
					albumIDs.add(albumsResults.getInt("album_id"));
				}
				conn.close();
				for(Integer albumID: albumIDs) {
					albums.add(new Album(albumID.toString()));
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
			e.printStackTrace();
			id = "";
			name = "";
			formationDate = null;
			breakupDate = null;
			members = new ArrayList<Member>();
		}
	}
	
	public void getInfoFromDB(int bandID) {
		String query = "SELECT * FROM Bands WHERE band_id = '" + bandID + "';";
		try {
			SQLiteConnection conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
			Statement statement = conn.createStatement();
			ResultSet results = statement.executeQuery(query);
			if(results.next()) {
				id = results.getString("band_id");
				name = results.getString("band_name");
				formationDate = results.getString("formation_date");
				breakupDate = results.getString("breakup_date");
				
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
				ArrayList<Integer> albumIDs = new ArrayList<Integer>();
				while(albumsResults.next()) {
					albumIDs.add(albumsResults.getInt("album_id"));
				}
				conn.close();
				for(Integer albumID: albumIDs) {
					albums.add(new Album(albumID.toString()));
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
			e.printStackTrace();
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
	public static void addBandToDB(String bandName, String formationDate, String breakupDate) {
		SQLiteConnection conn;
		try {
			String query = "INSERT INTO Bands (band_name, formation_date, breakup_date) VALUES ('" + bandName + "', '" + formationDate + "', '" + breakupDate + "');";
			conn = new SQLiteConnection(DBInfo.DBFILEPATH, DBInfo.DB_NAME);
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
