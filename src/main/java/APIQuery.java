import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class APIQuery {

    public static Quote apiQuoteGenerator(String apiUrl, String directory, String file) throws IOException {

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

        // save quote to list of quote objects in json file
        cacheQuoteToFile(transformedQuote, directory, file);

        return transformedQuote;



    }

    public static void cacheQuoteToFile(Quote newQuote, String directory, String file){

        try {
            // read in the file
            BufferedReader jsonReader;
            Path path = FileSystems.getDefault().getPath(directory, file);
            jsonReader = Files.newBufferedReader(path);

            // convert to array list and add quote object to list
            Gson gson = new Gson();
            List<Quote> jsonArrList = gson.fromJson(jsonReader,new TypeToken<List<Quote>>(){}.getType());
            jsonArrList.add(newQuote);

            // convert back to json and write to file
            String jsonArrListReconverted = gson.toJson(jsonArrList);
            try (PrintWriter out = new PrintWriter("./assets/recentquotes_json.txt")) {
                out.println(jsonArrListReconverted);
                out.close();

            } catch (IOException e) {
                System.out.println("error occured while writing to file: " + e);
            }

        } catch (IOException e){
            System.out.println("Something went wrong while fetching from file: " + e);
        }

    }


}
