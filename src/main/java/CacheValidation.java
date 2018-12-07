import java.util.ArrayList;

public class CacheValidation {

    public ArrayList<Quote> cachedQuotes;

    public void addToCache(Quote quoteFromTheInternet){
        cachedQuotes.add(quoteFromTheInternet);
    }

    public boolean exisitsInCache(Quote quoteFromInternet){
        for(int i = 0; i < cachedQuotes.length; i++){
            if(quoteFromInternet.equals(cachedQuotes[i])){
                return true;
            }
        }
        addToCache(quoteFromInternet);
        return false;
    }

}
