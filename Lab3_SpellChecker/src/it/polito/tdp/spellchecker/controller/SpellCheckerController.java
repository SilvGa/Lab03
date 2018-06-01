/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	private Model model ;
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ChLingua"
    private ChoiceBox<String> ChLingua; // Value injected by FXMLLoader

    @FXML // fx:id="txtFrase"
    private TextArea txtFrase; // Value injected by FXMLLoader

    @FXML // fx:id="txtSbagliate"
    private TextArea txtSbagliate; // Value injected by FXMLLoader

    @FXML // fx:id="labErrori"
    private Label labErrori; // Value injected by FXMLLoader

    @FXML // fx:id="labTempo"
    private Label labTempo; // Value injected by FXMLLoader

    @FXML
    void onCancella(ActionEvent event) {
    	txtFrase.clear();
    	txtSbagliate.clear();
    }

    @FXML
    void onClicca(ActionEvent event) {
    	txtSbagliate.clear();
    	String output=txtFrase.getText().toLowerCase();
    	output=output.trim();
    	if(output == null || output.equals("") || output.equals(" ")) {
    		txtSbagliate.appendText("Inserire un testo !!!!!");
    		return;
    	}
    	
    	String lingua = (String)ChLingua.getValue ();
    	
    	if(lingua==null||lingua=="") {
    		txtSbagliate.appendText("Scegliere una lingua");
    		return;
    	}
    	
    	model.impostaLingua(lingua);
    	String risultato=model.logica(output);
    	txtFrase.setText(model.pulisciTesto());
  
    	if(risultato==null|| risultato.equals("")) {
    		txtSbagliate.appendText("Complimenti!! non hai fatto nessun errore di calligrafia");
    		return;
    	}
    	
    	txtSbagliate.appendText("Le seguenti parole non sono valide per il dizionario "+lingua+"\n");
    	txtSbagliate.appendText(risultato);
    	ChLingua.setValue(null);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ChLingua != null : "fx:id=\"ChLingua\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtFrase != null : "fx:id=\"txtFrase\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtSbagliate != null : "fx:id=\"txtSbagliate\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert labErrori != null : "fx:id=\"labErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert labTempo != null : "fx:id=\"labTempo\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
		
		txtFrase.setText("");
		
		ChLingua.getItems().add ("English");
		ChLingua.getItems().add ("Italian");
	}
}






