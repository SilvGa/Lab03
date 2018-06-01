package it.polito.tdp.spellchecker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Model {
	private Dictionary d;
	private String lingua;
	private List<String> parole;
	
	public Model() {
		d=new Dictionary();
		parole=new ArrayList<>();
	}
	
	public String logica(String output) {
		parole.clear();
		StringTokenizer st =  new  StringTokenizer (output, "  " );
		parole.add(st.nextToken ());
		while(st.hasMoreTokens ()) {
			parole.add(st.nextToken ());
		}
		StringBuilder sb= new StringBuilder();
		for(RichWord rw:d.spellCheckText(parole)) {
			sb.append(rw.toString());
		}
		return ""+sb;
	}
	
	
	public void impostaLingua(String l) {
		d.loadDictionary(l);
		lingua=l;
	}
	
	public String pulisciTesto() {
		StringBuilder sb= new StringBuilder();
		for(String st:parole) {
			sb.append(d.controllaParola(st)+" ");
		}
		
		return ""+sb;
	}
	
}
