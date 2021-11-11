package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// TODO: objektvariable 
	protected Innlegg[] tabell;
	protected int nesteLedig;

	public Blogg() {
		tabell = new Innlegg[20];
		nesteLedig = 0;
	}

	public Blogg(int lengde) {
		tabell = new Innlegg[lengde];
		nesteLedig = 0;
	}
	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return tabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		if(innlegg == null) return -1;
		int idx = -1;
		for(int i = 0; i < tabell.length; i++) {
			if(tabell[i] != null && innlegg != null) {
				if(innlegg.erLik(tabell[i])) idx = i;
			}
		}
		System.out.println(idx);
		return idx;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
		for(Innlegg i : tabell) {
			if(i != null && innlegg != null) {
				if(i.erLik(innlegg)) finnes = true;	
			}
		}
		System.out.println("FINNES"+finnes);
		return finnes;
	}

	public boolean ledigPlass() {
		return nesteLedig != tabell.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean added = false;
		for(int i = 0; i < tabell.length; i++) {
			if(tabell[i] == null && !added) {
				tabell[i] = innlegg;
				added = true;
				nesteLedig++;
			}
		}
		return added;
	}
	
	public String toString() {
		String r = nesteLedig+"\n";
		for(Innlegg i : tabell) {
			if(i != null) {
				r = r+i.toString();
			}
		}
		return r;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] t = tabell;
		tabell = new Innlegg[(t.length * 2)];
		nesteLedig = 0;
		for(Innlegg i : t) {
			if(i != null) {
				tabell[nesteLedig] = i;
				nesteLedig++;
			}
		}
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean added = false;
		if(this.finnes(innlegg)) {
			added = false;
		} else {
			if(!this.ledigPlass()) this.utvid();
			this.leggTil(innlegg);
			added = true;
		}
		return added;
	}
	
	public boolean slett(Innlegg innlegg) {
		boolean slettet = false;
		if(this.finnes(innlegg)) {
			for(int i = 0; i < tabell.length; i++) {
				if(tabell[i].erLik(innlegg)) {
					tabell[i] = null;
					slettet = true;
					nesteLedig--;
				}
			}
		}
		return slettet;
	}
	
	public int[] search(String keyword) {
		int[] idliste = new int[tabell.length];
		int idx = 0;
		for(int i = 0; i < tabell.length; i++) {
			if(tabell[i].getTekst().toLowerCase().contains(keyword)) {
				idliste[idx] = tabell[i].getId();
				idx++;
			}
		}
		return idliste;
	}
}