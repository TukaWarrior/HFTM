public class Blog implements Searchable {

    private String title;
    private String content;
    private String author;

    public Blog(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getSearchString(){
        String searchString;
        searchString = title + FIELD_SEPERATOR + content;

        return searchString;
    }
}