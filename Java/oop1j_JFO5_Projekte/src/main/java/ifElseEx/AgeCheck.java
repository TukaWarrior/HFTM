package ifElseEx;

public class AgeCheck {

    public static void main(String[] args) {
        int meinAlter = 19; // I am 19; let me see if I can drive yet

        if (meinAlter >= 16) {
            System.out.println("Ich bin alt genug, um einen Führerschein zu besitzen!");
        } else {
            System.out.println("Ich bin noch nicht alt genug :*(");
        }
    }
}