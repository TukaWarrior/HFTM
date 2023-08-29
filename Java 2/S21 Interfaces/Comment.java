public class Comment implements Searchable {

    private String content;
    private String author;

    public Comment(String author, String content){
        this.author = author;
        this.content = content;
    }

    public String getSearchString() {
        return this.content;
    }
}