package S24_Collections.Sortierung;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Personen {
    public static void main(String[] args) {

        List<Person> pList = new ArrayList<>();

        Person hans = new Person("Hans",12);
        Person hanna = new Person("Hanna",11);

        pList.add(hans);
        pList.add(hanna);
        pList.add(new Person("Hugo",37));
        pList.add(new Person("Havilah",11));

        System.out.println(pList);

        System.out.println("---SORT---");
        Collections.sort(pList);
        System.out.println(pList);

        System.out.println("---SORT--- Nach Alter Aufsteigend mit externem Sorter");
        Collections.sort(pList, new PersonAgeDescendingComparator());
    }
}
