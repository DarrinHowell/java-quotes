public class APIQuote {
    private String quoteText;
    private String quoteAuthor;
    private String senderName;
    private String senderLink;
    private String quoteLink;

    public APIQuote(String quoteText, String quoteAuthor, String senderName, String senderLink){
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
        this.senderName = senderName;
        this.senderLink = senderLink;
    }

    // convert an API quote object into a quote object
    public Quote apiQuoteTransformer(){

        Quote newQuote = new Quote(null, this.quoteAuthor, null, this.quoteText);

        return newQuote;
    }
}
