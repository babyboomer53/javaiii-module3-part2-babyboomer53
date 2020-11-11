package NumericConversions;

public class FunWithRegex {

    public static String formatNumber(String number, int radix) {
        String regex;
        String replacement;
        if (radix == 2) {               // If the base or radix is 2 (i.e.,  a binary number)…
            regex = "([01]{4})";        // Group the digits by 4,
            replacement = "$1 ";        // and separate them by a space.
        } else if (radix == 16) {       // If the basal radix is 16 (i.e., a hexadecimal number)…
            regex = "([0-9a-fA-F]{2})"; // Group the digits by 2,
            replacement = "$1 ";        // and separate them by a space.
        } else if (radix == 10) {       // If the base or radix is 10 (i.e.,  a decimal number)…
            return String.format("%,.0f", Double.parseDouble(number));  // Insert commas.
        } else {
            return number;              // All other radixes will be ignored.
        }
        // The following is an attempt to get the parser to evaluate the string from right to left
        // instead of left to right.
        String string = new StringBuilder(number).reverse().toString();
        // The following returns a String in which the characters matching the search pattern have
        // been replaced, the characters have been returned to their original sequence and leading
        // and trailing white space has been removed.
        return new StringBuilder(string.replaceAll(regex, replacement)).reverse().toString().trim();
    }

    public static void main(String[] args) {
        String binary = "111101011";
        String hexadecimal = "A4010E030DEF";
        String decimal = "987654321012";

        System.out.printf("%-12s: %20s%n", binary, formatNumber(binary, 2));
        System.out.printf("%-12s: %20s%n", hexadecimal, formatNumber(hexadecimal, 16));
        System.out.printf("%-12s: %20s%n", decimal, formatNumber(decimal, 10));
    }
}
