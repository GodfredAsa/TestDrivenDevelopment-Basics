package ISBNValidator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidateISBNTest {
    ValidateISBN validator;

    @Before
    public void setup(){
        validator =  new ValidateISBN();

    }


    @Test
    public void checkValid10DigitsISBN(){

      boolean result =  validator.checkISBN("5237543115");
      assertTrue(result);
    }


    @Test
    public void checkValid13DigitISBN(){
        ValidateISBN validator =  new ValidateISBN();
        boolean result =  validator.checkISBN("9781853260087");
        assertTrue( "first isbn", result);

        result = validator.checkISBN("9781853267338");
        assertTrue("second isbn",result);
    }


    @Test
    public void validIS10DigitBNEndingWithX(){
        boolean result =  validator.checkISBN("012000030X");
        assertTrue(result); // should pass but fails
    }


    @Test
    public void checkAnInvalid10DigitISBN(){
        boolean result =  validator.checkISBN("0140449119");
        assertFalse(result);
    }


    @Test
    public void checkAnInvalid13DigitISBN(){
        boolean result =  validator.checkISBN("9781853267336");
        assertFalse(result);

    }


    @Test(expected = NumberFormatException.class)
    public void nineDigitLengthOfISBNNotAllowed(){
        validator.checkISBN("123456789");

    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericISBNNotAllowed(){
        validator.checkISBN("helloworld");
    }

    @Test
    public void shouldTestGetLocator(){

        String result = validator.stockLocator("0140177396",
                                            "Godfred Asumadu Asamoah",
                                            "Things that matters most");

        assertEquals("7396G4", result);
    }

}