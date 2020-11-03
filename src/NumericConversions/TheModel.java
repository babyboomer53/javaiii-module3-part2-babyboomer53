package NumericConversions;

public class TheModel {

    private String theNumber;

    public enum base {BINARY, DECIMAL, HEXADECIMAL, OCTAL}

    public TheModel(String theNumber) {
        this.theNumber = theNumber;
    }

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

    public static void main(String[] args) {
        TheModel theModel = new TheModel("0x0ffe");
        String theNumber = theModel.getTheNumber();
        System.out.printf("The number %s is %s.%n", theNumber, theModel.identifyBase());
    }
}
