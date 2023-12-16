package ch.hftm;

public class Runterzaehlen {
    public static void main(String[] args) {
        // System.out.println(runterzaehlen(100));
        System.out.println(runterzaehlen3(2));
        // runterzaehlen2(100);

        // for (int i = 0; i < 10; i++){
        //     System.out.print(i);
        // }
    }

    private static String runterzaehlen(int zahl){
        if (zahl > 0){
            return zahl + " " + runterzaehlen(--zahl);
        }
        return "" + zahl;
    }


    private static void runterzaehlen2(int zahl){
        if (zahl > 0){
                System.out.println(zahl);
                runterzaehlen2(zahl-1);
        }
    }

    // Nicht lineare Rekursion 
    private static String runterzaehlen3(int zahl){
        if (zahl > 0){
            return zahl + " " + runterzaehlen3(zahl-1) + "|" + runterzaehlen3(zahl-1);
        }
        return "" + zahl;
    }
}