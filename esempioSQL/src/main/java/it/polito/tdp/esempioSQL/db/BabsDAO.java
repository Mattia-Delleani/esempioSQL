package it.polito.tdp.esempioSQL.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esempioSQL.model.Station;

public class BabsDAO {

	
	public List<Station> listStation(){
		
		List<Station> result = new ArrayList<>();
		
		String sql = "SELECT station_id, name, dockcount, landmark FROM STATION ORDER BY name";
		
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=Jaqa7951ma";

		try {
			
			Connection conn = DriverManager.getConnection(jdbcURL);
								
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery();
			
			//il cursore parte da una riga fasulla e finisce su una fasulla, semplifica molto la programmazione ( se non ci sono righe non da errore)
			//perche resultset non sa che tipo ho, devo poi dichiarare la glasse X in getX
			
			while(res.next()) {
				
				Station s = new Station(res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"), res.getString("landmark"));
				result.add(s);
				
			}
			st.close();//lo chiudo per eliminare dal server l'impostazione della mia query, se devo ancora interrogarlo posso ripari un altro statement
			conn.close();
			
			return result;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}

	
	public List<Station> listStationByLandmark(String landmark){
List<Station> result = new ArrayList<>();
		
		String sql = "SELECT station_id, name, dockcount, landmark FROM STATION"+ 
						" WHERE landmark=? ORDER BY name";
		
		//DELEGATO ALLA CLASSE STATICA DBCONNECT che ha la fase di connessione che si stabilizza e puo essere richiesta da piu DAO
		//String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=Jaqa7951ma";

		try {
			
			Connection conn = DBConnect.getConnection();
								
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, landmark);
			ResultSet res = st.executeQuery();
			
			//il cursore parte da una riga fasulla e finisce su una fasulla, semplifica molto la programmazione ( se non ci sono righe non da errore)
			//perche resultset non sa che tipo ho, devo poi dichiarare la glasse X in getX
			
			while(res.next()) {
				
				Station s = new Station(res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"), res.getString("landmark"));
				result.add(s);
				
			}
			st.close();//lo chiudo per eliminare dal server l'impostazione della mia query, se devo ancora interrogarlo posso ripari un altro statement
			conn.close();
			
			return result;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	
	}
}
