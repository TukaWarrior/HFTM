package casting02;

public class Casting02 {
    public static void main(String[] args) {

        // Weltbevölkerung today
        long currentWorldPop = 7000000000L;
        System.out.println("Current World Population: " + currentWorldPop);

        // Weltbevölkerung 1950, Quelle: United Nations Population Division
        // 2.52 Milliarden
        long africaPop = 221000000;
        long asiaPop = 1402000000;
        long europePop = 547000000;
        long americasPop = 339000000;
        long oceanaPop = 13000000;
        long totalPop = africaPop + asiaPop + europePop + americasPop + oceanaPop;
        System.out.println("Weltbevölkerung 1950: " + totalPop);

        // Die aktuelle Bevölkerung in Asien macht ca. 60% der Weltbevölkerung aus
        double percentAsia = 0.6;
        long currentAsiaPop = (long) (currentWorldPop * percentAsia);
        System.out.println("Aktuelle Bevölkerung in Asien: " + currentAsiaPop);
    }
}