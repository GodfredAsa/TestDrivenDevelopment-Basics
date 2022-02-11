package PhoneValidator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class PhoneValidateTest {

    @Mock
    PhoneValidate validate;

    @Before
    public void setup(){
        validate = new PhoneValidate();
    }


    @Test
    public void lengthOfPhoneIsLessThan10(){
        boolean result =  validate.validNumber("01234567");
        assertFalse(result);
    }


    @Test
    public void phoneNumberContainsCharacters(){
        boolean result =  validate.validNumber("abcdefght");
        assertFalse(result);
    }

    @Test
    public void validPhoneNumber(){
        PhoneValidate validate = new PhoneValidate();
        boolean result =  validate.validNumber("0544700249");
        assertTrue(result);
    }





}