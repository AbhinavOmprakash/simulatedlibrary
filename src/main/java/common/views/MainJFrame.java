package common.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainJFrame extends JFrame {
    JPanel cards = new JPanel(new CardLayout());

    public MainJFrame() {
        super("Library");
        setContentPane(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(1000,500);
    }

    public void addCard(String identifier, JPanel panel){
        cards.add(identifier, panel);
    }

    public void showCard(String identifier){
        CardLayout layout = (CardLayout) cards.getLayout();
        layout.show(cards, identifier);
    }

}
