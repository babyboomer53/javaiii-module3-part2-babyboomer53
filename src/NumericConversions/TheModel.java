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
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        switch (base) {
            case 2:
                result = number.replaceAll("[01]?([^01]?)", "$1");
                result.chars().distinct().forEach(c -> stringBuilder.append((char) c));
                result = stringBuilder.toString();
                count = result.length();
                result = result.replaceAll("([^, ]?)", "$1, ");
                result = result.replaceAll("^[, ]+|[, ]+$", "");
                result = result.replaceAll("([^, ])", "'$1'");
                result = result.replaceAll(",[ ](.{3})$", " nor $1");
                if (count <= 1) {
                    result = result + " is not a valid binary digit!";
                } else {
                    result = "Neither " + result + " is a valid binary digit!";
                }
                break;
            case 8:
                result = number.replaceAll("[0-7]?([^0-7]?)", "$1");
                result.chars().distinct().forEach(c -> stringBuilder.append((char) c));
                result = stringBuilder.toString();
                count = result.length();
                result = result.replaceAll("([^, ]?)", "$1, ");
                result = result.replaceAll("^[, ]+|[, ]+$", "");
                result = result.replaceAll("([^, ])", "'$1'");
                result = result.replaceAll(",[ ](.{3})$", " nor $1");
                if (count <= 1) {
                    result = result + " is not a valid octal digit!";
                } else {
                    result = "Neither " + result + " is a valid octal digit!";
                }
                break;
            case 10:
                result = number.replaceAll("[0-9]?([^0-9]?)", "$1");
                result.chars().distinct().forEach(c -> stringBuilder.append((char) c));
                result = stringBuilder.toString();
                count = result.length();
                result = result.replaceAll("([^, ]?)", "$1, ");
                result = result.replaceAll("^[, ]+|[, ]+$", "");
                result = result.replaceAll("([^, ])", "'$1'");
                result = result.replaceAll(",[ ](.{3})$", " nor $1");
                if (count <= 1) {
                    result = result + " is not a valid decimal digit!";
                } else {
                    result = "Neither " + result + " is a valid decimal digit!";
                }
                break;
            case 16:
                result = number.replaceAll("[0-9a-fA-F]?([^0-9a-fA-F]?)", "$1");
                result.chars().distinct().forEach(c -> stringBuilder.append((char) c));
                result = stringBuilder.toString();
                count = result.length();
                result = result.replaceAll("([^, ]?)", "$1, ");
                result = result.replaceAll("^[, ]+|[, ]+$", "");
                result = result.replaceAll("([^, ])", "'$1'");
                result = result.replaceAll(",[ ](.{3})$", " nor $1");
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
