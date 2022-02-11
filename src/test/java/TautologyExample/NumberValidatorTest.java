package TautologyExample;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class NumberValidatorTest {
    private  NumberValidator numberValidator;


    @Before
    public void setup(){
       numberValidator = new NumberValidator();
    }

    @Test
    public void shouldGetIfIsPrime(){
        int number = 3;
        boolean result  = numberValidator.isItPrime(number);
        assertTrue(result);

    }

    @Test
    public void isNotDivisibleByTwo(){
        int [] listNumbers = {1,3,5,7,9,11};
        for (int listNumber : listNumbers) {
            assertFalse(numberValidator.divisibleBy2(listNumber));
        }
    }

}