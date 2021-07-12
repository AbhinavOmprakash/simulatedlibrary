package common;

import com.formdev.flatlaf.FlatDarkLaf;
import common.models.DataStoreInterface;
import common.models.HibernateDB;
import common.models.PaymentGateway;
import common.views.MainJFrame;
import payment.models.DummyPayment;

import javax.swing.*;

public class LibrarySimulator {
    public static void main(String[] args){
        Dependency dependency = new Dependency();
        DataStoreInterface dataBase = new HibernateDB(true);
        PaymentGateway paymentGateway = new DummyPayment();

        dependency.dataBase = dataBase;
        dependency.paymentGateway = paymentGateway;

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (Exception ex) {
                    System.err.println("Failed to initialize LaF");
                }
                MainJFrame mainframe = new MainJFrame();
                dependency.mainJFrame = mainframe;
                dependency.router = new MainRouter(mainframe);

                App.setFrame(mainframe);

                App mainApp = new MainApp(dependency.router);
                mainApp.start(dependency);
                mainframe.setVisible(true);
                dependency.router.homeView();
            }});

        }
    }
