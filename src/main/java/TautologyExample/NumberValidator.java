package TautologyExample;

public class NumberValidator {

    public boolean isItPrime(int number){
        int maxDivisor = (int) Math.sqrt(number);
        for(int i=2; i < maxDivisor; i++)
        {
            if(number % i == 0 ) return false;

        } return true;
    }

    public boolean divisibleBy2(int number){
        return number % 2 == 0;
    }
}
