package library.views;

import common.models.Session;
import library.models.LibraryUtils;
import library.models.MemberUtils;
import library.models.Utils;
import library.models.libraryitems.LibraryItem;
import common.models.DataObserver;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryItemDisplay implements DisplayPage{
    private JPanel displayPanel;
    private JPanel items;
    ArrayList<LibraryItemPanel> panels = new ArrayList<>(); // required for disabling and enabling buttons
    Utils utils;
    HomeScreen parent;

    public LibraryItemDisplay(HomeScreen parent, ArrayList<Object> libraryItems, Utils utils) {
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.PAGE_AXIS));
        displayPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        this.parent = parent;
        this.utils = utils;

        populateChildren(libraryItems);
    }

    private void populateChildren(ArrayList<Object> libraryItems){
        for (Object libItem : libraryItems) {
            LibraryItemPanel item = new LibraryItemPanel(this, (LibraryItem) libItem, utils);
            displayPanel.add(item.getPanel());
            panels.add(item);
        }
    }

    @Override
    public void refresh() {
        for(LibraryItemPanel panel: panels){
            panel.refresh();
        }
    }

    public void borrow(LibraryItem item){
        parent.borrow(item);
    }

    @Override
    public JPanel getPanel() {
        return displayPanel;
    }

    @Override
    public String getIdentifier() {
        return "LibraryItemDisplay";
    }

    @Override
    public void registerListener(ActionListener listener) {}

}