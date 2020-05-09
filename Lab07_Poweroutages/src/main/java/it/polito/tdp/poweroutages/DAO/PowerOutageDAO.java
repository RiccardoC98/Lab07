package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PowerOutage;

public class PowerOutageDAO {
	
	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}
	
	public List<PowerOutage> getPOs(Nerc nerc) {

		String sql = "SELECT customers_affected, date_event_began as begins, date_event_finished as ends "
				//+ "TIMEDIFF(date_event_finished, date_event_began) as duration " 
				+ "FROM poweroutages "
				+ "WHERE nerc_id = ? "
				+ "ORDER BY id"; //lista di tutti gli eventi riguardanti il NERC selezionato
		List<PowerOutage> poList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, nerc.getId());
			
			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				Timestamp begins = new Timestamp (res.getDate("begins").getTime());
				Timestamp ends = new Timestamp (res.getDate("ends").getTime());
				
				PowerOutage po = new PowerOutage(res.getInt("customers_affected"), begins.toLocalDateTime(), ends.toLocalDateTime()); 
				poList.add(po);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return poList;
	}
	

}
