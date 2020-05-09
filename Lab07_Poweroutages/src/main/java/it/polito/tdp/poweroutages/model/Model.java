package it.polito.tdp.poweroutages.model;

import java.util.List;
import it.polito.tdp.poweroutages.model.Research;
import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<PowerOutage> getPOs(Nerc nerc) {
		return podao.getPOs(nerc);
	}

	public List<PowerOutage> getEvents(Nerc nerc, int years, int hours) {
		Research result = new Research();
		
		List<PowerOutage> res = result.research(nerc, years, hours);
		System.out.println("TOT Affected: " + result.getTotAffected(res));
		System.out.println("TOT Hours: " + result.getTotHours(res));
		return res;
	}
}
