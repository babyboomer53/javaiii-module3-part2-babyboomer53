package NumericConversions;

public class FunWithRegex {
    public static void main(String[] args) {
        String binary;
        String hexadecimal;
        String octal;
        // The variables defined in the following three lines will contain the patterns that will be used
        // to search the strings.
        String formatH = "([0-9a-f]{2})";
        String formatB = "([01]{4})";
        String formatO = "([0-7]{3})";
        // The variables defined in the following three lines will contain the strings that will be compared
        // to the patterns.
        hexadecimal = "dedaffcef"; // dedaffcef
        binary = "1111011"; // 1111011
        octal = "1234567"; // 1234567
        // The following three statements will print the strings contained in the corresponding variables
        // after grouping the characters in the string in accordance with the regex pattern applied.
        System.out.println(new StringBuffer(hexadecimal.replaceAll(formatH, "$1 ").trim()));
        System.out.println(new StringBuffer(binary.replaceAll(formatB, "$1 ").trim()));
        System.out.println(new StringBuffer(octal.replaceAll(formatO, "$1 ").trim()));
        System.out.println();
        // The following three lines will reverse the order of the characters in the strings. This is to
        // ensure that the grouping of characters occurs from right to left.
        binary = new StringBuffer(binary).reverse().toString();
        hexadecimal = new StringBuffer(hexadecimal).reverse().toString();
        octal = new StringBuffer(octal).reverse().toString();
        System.out.println("The following will make it clear why the order of the characters in the strings had to " +
                "be reversed prior to grouping them.\n");
        System.out.println(new StringBuffer(hexadecimal.replaceAll(formatH, "$1 ").trim()).reverse());
        System.out.println(new StringBuffer(binary.replaceAll(formatB, "$1 ").trim()).reverse());
        System.out.println(new StringBuffer(octal.replaceAll(formatO, "$1 ").trim()).reverse());
    }
}
