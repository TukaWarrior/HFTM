package S21_Interface_Loesung;
import java.util.ArrayList;

public class Programm {
    public static void main(String[] args) {
        ArrayList<Searchable> searchableList = new ArrayList<>();
        searchableList.add(new Blog("Getting Started with Java","This is how to start your journey with the best programming environment..","Paul"));
        searchableList.add(new Blog("Interfaces to the rescue","How Interfaces can help to write clean code...","John"));
        searchableList.add(new Comment("Yes, Java rocks!","Jenny"));
        searchableList.add(new User("Java-Hacker"));

        System.out.println("Hits: " + searchHitCounter("Java", searchableList));
    }

    private static int searchHitCounter(String search, ArrayList<Searchable> searchList) {
        int counter = 0;
        for (Searchable searchable : searchList) {
            if(searchable.getSearchString().contains("Java")) {
                counter++;
            }
        }
        return counter;
    }
}