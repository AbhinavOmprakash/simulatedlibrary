package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainJFrame extends JFrame implements PropertyChangeListener, ActionListener {
    JPanel mainPage =  new MainPage(this);

    public MainJFrame(String title) {
        super(title);
        setContentPane(mainPage);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
        revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
