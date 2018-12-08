import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API_Query {
    public static void main(String[] args) {

        StringBuffer content = new StringBuffer();

        // attribution for code structure: https://canvas.instructure.com/courses/1476850/discussion_topics/7249178
        try {
            // set url object to contain api-url to be queried
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            System.out.println(content);

        } catch (IOException e) {
            System.out.println("IOE Exception: " + e);

        }

        // use Gson to read the data and turn it into a book class
        Gson gson = new Gson();
        Quote[] quotes = gson.fromJson(content, Quote[].class);


    }
}
