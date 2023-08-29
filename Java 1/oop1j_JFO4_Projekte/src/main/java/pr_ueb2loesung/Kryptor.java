package pr_ueb2loesung;

public class Kryptor {
	
	public String verschluesseln(String passwort) {
		String verschluesselt = "";
		verschluesselt += "" + (char)(passwort.charAt(0)-7);
		verschluesselt += "" + (char)(passwort.charAt(1)+9);
		verschluesselt += "" + (char)(passwort.charAt(2)-7);
		verschluesselt += "" + (char)(passwort.charAt(3)+9);
		verschluesselt += "" + (char)(passwort.charAt(4)-7);
		verschluesselt += "" + (char)(passwort.charAt(5)+9);
		verschluesselt += "" + (char)(passwort.charAt(6)-7);
		verschluesselt += "" + (char)(passwort.charAt(7)+9);
		return verschluesselt;
	}
	
	public String entschluesseln(String passwort) {
		String entschluesselt = "";
		entschluesselt += "" + (char)(passwort.charAt(0)+7);
		entschluesselt += "" + (char)(passwort.charAt(1)-9);
		entschluesselt += "" + (char)(passwort.charAt(2)+7);
		entschluesselt += "" + (char)(passwort.charAt(3)-9);
		entschluesselt += "" + (char)(passwort.charAt(4)+7);
		entschluesselt += "" + (char)(passwort.charAt(5)-9);
		entschluesselt += "" + (char)(passwort.charAt(6)+7);
		entschluesselt += "" + (char)(passwort.charAt(7)-9);
		return entschluesselt;
	}

}
