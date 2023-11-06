package S26_Lambda;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        // Erzeugen aus einem Array
        String [] arr = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(arr);

        // Erzeugen über eine Sequenz von Parametern
        Stream<String> stream2 = Stream.of("a", "b", "c");

        // Stream aus einer Collection erstellen
        Stream<Person> stream3 = personenListe.stream();

        // Stream über eine Lambda Methode erstellen
        Stream.generate(() -> "Element") .limit(20)
        Stream.iterate(0, i -> i < 10, i -> i +1);


        long anzahlElemente1 = stream1.stream().count();
        long anzahlElemente2 = stream2.stream().count();
        long anzahlElemente3 = stream3.stream().count();

        // Anzahl der Elemente in jedem Stream ausgeben
        System.out.println("Stream1: " + anzahlElemente1);
        System.out.println("Stream2: " + anzahlElemente2);
        System.out.println("Stream3: " + anzahlElemente3);
    }
}        