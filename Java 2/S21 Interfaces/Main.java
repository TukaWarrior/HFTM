public class Main {

    public static void main(String[] args) {
        Blog firstBlog = new Blog("Titel", "Das-ist-ein Test.", "Author");
        Comment firstComment = new Comment("Das ist ein zweiter-Test.", "Author");

        //Search string from firstBlog
        System.out.println(firstBlog.getSearchString());
        
        //Search string from firstComment
        System.out.println(firstComment.getSearchString());
    }
}
