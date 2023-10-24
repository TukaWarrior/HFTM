package S26_Lambda;

import java.util.List;
import java.util.ArrayList;

public class A1_PersonenManager {

    public static void main(String[] args){

        List<A1_Person> pList = new ArrayList <>();

        pList.add(new A1_Person("Joe", "Tyler", 12));
        pList.add(new A1_Person("Harry", "Hasler", 37));
        pList.add(new A1_Person("Hanny", "Truttman", 11));

        pList.addAll(List.of(
            new A1_Person("Joe", "Tyler", 12),
            new A1_Person("Harry", "Hasler", 37),
            new A1_Person("Hanny", "Truttman", 11)));

        for (A1_Person person : pList){
            System.out.println(person);
        }

        pList.forEach(person->System.out.println(person));
    }

}
