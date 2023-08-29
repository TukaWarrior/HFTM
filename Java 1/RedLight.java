import java.util.Scanner;

public class RedLight {

    public static void main(String args[]) {

        int colorCode;
        String nextColor;

        Scanner sc = new Scanner(System.in);
        System.out.println("Gib einen Farbcode ein: ");
        colorCode = sc.nextInt();
        sc.close();

        switch (colorCode) {
            case 0:
                nextColor = "gelb";
                break;
            case 1:
                nextColor = "grün";
                break;
            case 2:
                nextColor = "gelb";
                break;
            case 3:
                nextColor = "rot";
                break;
            default:
                System.out.println("Falscher Farbcode");
                return;
        }

        System.out.println("Die nächste Signalfarbe ist " + nextColor);
    }
}