package S21_Interface_Loesung;
public class Comment implements Searchable {
    private String content;
    private String author;

    public Comment(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getSearchString() {
        return content;
    }
    
}