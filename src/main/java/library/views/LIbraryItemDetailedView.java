package library.views;

import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LIbraryItemDetailedView implements DisplayPage {

    public JPanel panel1;

    public JPanel getPanel1() {
        return panel1;
    }

    @Override
    public JPanel getPanel() {
        return getPanel1();

    }

    @Override
    public String getIdentifier() {
        return "LibraryItemDetailedView";
    }

    @Override
    public void registerListener(ActionListener listener) {

    }
}
