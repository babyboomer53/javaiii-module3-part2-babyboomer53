package NumericConversions;

public class FunWithRegex {

    public static String formatNumber(String number, int radix) {
        String regex;
        String replacement;
        int grouping;
        String padding;
        if (!number.matches("^[0-9a-fA-F]*$")) {
            return number;
        }
        if (radix == 2) {               // If the base or radix is 2 (i.e., a binary number)…
            regex = "([01]{4})";        // Group the digits by 4,
            replacement = "$1 ";        // and separate them by a space.
            grouping = 4;
        } else if (radix == 8) {        // If the base or radix is 8 (i.e., an octal number)…
            regex = "([0-7]{3})";       // Group the digits by 3,
            replacement = "$1 ";        // and separate them by a space.
            grouping = 3;
        } else if (radix == 16) {       // If the base or radix is 16 (i.e., a hexadecimal number)…
            regex = "([0-9a-fA-F]{2})"; // Group the digits by 2,
            replacement = "$1 ";        // and separate them by a space.
            grouping = 2;
        } else if (radix == 10) {       // If the base or radix is 10 (i.e., a decimal number)…
            return String.format("%,.0f", Double.parseDouble(number));  // Insert commas.
        } else {
            return number;              // All other radixes will be ignored.
        }

        // Pad the number with leading zeros.
        int count = number.length() % grouping == 0 ? 0 : grouping - (number.length() % grouping);
        padding = "0".repeat(count);

        // The following returns a String in which the characters matching the search pattern have
        // been replaced, and trailing white space has been removed.
        return (padding + number).replaceAll(regex, replacement).trim();
    }

}
