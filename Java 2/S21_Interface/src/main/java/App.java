import java.util.List;
import java.util.ArrayList;


public class App 
{
    public static void main(String[] args) {

        List<Searchable> searchableList = new ArrayList<>();

        searchableList.add(new Blog("First Test", "This is a test blog about Java.", "Java"));
        searchableList.add(new Blog("Second Test", "This is the second test blog about Java", "User2"));
        searchableList.add(new Comment("User3", "Java"));

        User user = new User ("User1");
        System.out.println(user);
        System.out.println("Hits :" + searchHitCounter("Java", searchableList));
    }

    public static int searchHitCounter(String search, List<Searchable> searchList){
        int counter = 0;
        for (Searchable searchable : searchList){
            if(searchable.getSearchString().contains("Java")){
                counter++;
            }
        }
        return counter;
    }
}
