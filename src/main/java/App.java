import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);

            }
            System.out.println(content);
            in.close();
        }catch(IOException e) {
            BufferedReader successfulRead = FileReadAndWrite.fileToReaderObject();
            Gson gson = new Gson();
            Quote[] books = gson.fromJson(successfulRead, Quote[].class);
            String cachedQuotes = Randomizer.generateQuoteAndAuthor(books);
            System.out.println("Unfortunately your internet isn't working properly, here is a random quote from our cache.\n" + cachedQuotes);
        }
//
    }
}














