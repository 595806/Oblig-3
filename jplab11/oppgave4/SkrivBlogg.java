package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) throws Exception {
		File bloggfil = new File(mappe+filnavn);
		PrintWriter skriver = new PrintWriter(bloggfil);
		skriver.println(samling.getAntall());
		for(Innlegg i : samling.getSamling()) {
			if(i != null) {
				skriver.println(i.toString());
			}
		}
		skriver.close();
		return true;
	}
}
