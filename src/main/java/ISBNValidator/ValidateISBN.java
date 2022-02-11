package ISBNValidator;

import java.util.Arrays;
import java.util.stream.Collectors;


public class ValidateISBN {

    public static final int LONG_ISBN = 13;
    public static final int SHORT_ISBN = 10;
    public static final int MULTIPLIER_SHORT_ISBN = 11;
    public static final int MULTIPLIER_LONG_ISBN = 13;


    public boolean checkISBN(String isbn) {
        if(isbn.length() == LONG_ISBN) {
            return isLongISBN(isbn);
        }
        if(isbn.length() == SHORT_ISBN){
            return isValidShortISBN(isbn);
        }
      throw new NumberFormatException("ISBN must be 10 13 digits long");
    }



    private boolean isValidShortISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                    continue;
                }

                throw new NumberFormatException("ISBN should be numeric");

            }
            total = Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN - i);
        }
        return total % MULTIPLIER_SHORT_ISBN == 0;
    }

    private boolean isLongISBN(String isbn) {
        int total = 0 ;
        for(int i = 0; i < LONG_ISBN; i++){
            total  += i % 2 == 0 ?   Character.getNumericValue(isbn.charAt(i)) : Character.getNumericValue(isbn.charAt(i)) * 3;
        }

        return  total % MULTIPLIER_LONG_ISBN == 0;
    }




    public String stockLocator(String isbn, String surname, String bookTitle){
        StringBuilder sbf = new StringBuilder();

        String lastFourCharactersOfISBN = isbn.substring(isbn.length()-4);
        String firstCharacterOfSurname = surname.substring(0,1).toUpperCase();


        int numberOfWordsInTitle = Arrays
                .stream(bookTitle.trim().split(" "))
                .collect(Collectors.toList()).size();

        sbf.append(lastFourCharactersOfISBN);
        sbf.append(firstCharacterOfSurname);
        sbf.append(numberOfWordsInTitle);


        return sbf.toString();

    }

//    public int getSum(int )


}