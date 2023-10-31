package JAXB.Aufgabe3_Loesung;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Kunde {

    // Variables
    @XmlAttribute(name = "nummer")
    private long kundeNr;
    @XmlElement(name = "name")
    private String name;
    @XmlTransient // Ignores the field
    private String adresse;
    @XmlTransient
    private String plz;
    @XmlTransient
    private String ort;

    // Constructors
    public Kunde(){}

    public Kunde(long kundeNr, String name, String adresse, String plz, String ort){
        this.kundeNr = kundeNr;
        this.name = name;
        this.adresse = adresse;
        this.plz = plz;
        this.ort = ort;
    }

    // Getters, Setters
    public long getKundeNr(){
        return kundeNr;
    }
    public void setKundeNr(long kundeNr){
        this.kundeNr = kundeNr;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAdresse(){
        return adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public String getPlz(){
        return plz;
    }
    public void setPlz(String plz){
        this.plz = plz;
    }

    public String getOrt(){
        return ort;
    }
    public void setOrt(String ort){
        this.ort = ort;
    }

    @Override
    public String toString(){
        return kundeNr + "-" + name + "-" + adresse + "-" + plz + "-" + ort;
    }
}