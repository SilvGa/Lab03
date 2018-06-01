package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	private final String ing="English";
	private final String it="Italian";
	
	private List<String> lingua;
	private List<RichWord> input;

	
	public Dictionary() {
		lingua= new ArrayList<>();
		input= new ArrayList<>();
	}
	
	public void loadDictionary(String language) {
		lingua.clear();
		if(ing.equals(language)) {
			try {
				 FileReader fr = new FileReader("rsc/English.txt");
				 BufferedReader br = new BufferedReader(fr);
				 String word;
				 while ((word = br.readLine()) != null) {
					 // Aggiungere parola alla struttura dati
					 lingua.add(word);
				 }
				 br.close();
	
				 }catch (IOException e){
					 System.out.println("Errore nella lettura del file");
				 }
		}else if(it.equals(language)) {
			try {
				 FileReader fr = new FileReader("rsc/Italian.txt");
				 BufferedReader br = new BufferedReader(fr);
				 String word;
				 while ((word = br.readLine()) != null) {
					 // Aggiungere parola alla struttura dati
					 word=word.toLowerCase();
					 lingua.add(word);
				 }
				 br.close();
	
				 }catch (IOException e){
					 System.out.println("Errore nella lettura del file");
				 }
		}
	}
	public List<RichWord> spellCheckText(List<String> inputTextList){
		input.clear();
		RichWord rw;
		for(String p:inputTextList) {
			p=this.controllaParola(p);
			if(!lingua.contains(p)) {
				rw=new RichWord(p);
				input.add(rw);
			}
		}
		return input;		
	}
	
	
	public String controllaParola(String parola) {
		String p=parola.toLowerCase();
		p=p.replaceAll("[^A-Za-z]", "");
		return p;
	}

	@Override
	public String toString() {
		return " " + input + "";
	}
	
	
}
