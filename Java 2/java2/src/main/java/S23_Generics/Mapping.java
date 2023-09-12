package S23_Generics;

public class Mapping<K, V> {
    
    K key;
    V value;

    public Mapping (K key, V value){
    this.key = key;
    this.value = value;
    }

    @Override
    public String toString(){
        return "Jahr: " + this.key + " Fahrzeug: " + this.value;
    }

    public static void main(String[] args) {
        Mapping<Integer, String> car1 = new Mapping<>(1989, "GT-R");
        Mapping<Integer, String> car2 = new Mapping<>(1969, "Capri");
        Mapping<Integer, String> car3 = new Mapping<>(1953, "Corvette C1");

        System.out.println("Fahrzeuge:");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }
}
