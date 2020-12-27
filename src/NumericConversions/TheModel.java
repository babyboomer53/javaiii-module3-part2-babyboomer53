package NumericConversions;

import javax.swing.*;
import java.math.BigInteger;

class BaseConversions {

    static String baseToBase(String num, int base1, int base2) {

        try {
            return new BigInteger(num, base1).toString(base2);
        } catch (NumberFormatException numberFormatException) {
            System.err.println(numberFormatException.getMessage());
            JOptionPane.showMessageDialog(null, invalidDigits(num, base1), "Number Format Exception",
                    JOptionPane.WARNING_MESSAGE);
            return "Invalid input!";
        }

    }

    static String invalidDigits(String number, int base) {
        String result;
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        String radix;
        switch (base) {
            case 2:
                result = number.replaceAll("[01]?([^01]?)", "$1");
                radix = "binary";
                break;
            case 8:
                result = number.replaceAll("[0-7]?([^0-7]?)", "$1");
                radix = "octal";
                break;
            case 10:
                result = number.replaceAll("[0-9]?([^0-9]?)", "$1");
                radix = "decimal";
                break;
            case 16:
                result = number.replaceAll("[0-9a-fA-F]?([^0-9a-fA-F]?)", "$1");
                radix = "hexadecimal";
                break;
            default:
                return number;
        }
        result.chars().distinct().forEach(c -> stringBuilder.append((char) c));
        result = stringBuilder.toString();
        count = result.length();
        result = result.replaceAll("([^, ]?)", "$1, ");
        result = result.replaceAll("^[, ]+|[, ]+$", "");
        result = result.replaceAll("([^, ])", "'$1'");
        result = result.replaceAll(",[ ]*(.)", " nor $1").replaceAll("('\\.')", "a decimal point");
        if (count <= 1) {
            result = result + " is not a valid " + radix + " digit!";
        } else {
            result = "Neither " + result + " is a valid " + radix + " digit!";
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
