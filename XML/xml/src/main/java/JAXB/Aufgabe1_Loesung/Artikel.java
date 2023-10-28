package JAXB.Aufgabe1_Loesung;

public class Artikel {

    private int artikelNr;
    private String bezeichner;
    
    public Artikel() {
    }
    public Artikel(int artikelNr, String bezeichner) {
        this.artikelNr = artikelNr;
        this.bezeichner = bezeichner;
    }

    public int getArtikelNr() {
        return artikelNr;
    }
    public void setArtikelNr(int artikelNr) {
        this.artikelNr = artikelNr;
    }
    public String getBezeichner() {
        return bezeichner;
    }
    public void setBezeichner(String bezeichner) {
        this.bezeichner = bezeichner;
    }
    @Override
    public String toString() {
        return artikelNr + "-" + bezeichner;
    }
}