package pr_ueb1loesung;

import java.util.Scanner;

public class Leser {
	
	public String gesamtTotal() {
		//Scanner initialisieren
		Scanner sc = new Scanner(Leser.class.getResourceAsStream("umsatzdaten.txt"));
		
		//Variablen 
		String wort1 = sc.next();
		double zahl1 = sc.nextDouble();
		String wort2 = sc.next();
		double zahl2 = sc.nextDouble();
		String wort3 = sc.next();
		double zahl3 = sc.nextDouble();
		String wort4 = sc.next();
		double zahl4 = sc.nextDouble();

		//Ausgabe zusammensetzen
		String ausgabe = wort1 + ":\t" + zahl1 + " CHF\n";
		ausgabe = ausgabe + wort2 + ":\t" + zahl2 + " CHF\n";
		ausgabe += wort3 + ":\t" + zahl3 + " CHF\n";
		ausgabe += wort4 + ":\t" + zahl4 + " CHF\n";

		//Total berechnen
		double total=zahl1+zahl2+zahl3+zahl4;
		ausgabe+="Total:\t" + total + " CHF";
		
		//Scanner schliessen
		sc.close();
		
		return ausgabe;
	}
}
