package pr_ueb2loesung;

import java.util.Scanner;

public class PasswortClient {

	public static void main(String[] args) {
		Kryptor k = new Kryptor();
		// Passwort eingeben lassen
		System.out.print("Passwort eingeben: ");
		Scanner sc = new Scanner(System.in);
		String pw = sc.next();
		
		// Passwort verschlüsseln
		String verschluesselt = k.verschluesseln(pw);
		// Passwort erneut eingeben lassen
		System.out.print("Passwort wiederholen: ");
		String pw2 = sc.next();
		// 1. Passwort entschlüsseln
		String entschluesselt = k.entschluesseln(verschluesselt);
		// Ergebnis des Passwortvergleichs ausgeben
		System.out.println("Das Passwort ist gleich: " + entschluesselt.equals(pw2));
		
		sc.close();
	}

}
