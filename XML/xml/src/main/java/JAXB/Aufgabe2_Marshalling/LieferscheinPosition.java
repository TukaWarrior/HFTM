package JAXB.Aufgabe2_Marshalling;

public class LieferscheinPosition{

    // Variables
    private int posNr;
    private int menge;
    private Artikel artikel;

    // Constructors
    public LieferscheinPosition(){}

    public LieferscheinPosition(int posNr, int menge, Artikel artikel){
        this.posNr = posNr;
        this.menge = menge;
        this.artikel = artikel;
    }

    // Getters, Setters
    public int getPosNr(){
        return posNr;
    }
    public void setPosNr(int posNr){
        this.posNr = posNr;
    }

    public int getMenge(){
        return menge;
    }
    public void setMenge(int menge){
        this.menge = menge;
    }

    public Artikel getArtikel(){
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }
}

