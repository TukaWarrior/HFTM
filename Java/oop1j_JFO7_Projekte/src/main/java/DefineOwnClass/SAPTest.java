package DefineOwnClass;

public class SAPTest {
    public static void main(String[] args){

        Arbeitsauftrag auftrag1 = new Arbeitsauftrag(1, "Abdeckung abgebrochen");

        Kunde a_anderson = new Kunde("Andrea", "Anderson", "Ahornweg 1", "1000", "Aarau", "062 000 00 01", auftrag1);
        Kunde b_baertschi = new Kunde("Beat", "Bärtschi", "Buchenweg 2", "2000", "Bern", "062 000 00 02");

        // Checking Information
        System.out.println("----------Checking Information for a_anderson----------");
        a_anderson.displayKunde();
        System.out.println();
        System.out.println("----------Checking Information for b_bärtschi----------");
        b_baertschi.displayKunde();
        System.out.println();

        // Testing Setter
        System.out.println("----------Testing Setter/Getter for a_anderson----------");
        a_anderson.setTelefonnummer("079 000 00 01");
        // Testing Getter
        System.out.println("Neue Telefonnummer: "+a_anderson.getTelefonnummer());
        System.out.println();

        System.out.println("----------Testing additional Methods----------");
        a_anderson.dispayWohnort();
        System.out.println();

        // Displays class-name and memory-adress if not overwritten
        System.out.println(a_anderson.toString());
        System.out.println();

        //Test 1 - Not Working - Creating new Arbeitsauftrag with a given name and assigning it to the corresponding Kunde
        // b_baertschi.neuerAuftrag("auftrag2", 2, "Beleuchtung brennt");
        // auftrag2.displayArbeitsauftrag();
        // System.out.println(auftrag2.toString());

        //Test 2 - Assign auftrag1 to Kunde b_baertschi
        // b_baertschi.setAuftrag(auftrag1);
        // b_baertschi.displayKunde();
    }
}