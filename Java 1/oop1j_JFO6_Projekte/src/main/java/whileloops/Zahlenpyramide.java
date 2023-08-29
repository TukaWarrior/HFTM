public class Zahlenpyramide {

    public static void main(String[] args) {

        // Anzahl der Zeilen
        int n = 7;

        System.out.println("Zahlenpyramide \n--------------");

        for (int i = 1; i <= n; i++) {

            // Leerzeichen vor der Zahl ausgeben
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Zahlen ausgeben
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }

            // Zeilenumbruch
            System.out.println();
        }
    }
}