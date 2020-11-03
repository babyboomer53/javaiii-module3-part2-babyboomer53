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

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }

    public static void main(String[] args) {
        TheView theView=new TheView();
        theView.setVisible(true);
    }
}
