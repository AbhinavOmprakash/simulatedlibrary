import com.formdev.flatlaf.FlatDarkLaf;
import common.controllers.MainFrameController;
import common.views.MainJFrame;

import javax.swing.*;

@SuppressWarnings({"rawtypes"})
public class LibrarySimulator {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        //todo move exception handling into mainJframe
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        MainJFrame frame = new MainJFrame("HomeScreen");
        MainFrameController controller = new MainFrameController(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000,500);
        frame.setVisible(true);
    }
}
