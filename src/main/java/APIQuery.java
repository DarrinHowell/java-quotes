import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIQuery {

    public static Quote apiQuoteGenerator(String apiUrl) throws IOException {

        StringBuilder content = new StringBuilder();

        // attribution for code structure: https://canvas.instructure.com/courses/1476850/discussion_topics/7249178
        // set url object to contain api-url to be queried
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // use Gson to read the data and turn it into a apiquote class
        Gson gson = new Gson();
        APIQuote apiQuote = gson.fromJson(content.toString(), APIQuote.class);

        // turn this into a quote and then use the toString method
        Quote transformedQuote = apiQuote.apiQuoteTransformer();

        return transformedQuote;



    }

}
