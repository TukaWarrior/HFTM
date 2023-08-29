import java.util.Scanner;

public class Alterskategorie {
    public static void main(String args[]) {

        int alter;
        String kategorie;

        Scanner sc = new Scanner(System.in);
        System.out.println("Transportkategorie");
        System.out.println("==================");
        System.out.println("Geben Sie das Alter des älteren Tänzers ein: ");
        alter = sc.nextInt();
        sc.close();

        if ((alter >= 0) && (alter <= 9)) {
            System.out.println("Schüler I");
        } else if (alter <= 11) {
            System.out.println("Schüler II");
        } else if (alter <= 13) {
            System.out.println("Junioren I");
        } else if (alter <= 15) {
            System.out.println("Junioren I");
        } else if (alter <= 18) {
            System.out.println("Jugend");
        } else if (alter >= 19) {
            System.out.println("Hauptklasse");
            if (alter >= 35) {
                System.out.println("Senioren I");
            }
            if (alter >= 45) {
                System.out.println("Senioren II");
            }
            if (alter >= 55) {
                System.out.println("Senioren III");
            }
        } else {
            System.out.println("Ungültige EIngabe");
        }
    }
}