package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.util.List;

import it.polito.tdp.poweroutages.model.Nerc;

public class TestPowerOutagesDAO {

	public static void main(String[] args) {
		
		try {
			Connection connection = ConnectDB.getConnection();
			connection.close();
			System.out.println("Connection Test PASSED");
			
			PowerOutageDAO dao = new PowerOutageDAO() ;
			List<Nerc> nercs = dao.getNercList();
			

		} catch (Exception e) {
			System.err.println("Test FAILED");
			e.printStackTrace();
		}

	}

}
