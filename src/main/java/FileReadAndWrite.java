import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadAndWrite {

    // static methods:

        // Path or File if Path doesn't work

        // Create a new file


        // Pass it into a reader(?)

    public static Quote[] fileToReaderObject(String directory, String file) throws IOException{

        // create the path and read the file
        BufferedReader jsonReader;
        Path path = FileSystems.getDefault().getPath(directory, file);
        jsonReader = Files.newBufferedReader(path);

        // use Gson to read the data and turn it into a book class
        Gson gson = new Gson();
        Quote[] quotes = gson.fromJson(jsonReader, Quote[].class);

        return quotes;
    }
}
