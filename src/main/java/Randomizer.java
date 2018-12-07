import java.util.Random;

public class Randomizer {

    public static String generateQuoteAndAuthor(Book[] books){

        int maxIdx = books.length;

        Random rand = new Random();
        int next = rand.nextInt(maxIdx);

        return books[next].toString();

    }
}
