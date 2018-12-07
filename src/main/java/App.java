import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Arrays;

/*
 * App prints quote and author from a collection of books at random.
 */
public class App {

    public static void main(String[] args) {

    // use FileReadAndWrite class to get a file reader in JSON format
    BufferedReader successfulRead = FileReadAndWrite.fileToReaderObject();

    // use Gson to read the data and turn it into a book class
    Gson gson = new Gson();
    Book[] books = gson.fromJson(successfulRead, Book[].class);

    // find a book randomly within our array and return quote and author
    String newQuoteAndAuthor = Randomizer.generateQuoteAndAuthor(books);

    // print
    System.out.println(newQuoteAndAuthor);
    }
}














