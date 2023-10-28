package JAXB.Aufgabe1_Ausgangslage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lieferschein {

    // Variables
    private long lieferscheinNr;
    private LocalDate lieferDatum;
    private Kunde kunde;
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
        String formatierung = "| %-9d | %-28s | %-4d |";
        info += "\n\r+---------+----------------------------+-----+";
        info += "\n\r| POSITION: | ARTIKEL:                 | STK: |";
        info += "\n\r+---------+----------------------------+-----+";
        for (LieferscheinPosition pos:positionen){
            info += "\n\r" + String.format(formatierung, pos.getPosNr(), pos.getArtikel(), pos.getMenge());
        }
        info += "\n\r+---------+----------------------------+-----+";
        return info;
    }
}
