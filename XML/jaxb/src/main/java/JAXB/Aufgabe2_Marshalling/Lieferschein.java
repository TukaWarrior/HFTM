package JAXB.Aufgabe2_Marshalling;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlType(name = "lieferschein", propOrder = {"lieferscheinNr", "lieferDatum", "kunde", "positionen"})
@XmlAccessorType(XmlAccessType.FIELD) // Tells the marshaller to fill the Fields, noit the methods.
public class Lieferschein {

    // Variables
    @XmlAttribute(name = "nummer", required = true)
    private long lieferscheinNr;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @XmlElement(name= "lieferdatum", required = true)
    private LocalDate lieferDatum;
    @XmlElement(name = "kunde")
    private Kunde kunde;
    @XmlElementWrapper(name = "positionen")
    @XmlElement(name = "position")
    private List<LieferscheinPosition> positionen = new ArrayList<>();
    
    // Construictors
    public Lieferschein(){}

    public Lieferschein(long lieferscheinNr, LocalDate lieferDatum, Kunde kunde){
        this.lieferscheinNr = lieferscheinNr;
        this.lieferDatum = lieferDatum;
        this.kunde = kunde;
    }

    // Getters, Setters
    public long getLieferscheinNr(){
        return lieferscheinNr;
    }

    public void setLieferscheinNr(long lieferscheinNr){
        this.lieferscheinNr = lieferscheinNr;
    }

    public LocalDate getLieferDatum(){
        return lieferDatum;
    }

    public void setLieferDatum(LocalDate lieferDatum){
        this.lieferDatum = lieferDatum;
    }

    public Kunde getKunde(){
        return kunde;
    }

    public void setKunde(Kunde kunde){
        this.kunde = kunde;
    }

    public List<LieferscheinPosition> getPositionen(){
        return new ArrayList<>(positionen);
    }

    public void addPosition(LieferscheinPosition pos){
        this.positionen.add(pos);
    }

    @Override
    public String toString(){
        String info = "";
        info += "Lieferschein\n";
        info += "Kunde: " + this.kunde;
        String formatierung = "| %-9d | %-24s | %-3d |";
        info += "\n\r+-----------+--------------------------+-----+";
        info += "\n\r| POSITION: | ARTIKEL:                 | STK:|";
        info += "\n\r+-----------+--------------------------+-----+";
        for (LieferscheinPosition pos:positionen){
            info += "\n\r" + String.format(formatierung, pos.getPosNr(), pos.getArtikel(), pos.getMenge());
        }
        info += "\n\r+-----------+--------------------------+-----+";
        return info;
    }
}