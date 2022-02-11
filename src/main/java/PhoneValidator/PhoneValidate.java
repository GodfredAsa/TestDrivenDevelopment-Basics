package PhoneValidator;

public class PhoneValidate {

    public static final int PHONE_NUMBER_LESS_TEN = 10;
    public static final int LENGTH_OF_PHONE_NUMBER = 10;


    public boolean validNumber(String phone) {
        if (phone.length() < PHONE_NUMBER_LESS_TEN || phone.length()> 10) {
            return false;
        }

        for (int indexOfDigit = 0; indexOfDigit < LENGTH_OF_PHONE_NUMBER; indexOfDigit++) {
            if (CHARACTER_PHONE_NUMBER(phone, indexOfDigit)) return false;
        }
        return true;
    }

    private boolean CHARACTER_PHONE_NUMBER(String phone, int indexOfDigit) {
        return !Character.isDigit(phone.charAt(indexOfDigit));
    }

}
