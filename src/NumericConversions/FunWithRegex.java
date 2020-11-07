package NumericConversions;

import java.math.BigInteger;

public class FunWithRegex {
    public static void main(String[] args) {
        String formatH = "([0-9a-z]{2})";
        String formatB = "([01]{4})";
        String formatO ="(.{0,3})";
        String formatD ="(.{0,3})";
        String hexadecimal = "bfecffaded";
        String binary = "01101111";
        String octal = "01234567";
        BigInteger bigInteger = new BigInteger("1");

        System.out.println(new StringBuffer(hexadecimal.replaceAll(formatH, "$1 ").trim()).reverse());
        System.out.println(new StringBuffer(binary.replaceAll(formatB, "$1 ").trim()).reverse());
        System.out.println(new StringBuffer(octal.replaceAll(formatO, "$1 ").trim()).reverse());
    }
}
