package NumericConversions;

public class TheController {

    private TheModel theModel;
    private TheView theView;

    public TheController(TheModel theModel, TheView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

    public static void main(String[] args) {
        TheController theController = new TheController(new TheModel(),new TheView());
        theController.theView.setVisible(true);
    }
}