package JAXB.Aufgabe1_Ausgangslage;

public class Artikel {
    
    // Variables
    private int artikelNr;
    private String bezeichner;

    // Constructors
    public Artikel(){}

    public Artikel(int artikelNr, String bezeichner){
        this.artikelNr = artikelNr;
        this.bezeichner = bezeichner;
    }

    // Getters, Setters
    public long getArtikelNr(){
        return artikelNr;
    }
    public void setArtikelNr(int artikelNr){
        this.artikelNr = artikelNr;
    }

    public String getBezeichner(){
        return bezeichner;
    }
    public void setBezeichner(String bezeichner){
        this.bezeichner = bezeichner;
    }

    @Override
    public String toString(){
        return this.artikelNr + "-" + this.bezeichner;
    }
}