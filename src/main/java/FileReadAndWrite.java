import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadAndWrite {

    // static methods:

        // Path or File if Path doesn't work

        // Create a new file


        // Pass it into a reader(?)

    public static Book[] fileToReaderObject(){
        // create the path and read the file
        BufferedReader jsonReader;

        try {
            Path path = FileSystems.getDefault().getPath("assets", "recentquotes_json.txt");
            jsonReader = Files.newBufferedReader(path);

        } catch (IOException e) {
            System.out.println(e);
            return null; // do something better practice after base functionality established.

        }

        // use Gson to read the data and turn it into a book class
        Gson gson = new Gson();
        Book[] books = gson.fromJson(jsonReader, Book[].class);

        return books;
    }
}
