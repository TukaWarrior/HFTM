public class Comment implements Searchable {
    private String content;
    private String author;

    public Comment(String author, String content){
        this.content = content;
        this.author = author;
    }


// Getter, Setter
    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getSearchString(){
        String searchString;
        searchString = content;
        return searchString;
    }
    
}