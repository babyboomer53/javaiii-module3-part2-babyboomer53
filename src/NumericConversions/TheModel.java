package NumericConversions;

import javax.swing.*;
import java.math.BigInteger;

class BaseConversions {

    static String baseToBase(String num, int base1, int base2) {

        try {
            return new BigInteger(num, base1).toString(base2);
        } catch (NumberFormatException numberFormatException) {
            System.err.println(numberFormatException);
            JOptionPane.showMessageDialog(null, invalidDigits(num, base1), "Number Format Exception",
                    JOptionPane.WARNING_MESSAGE);
            return "Invalid input!";
        }

    }

    static String invalidDigits(String number, int base) {
        String result;
        int count = 0;
        switch (base) {
            case 2:
                // Capture invalid characters and separate them by commas...
                result = number.replaceAll("[01]?([^01]?)", "$1, ").replaceAll("[, ]+$", "");
                // Remove leading commas and spaces...
                result = result.replaceAll("(^[ ,]*)", "");
                // How many invalid characters are there?
                count = result.length();
                // Create the conjunction used in messages containing multiple invalid characters.
                result = result.replaceAll(",([ ].?)$", " nor $1");
                if (count <= 1) {
                    result = result + " is not a valid binary digit!";
                } else {
                    result = "Neither " + result + " is a valid binary digit!";
                }
                break;
            case 8:
                // Capture invalid characters and separate them by commas...
                result = number.replaceAll("[0-7]?([^0-7]?)", "$1, ").replaceAll("[, ]+$", "");
                // Remove leading commas and spaces...
                result = result.replaceAll("(^[ ,]*)", "");
                // How many invalid characters are there?
                count = result.length();
                // Create the conjunction used in messages containing multiple invalid characters.
                result = result.replaceAll(",([ ].?)$", " nor $1");
                if (count <= 1) {
                    result = result + " is not a valid octal digit!";
                } else {
                    result = "Neither " + result + " is a valid octal digit!";
                }
                break;
            case 10:
                // Capture invalid characters and separate them by commas...
                result = number.replaceAll("[0-9]?([^0-9]?)", "$1, ").replaceAll("[, ]+$", "");
                // Remove leading commas and spaces...
                result = result.replaceAll("(^[ ,]*)", "");
                // How many invalid characters are there?
                count = result.length();
                // Create the conjunction used in messages containing multiple invalid characters.
                result = result.replaceAll(",([ ].?)$", " nor $1");
                if (count <= 1) {
                    result = result + " is not a valid decimal digit!";
                } else {
                    result = "Neither " + result + " is a valid decimal digit!";
                }
                break;
            case 16:
                // Capture invalid characters and separate them by commas...
                result = number.replaceAll("[0-9a-fA-F]?([^0-9a-fA-F]?)", "$1, ").replaceAll("[, ]+$", "");
                // Remove leading commas and spaces...
                result = result.replaceAll("(^[ ,]*)", "");
                // How many invalid characters are there?
                count = result.length();
                // Create the conjunction used in messages containing multiple invalid characters.
                result = result.replaceAll(",([ ].?)$", " nor $1");
                if (count <= 1) {
                    result = result + " is not a valid hexadecimal digit!";
                } else {
                    result = "Neither " + result + " is a valid hexadecimal digit!";
                }
                break;
            default:
                result = number;
        }
        return result;
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
