package ui.library.home.displayresults;

import ui.library.displayPage;

import javax.swing.*;

public class LIbraryItemDetailedView implements displayPage {

    public JPanel panel1;

    public JPanel getPanel1() {
        return panel1;
    }

    @Override
    public JPanel getPanel() {
        return getPanel1();

    }
}