package NumericConversions;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunWithRegexTest {

    @Test
    public void binaryNumber() {
        assertTrue(NumericConversions.FunWithRegex.formatNumber("111101011", 2).equals("0001 1110 1011"));
    }

    @Test
    public void hexadecimalNumber() {
        assertTrue(NumericConversions.FunWithRegex.formatNumber("A4010E030DE", 16).equals("0A 40 10 E0 30 DE"));
    }

    @Test
    public void octalNumber() {
        assertTrue(NumericConversions.FunWithRegex.formatNumber("7654321012", 8).equals("007 654 321 012"));
    }

    @Test
    public void decimalNumber() {
        assertTrue(NumericConversions.FunWithRegex.formatNumber("987654321012", 10).equals("987,654,321,012"));
    }
}