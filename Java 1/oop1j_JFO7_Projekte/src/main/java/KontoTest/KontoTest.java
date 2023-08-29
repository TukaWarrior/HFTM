package KontoTest;

public class KontoTest {
    public static void main(String[] args){
        Sparkonto postKonto = new Sparkonto();
        postKonto.name = "Testkonto";
        postKonto.saldo = 100.00;
        postKonto.Auszahlen(50.00);
    }
}
