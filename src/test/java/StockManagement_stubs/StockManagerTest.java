package StockManagement_stubs;

import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class StockManagerTest {
    ExternalISBNDataService testWebService;
    ExternalISBNDataService testDatabaseService;
    StockManager stockManager;


    @Before
    public void setup(){
        testWebService = mock(ExternalISBNDataService.class);
        testDatabaseService = mock(ExternalISBNDataService.class);
        stockManager = mock(StockManager.class);


    }

    @Test
    public void shouldGetCorrectLocatorCode(){

        when(testWebService.lookup(anyString())).thenReturn(new Book("0140177396", "abc", "abc"));
//        when(testDatabaseService.lookup(anyString())).thenReturn(null);

        stockManager.setDatabaseService(testDatabaseService);
        stockManager.setWebService(testWebService);

        stockManager.getLocatorCode(stockManager.getLocatorCode("0140177396"));
        assertEquals("7396A1", stockManager.getLocatorCode("0140177396"));

    }

    @Test
    public void databaseIsUsedIfDataIsPresent(){
        ExternalISBNDataService databaseService  = mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);

        when(databaseService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));


        StockManager stockManager = mock(StockManager.class);
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);

        String locator =  stockManager.getLocatorCode("0140177396");
        verify(databaseService, times(1)).lookup(anyString());
        verify(webService, times(0)).lookup(anyString());

    }
//
//
//    @Test
//    public void webServiceIsUsedIfDataIsNotPresentInDatabase(){
//        ExternalISBNDataService databaseService  = mock(ExternalISBNDataService.class);
//        ExternalISBNDataService webService = mock(ExternalISBNDataService.class);
//
////        when(databaseService.lookup("0140177396")).thenReturn(null);
//        when(webService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));
//
//
//        StockManager stockManager = mock(StockManager.class);
//        stockManager.setWebService(webService);
////        stockManager.setDatabaseService(databaseService);
//
////        String locator =  stockManager.getLocatorCode("0140177396");
////        verify(databaseService ).lookup("0140177396");
////        verify(webService, times(1)).lookup(anyString());
//
//    }

}