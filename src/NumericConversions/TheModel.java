package NumericConversions;

import java.math.BigInteger;

import static NumericConversions.FunWithRegex.formatNumber;

class BaseConversions {

    static String baseToBase(String num, int base1, int base2) {

        try {
            return new BigInteger(num, base1).toString();
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException);
            return "Invalid input!";
        }

    }

}

public class TheModel {

    private String theNumber;

    public enum base {BINARY, DECIMAL, HEXADECIMAL, OCTAL}

    public String getTheNumber() {
        return theNumber;
    }

    public void setTheNumber(String theNumber) {
        this.theNumber = theNumber;
    }

}
