package strings_ex;

public class ShoppingCart {
    public static void main (String[] args){
        String custName = "Steve Smith";
        String firstName;
        int spaceIdx;
        
        // Such den Index des Leerzeichens in custName und 
        // weise ihn spaceIdx zu
        spaceIdx = custName.indexOf(" ");

        // Parse mit Hilfe der substring-Methode den Vornamen aus
        // dem Attribut custName und weise ihn firstName zu.
        firstName = custName.substring(0, spaceIdx);
        // gib firstName aus
        System.out.println(firstName);
    }
}