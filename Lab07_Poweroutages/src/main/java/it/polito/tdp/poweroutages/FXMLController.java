package it.polito.tdp.poweroutages;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;
import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
	
    @FXML
    private ChoiceBox<String> boxNERC;

    @FXML
    private TextField txtYears;

    @FXML
    private TextField txtHours;

    @FXML
    private Button btnCalculate;

    @FXML
    private TextArea txtArea;

    @FXML
    void initialize() {
    	
        PowerOutageDAO poDAO = new PowerOutageDAO();
        List<Nerc> nercs = new LinkedList<Nerc> ( poDAO.getNercList() );
        ObservableList<String> list = FXCollections.observableArrayList();
        
        // creating list containing all options
        for (Nerc n : nercs) {
        	list.add(n.getValue());
        }
        
        
        //populate the NERC Choicebox;  
        boxNERC.setItems(list);
    }

	public void setModel(Model model) {
		this.model = model;
	}
    
}

