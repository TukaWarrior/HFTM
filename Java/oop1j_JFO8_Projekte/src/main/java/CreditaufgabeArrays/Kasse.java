// Frage den Benutzer zuerst nach der Anzahl an Positionen die er insgesamt einbuchen möchte.
// Frage ihn pro Artikel zuerst nach der Bezeichnung, dann nach der Anzahl und schlussendlich nach dem Stückpreis.
// Wenn die eingegebene Anzahl an Positionen erreicht wurde, soll dem Benutzer eine Quittung inkl. dem Preis pro Position und dem Total-Preis ausgegeben werden.
// Schreibe dazu eine Klasse Position, welche die Artikel-Infos aufnimmt und ein Programm Kasse, welches beim Aufruf der Methoden die Positionen in einem Array sammelt.

package CreditaufgabeArrays;

public class Kasse {

    public static void main(String[] args) {

    // Create new Shopping List
        Position receipt01 = new Position();
        receipt01.enterPositions();

        // Print Receipt
        String[] itemDescription = receipt01.getItemDescription();
        int[] itemCount = receipt01.getItemCount();
        double[] itemPrice = receipt01.getItemPrice();
        double priceTotal = 0;

        System.out.println("-------------------------Receipt-------------------------");
        System.out.println("Pos.  Description          Ammount    Price      Subtotal  ");
        for (int i = 0; i < itemDescription.length; i++) {
            String stritemNo = String.valueOf(i + 1);
            String stritemDescription = itemDescription[i];
            String stritemCount = String.valueOf(itemCount[i] + "x");
            String srtitemPrice = String.valueOf("CHF " + itemPrice[i]);
            String stritemPriceTotal = String.valueOf("CHF " + itemPrice[i] * itemCount[i]);

            System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", stritemNo, stritemDescription, stritemCount,
                    srtitemPrice, stritemPriceTotal);
            priceTotal = priceTotal + (itemPrice[i] * (double) itemCount[i]);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Total:                                           CHF " + priceTotal);
    }
}