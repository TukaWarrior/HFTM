package GarageApp;

public class Main{
    public static void main(String[] args){
        Fahrzeug f1 = new Auto();
        System.out.println(f1);
        System.out.println(f1.signal());

        System.out.println("----------");
        Fahrzeug f2 = new Fahrrad();
        System.out.println(f2);
        System.out.println(f2.signal());

        System.out.println("----------");
        f2.setHersteller("Villager");
        System.out.println(f2);
    }
}