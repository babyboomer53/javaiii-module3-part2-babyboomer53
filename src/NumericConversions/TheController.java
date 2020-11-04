package NumericConversions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheController {

    private TheModel theModel;
    private TheView theView;

    public TheController(TheModel theModel, TheView theView) {
        this.theModel = theModel;
        this.theView = theView;
        // this.theView.addMyActionListener(new MyActionListener());
    }

    public static void main(String[] args) {
        TheController theController = new TheController(new TheModel(),new TheView());
        theController.theView.setVisible(true);
    }
}