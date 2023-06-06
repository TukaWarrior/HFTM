package DefineOwnClass;

public class Kunde {
    // Fields
    private String vorname;
    private String nachname;
    private String adresse;
    private String ortschaft;
    private String plz;
    private String telefonnummer;
    private Arbeitsauftrag arbeitsauftrag;

    // Constructors
    public Kunde() {
    }
    
    public Kunde(String vorname, String nachname, String adresse, String plz, String ortschaft, String telefonnummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.plz = plz;
        this.ortschaft = ortschaft;
        this.telefonnummer = telefonnummer;
    }

    public Kunde(String vorname, String nachname, String adresse, String plz, String ortschaft, String telefonnummer, Arbeitsauftrag arbeitsauftrag) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.plz = plz;
        this.ortschaft = ortschaft;
        this.telefonnummer = telefonnummer; 
        this.arbeitsauftrag = arbeitsauftrag;
    }

    // Getters
    public String getVorname() {
        return vorname;
    }
    
    public String getName() {
        return nachname;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public String getPlz(){
        return plz;
    }

    public String getOrtschaft() {
        return ortschaft;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public Arbeitsauftrag getArbeitsauftrag(){
        return arbeitsauftrag;
    }
    
    // Setters
    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    // Overwritten toString() with memory-adress
    @Override
    public String toString() {
        return "Kunde: " + vorname + " " + nachname + " @" + Integer.toHexString(hashCode());
    }

    // Methods
    public void displayKunde(){
        System.out.println("Vorname: "+vorname);
        System.out.println("Nachname: "+nachname);
        System.out.println("Adresse: "+adresse);
        System.out.println("PLZ: "+plz);
        System.out.println("Wohnort: "+ortschaft);
        System.out.println("Telefonnummer: "+telefonnummer);
        if (this.arbeitsauftrag == null){
            System.out.println("Kein Arbeitsauftrag vorhanden");
        }else{
            System.out.println("Auftragsnummer: " +arbeitsauftrag.getAuftragsnummer());
            System.out.println("Auftragsbeschreibung: " + arbeitsauftrag.getAuftragsbeschreibung());
        }
    }

    public void dispayWohnort(){
        System.out.println("Wohnort: "+adresse+", "+plz+" "+ortschaft);
    }

    // Test 1 - Not Working - Creating new Arbeitsauftrag with a given name and assigning it to the corresponding Kunde
    // public void neuerAuftrag(String auftragName, int auftaragNummer, String auftragBeschreibung){
    //     Arbeitsauftrag auftragName = new Arbeitsauftrag(auftaragNummer, auftragBeschreibung);
    //     this.arbeitsauftrag = arbeitsauftrag;
    // }

    // Test 2 - Assign auftrag1 to Kunde b_baertschi
    // public void setAuftrag(Arbeitsauftrag arbeitsauftrag) {
    //     this.arbeitsauftrag = arbeitsauftrag;
    // }
}
