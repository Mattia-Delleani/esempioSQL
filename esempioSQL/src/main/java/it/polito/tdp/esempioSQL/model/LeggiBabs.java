package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {
	
	public void run() {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=Jaqa7951ma";

		try {
			//Apro la connessione, chiudere subito poi scrivo tra le due righe
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			String sql ="SELECT name FROM station WHERE landmark = ?";
						
			PreparedStatement st = conn.prepareStatement(sql);
			
			//setto i parametri
			st.setString(1, "Palo Alto");
			
			ResultSet res = st.executeQuery();
			
			//il cursore parte da una riga fasulla e finisce su una fasulla, semplifica molto la programmazione ( se non ci sono righe non da errore)
			//perche resultset non sa che tipo ho, devo poi dichiarare la glasse X in getX
			
			while(res.next()) {
				
				String nomeStazione = res.getString("name");
				
				System.out.println(nomeStazione);
			}
			st.close();//lo chiudo per eliminare dal server l'impostazione della mia query, se devo ancora interrogarlo posso ripari un altro statement
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		//FActory: creazione di un oggetto di una classe, senza conoscere il tipo della classe(NON potevo usare new);
		//Uso un metodo fornito da un altra classe che internamente fara new e conoscera il tipo d classe effettivo
	
	}
	public static void main(String args[]) {
	
		LeggiBabs babs = new LeggiBabs();
		babs.run();
		
	}
	
}
