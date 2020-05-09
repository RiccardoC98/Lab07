package it.polito.tdp.poweroutages.model;

import java.util.List;

import com.sun.scenario.effect.Blend.Mode;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		List<Nerc> nercs = model.getNercList();
		List<PowerOutage> MAACoutages = model.getPOs(nercs.get(2)); //MAAC è il 3 elemnto 

		
		System.out.println( model.getEvents(nercs.get(2), 5, 300));
	}

}
