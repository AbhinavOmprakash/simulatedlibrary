package views.home.displayresults;

import views.displayPage;

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

    @Override
    public String getIdentifier() {
        return "LibraryItemDetailedView";
    }
}
