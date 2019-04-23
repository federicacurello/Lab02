package it.polito.tdp.alien;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlienDictionary {
	
	List<Word> parole= new LinkedList<Word>();
	
	public void addWord(String alien, String trans) {
		Word w = new Word(alien, trans);
		if (parole.contains(w)) {
			parole.get(parole.indexOf(w)).setTranslation(trans);
			return;
		}
		parole.add(w);
	}

	public String translateWord(String alien) {
		Word w = new Word(alien);
		if (parole.contains(w)) {
			return parole.get(parole.indexOf(w)).getTranslation();
		}
		return null;
	}
	public void doReset(){
		parole.clear();
	}
	
}
