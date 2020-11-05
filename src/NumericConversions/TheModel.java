
package NumericConversions;

class BaseConversions {

    static String baseToBase(String num, int base1, int base2) {
        if (num.isEmpty() || num.isBlank()) return "Invalid input!";
        int no = convFrmBaseToDeci(num, base1);
        String returnValue = convFrmDecToBase(no, base2);
        return returnValue;
    }

    static String convFrmDecToBase(int dividend, int base) {

        String result = "";
        int remainder;
        // Convert input number is given base by repeatedly
        // dividing it by base and taking remainder
        while (dividend > 0) {
            remainder = dividend % base;
            if (base == 16) {
                if (remainder == 10)
                    result += 'A';
                else if (remainder == 11)
                    result += 'B';
                else if (remainder == 12)
                    result += 'C';
                else if (remainder == 13)
                    result += 'D';
                else if (remainder == 14)
                    result += 'E';
                else if (remainder == 15)
                    result += 'F';
                else
                    result += remainder;
            } else
                result += remainder;

            dividend /= base;
        }
        // Reverse the result
        if (result.isEmpty() && dividend == 0) {
            return "0";
        } else if (dividend != 0) {
            if (result.isEmpty()) {
                return "Invalid input!";
            } else {
                return new StringBuffer(result).reverse().toString();
            }
        } else {
            return new StringBuffer(result).reverse().toString();
        }
    }

    static int convFrmBaseToDeci(String num, int base) {

        if (base < 2 || (base > 10 && base != 16))
            return -1;

        int val = 0;
        int power = 1;

        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = digitToVal(num.charAt(i));

            if (digit < 0 || digit >= base)
                return -1;

            // Decimal equivalent is str[len-1]*1 +
            // str[len-1]*base + str[len-1]*(base^2) + ...
            val += digit * power;
            power = power * base;
        }

        return val;
    }

    static int digitToVal(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
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

    public base identifyBase() {
        String thePrefix = this.theNumber.substring(0, 2);
        switch (thePrefix) {
            case "0b":
            case "0B":
                this.setTheNumber(theNumber.substring(2));
                return base.BINARY;
            case "0o":
            case "0O":
                this.setTheNumber(theNumber.substring(2));
                return base.OCTAL;
            case "0x":
            case "0X":
                this.setTheNumber(theNumber.substring(2));
                return base.HEXADECIMAL;
            default:
                return base.DECIMAL;
        }
    }

}
