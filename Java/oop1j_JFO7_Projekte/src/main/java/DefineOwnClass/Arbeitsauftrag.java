package DefineOwnClass;

public class Arbeitsauftrag {
    // Fields
    private int auftragsnummer;
    private String auftragsbeschreibung;

    // Constructors
    public Arbeitsauftrag() {
    }

    public Arbeitsauftrag(int auftragsnummer, String auftragsbeschreibung){
        this.auftragsnummer = auftragsnummer;
        this.auftragsbeschreibung = auftragsbeschreibung;
    }

    // Getters
    public int getAuftragsnummer() {
        return auftragsnummer;
    }
    public String getAuftragsbeschreibung(){
        return auftragsbeschreibung;
    }

    // Setters
    public void setAuftragsNummer(int auftragsnummer){
        this.auftragsnummer = auftragsnummer;
    }

    // Methods
    public void displayArbeitsauftrag(){
        System.out.println("Auftragsnummer: "+auftragsnummer);
        System.out.println("Auftragsbeschreibung: "+auftragsbeschreibung);
    }
}
