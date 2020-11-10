package NumericConversions;

public class FunWithRegex {
    public static void main(String[] args) {
        String binary;
        String hexadecimal;
        String octal;

        String regex4 = "([01]{4}|[0-7]{3}|[0-9A-Z]{2})";

        hexadecimal = "D0DAFEC1F";
        binary = "1111011";
        octal = "1234567";

        hexadecimal = new StringBuffer(hexadecimal).reverse().toString();
        binary = new StringBuffer(binary).reverse().toString();
        octal = new StringBuffer(octal).reverse().toString();

        System.out.println();
        System.out.printf("%13s%n", new StringBuffer(hexadecimal.replaceAll(regex4, "$1 ").trim()).reverse());
        System.out.printf("%13s%n", new StringBuffer(octal.replaceAll(regex4, "$1 ").trim()).reverse());
        System.out.printf("%13s%n", new StringBuffer(binary.replaceAll(regex4, "$1 ").trim()).reverse());
        System.out.println();
    }
}
