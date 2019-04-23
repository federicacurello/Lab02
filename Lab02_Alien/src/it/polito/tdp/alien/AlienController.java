/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dizionario= new AlienDictionary();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtWord"
    private TextField txtWord; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();
    	dizionario.doReset();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	txtResult.clear();
    	String riga= txtWord.getText().toLowerCase();
    	
    	if(riga== null || riga.length()==0) {
    		txtResult.setText("Inserire una o due parole");
    		return;
    	}
    	StringTokenizer st= new StringTokenizer( riga, " ");
    	
    	String alienWord= st.nextToken(); //estraggo la prima parola
    	
    	if(st.hasMoreTokens()) {
    		String translation= st.nextToken();
    		if(!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		dizionario.addWord(alienWord, translation);
    		txtResult.setText("La parola "+alienWord+ " con traduzione "+ translation+" è stata inserita");
    	}
    	
    	else {
    		if(!alienWord.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		
    	}
    		String translation= dizionario.translateWord(alienWord);
    		if(translation !=null)
    			txtResult.setText(translation);
    		else
    			txtResult.setText("La parola cercata non esiste nel dizionario");
    		
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}

