package NumericConversions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheController {

    private TheModel theModel;
    private NewJFrame theView;

    public TheController(TheModel theModel, NewJFrame theView) {
        this.theModel = theModel;
        this.theView = theView;
        // this.theView.addMyActionListener(new MyActionListener());
    }

    public static void main(String[] args) {
        //TheController theController = new TheController(new TheModel(),new TheView());
        TheController theController = new TheController(new TheModel(),new NewJFrame());
        theController.theView.setVisible(true);
    }
}