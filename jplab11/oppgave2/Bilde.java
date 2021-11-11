package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	// TODO - objekt variable
	protected String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {	
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return url;

	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	public int getId() {
		return super.getId();
	}

	public void setId(int id) {
		super.setId(id);
	}

	public String getBruker() {
		return super.getBruker();
	}

	public void setBruker(String bruker) {
		super.setBruker(bruker);
	}

	public String getDato() {
		return super.getDato();
	}

	public void setDato(String dato) {
		super.setDato(dato);
	}

	public String getTekst() {
		return super.getTekst();
	}

	public void setTekst(String tekst) {
		super.setTekst(tekst);
	}

	public int getLikes() {
		return super.getLikes();
	}

	public void setLikes(int likes) {
		super.setLikes(likes);
	}

	@Override
	public String toString() {
		return "BILDE\n"+super.getId()+"\n"+super.getBruker()+"\n"+super.getDato()+"\n"+super.getLikes()+"\n"+super.getTekst()+"\n"+url+"\n";

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
