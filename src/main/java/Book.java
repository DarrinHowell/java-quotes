public class Book {
    private String[] tags;
    private String author;
    private String likes;
    private String text;

    public Book(String[] tags, String author, String likes, String text){
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }


    public String toString(){
        return "Quote:" + this.text + "- Author: " + this.author;
    }
}
