package JAXB.Aufgabe2_Loesung;

public class LieferscheinPosition {
    private int posNr;
    private int menge;
    private Artikel artikel;
    
    public LieferscheinPosition() {
    }
    public LieferscheinPosition(int posNr, int menge, Artikel artikel) {
        this.posNr = posNr;
        this.menge = menge;
        this.artikel = artikel;
    }
    public int getPosNr() {
        return posNr;
    }
    public void setPosNr(int posNr) {
        this.posNr = posNr;
    }
    public int getMenge() {
        return menge;
    }
    public void setMenge(int menge) {
        this.menge = menge;
    }
    public Artikel getArtikel() {
        return artikel;
    }
    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }
}