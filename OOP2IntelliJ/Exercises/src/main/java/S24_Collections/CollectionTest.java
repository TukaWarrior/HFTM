package S24_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CollectionTest {

    public static void main(String[] args){
        ArrayList<String> namen = new ArrayList<>();
        HashSet<String> namen2 = new HashSet<>();

        namen.add("Luca");
        boolean added = namen.add("Nicola");
        namen.add(1, "Andres");
        namen.add("Luca");

        System.out.println("Unsortierter ArrayList");
        for (String name : namen){
            System.out.println(name);
        }

        Collections.sort(namen);

        System.out.println("Sortierter Inhalt ArrayList");
        for (String name : namen){
            System.out.println(name);
        }

        namen2.add("Luca");
        boolean added2 = namen2.add("Nicola");
        namen2.add("Andres");
        namen2.add("Luca");

        System.out.println("Unsortierter Inhalt HashSet");
        for (String name : namen2){
            System.out.println(name);
        }
    }
}
