package JSONP.Aufgabe01_Loesung;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;

public class Lieferschein {

    @JsonbProperty(value = "nummer")
    private long lieferscheinNr;
    @JsonbDateFormat("dd.MM.yyyy")
    private LocalDate lieferDatum;
    private Kunde kunde;
    private List<LieferscheinPosition> positionen = new ArrayList<>();

    public Lieferschein() {
    }
    public Lieferschein(long lieferscheinNr, LocalDate lieferDatum, Kunde kunde) {
        this.lieferscheinNr = lieferscheinNr;
        this.lieferDatum = lieferDatum;
        this.kunde = kunde;
    }
    public long getLieferscheinNr() {
        return lieferscheinNr;
    }
    public void setLieferscheinNr(long lieferscheinNr) {
        this.lieferscheinNr = lieferscheinNr;
    }
    public LocalDate getLieferDatum() {
        return lieferDatum;
    }
    public void setLieferDatum(LocalDate lieferDatum) {
        this.lieferDatum = lieferDatum;
    }
    public Kunde getKunde() {
        return kunde;
    }
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
    public List<LieferscheinPosition> getPositionen() {
        return new ArrayList<>(positionen);
    }
    public void addPosition(LieferscheinPosition pos) {
        this.positionen.add(pos);
    }
    @Override
    public String toString() {
        String info = "";
        info += "Lieferschein";
        info += "\n\rKunde: " + this.kunde;
        String formatierung = "| %-9d | %-28s | %-4d |";
        info += "\n\r+-----------+------------------------------+------+";
        info +=   "\n\r| POSITION: | Artikel:                     | STK: |";
        info +=   "\n\r+-----------+------------------------------+------+";
        for (LieferscheinPosition pos: positionen) {
            info += "\n\r" + String.format(formatierung, pos.getPosNr(), pos.getArtikel(), pos.getMenge());
        }
        
        info += "\n\r+-----------+------------------------------+------+\n\r";
        return info;
    }

    
}
