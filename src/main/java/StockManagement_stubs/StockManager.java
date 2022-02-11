package StockManagement_stubs;



public class StockManager {
    public static final int LAST_FOUR_DIGITS_ISBN = 4;
    private ExternalISBNDataService webService;
    private ExternalISBNDataService databaseService;


    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }
    public void setWebService(ExternalISBNDataService webService) {
        this.webService = webService;
    }


    public String getLocatorCode(String isbn){
        Book book = databaseService.lookup(isbn); // find from databaseService first if null  get check webService
                if(book==null) book =  webService.lookup(isbn);

                StringBuilder sbf = new StringBuilder();

        sbf.append(isbn.substring(isbn.length() - LAST_FOUR_DIGITS_ISBN));
        sbf.append(book.getAuthor().charAt(0));
        sbf.append(book.getTitle().split(" ").length);

        return sbf.toString();
    }
}
