package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	@SuppressWarnings("finally")
	public static Blogg les(String mappe, String filnavn) throws Exception {
		Blogg b = null;
		try {
			File bloggfil = new File(mappe+filnavn);
			Scanner leser = new Scanner(bloggfil);
			
			String linje = leser.nextLine();
			b = new Blogg(Integer.parseInt(linje));
			System.out.println(linje);
			while(leser.hasNextLine()) {
				String sjekk = leser.nextLine();
				System.out.println(sjekk);
				if(sjekk.equals(TEKST)) {
					b.leggTil(new Tekst(Integer.parseInt(leser.nextLine()), leser.nextLine(), leser.nextLine(), Integer.parseInt(leser.nextLine()), leser.nextLine()));
				} else if(sjekk.equals(BILDE)) {
					b.leggTil(new Bilde(Integer.parseInt(leser.nextLine()), leser.nextLine(), leser.nextLine(), Integer.parseInt(leser.nextLine()), leser.nextLine(), leser.nextLine()));
				}
			}
			leser.close();
			System.out.println(b.toString());
		} catch(FileNotFoundException e) {
			System.out.println("Kunne ikke finne filen");
		} finally {
			return b;	
		}
	}
}
