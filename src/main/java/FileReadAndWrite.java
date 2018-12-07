import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReadAndWrite {
    public static BufferedReader fileToReaderObject(){
        BufferedReader jsonReader;
        try {
            Path path = FileSystems.getDefault().getPath("assets", "recentquotes_json.txt");
            jsonReader = Files.newBufferedReader(path);
        } catch (IOException e) {
            System.out.println(e);
            jsonReader = null;
        }
        return jsonReader;
    }

    public static boolean hasBeenCached(Quote internetResponse){
        /* IF our resource data
        * */
        return false;
    }
}
