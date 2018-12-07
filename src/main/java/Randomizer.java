import java.util.Random;

public class Randomizer {
    public static String generateQuoteAndAuthor(Quote[] quotes){
        int maxIdx = quotes.length;
        Random rand = new Random();
        int next = rand.nextInt(maxIdx);
        return quotes[next].toString();
    }
}
