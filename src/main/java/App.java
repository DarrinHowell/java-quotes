import java.io.IOException;

/*
 * App prints quote and author from a collection of books at random.
 */
public class App {

    public static void main(String[] args) {

        // make an API call and print out a quote procured at random from API of choice
        try {
            String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
            Quote apiQuote = APIQuery.apiQuoteGenerator(url);
            System.out.println(apiQuote.toString());

        // if something goes wrong with the API call, render a quote from a file at random
        } catch (IOException e) {
            try {
                String rootDirectory = "assets";
                String fileName = "recentquotes_json.tx";

                Quote[] quotes = FileReadAndWrite.fileToReaderObject(rootDirectory, fileName);
                String newQuoteAndAuthor = Randomizer.generateQuoteAndAuthor(quotes);
                System.out.println(newQuoteAndAuthor);

            // if the file path is off, alert the client that something went wrong
            } catch (IOException err) {
                System.out.println("API request failed. Fetching data from file failed: " + err);

            }
        }
    }
}














