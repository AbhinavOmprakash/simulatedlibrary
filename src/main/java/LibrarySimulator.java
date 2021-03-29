import com.formdev.flatlaf.FlatDarkLaf;
import common.MainRouter;
import common.views.MainJFrame;

import javax.swing.*;

@SuppressWarnings({"rawtypes"})
public class LibrarySimulator {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (Exception ex) {
                    System.err.println("Failed to initialize LaF");
                }
                MainJFrame mainframe = new MainJFrame();
                mainframe.setVisible(true);

                MainRouter mainRouter = new MainRouter(mainframe);
                mainRouter.homeView();
            }});
        }
    }
