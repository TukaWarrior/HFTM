package ch.hftm;

public class Runterzaehlen {
    public static void main(String[] args) {
        // System.out.println(runterzaehlen2(100));
        // runterzaehlen2(100000);

        for (int i = 0; i < 1000; i++){
            System.out.print(i);
        }

        
        // System.out.println("Hello world!");
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
}