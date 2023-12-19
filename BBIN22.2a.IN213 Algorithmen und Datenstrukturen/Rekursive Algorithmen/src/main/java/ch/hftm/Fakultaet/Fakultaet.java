package ch.hftm.Fakultaet;

public class Fakultaet {

    public static void main(String[] args) {

        long n = 10;
        for (long i = 0; i < n; i++){
            long resultat = fak(i);
            System.out.println("Die Fakultät von " + i + " ist " + resultat);
        }
    }

    public static long fak(long n){
        if (n <= 1) {
            return 1;
        } else {
            return n * fak(n-1);
        }
    }
}