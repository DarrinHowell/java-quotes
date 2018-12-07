
/*
 * App prints quote and author from a collection of books at random.
 */
public class App {

    public static void main(String[] args) {

    // use FileReadAndWrite class to read a file and convert it to a book array
    Book[] books = FileReadAndWrite.fileToReaderObject();

    // find a book randomly within our array and return quote and author
        if(books != null){
            String newQuoteAndAuthor = Randomizer.generateQuoteAndAuthor(books);
            
            // print
            System.out.println(newQuoteAndAuthor);
        }

    }
}














