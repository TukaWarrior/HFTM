package Aufgabe2_Loesung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Artikel {

    @XmlAttribute(name = "nummer")
    private int artikelNr;
    @XmlValue
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
