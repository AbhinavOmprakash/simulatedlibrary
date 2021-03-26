package admin.views;

import admin.models.NewLibraryItemData;
import common.displayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

@SuppressWarnings({"rawtypes", "unchecked"})
public class NewLibraryItem implements displayPage {
    private JPanel panel;
    private JTextField titleField;
    private JTextField subjectField;
    private JTextField UPCfield;
    private JComboBox contributorType;
    private JTextField ISBNField;
    private JComboBox isBorrowable;
    private JComboBox libItemType;

    public JButton addItemButton;
    private JPanel mainPanel;
    private JComboBox contributorTypes;
    private JTextField textField1;
    private JSpinner spinner1;
    private JPanel contributors;


    public NewLibraryItem(ActionListener guiController) {
        addItemButton.addActionListener(guiController);
        populateItemTypes();
        populateContributors();
        populateBorrowable();
    }

    private void populateContributors() {
        // todo improve design. hardcoding values
        String[] allContributorTypes = {"Author", "Actor", "Director",
                "Singer", "ScreenWriter", "Poet"};
        for (String c : allContributorTypes) {
            contributorTypes.addItem(c);
        }
    }
    private void populateBorrowable() {
        isBorrowable.addItem("yes");
        isBorrowable.addItem("no");
    }

    private void populateItemTypes() {
        String[] allLibraryItemTypes = {"Book", "AudioBook",
                                        "Archive","DVD"};
        for(String l:allLibraryItemTypes){
            libItemType.addItem(l);
        }
    }

    public NewLibraryItemData fetchData(){
        return null;
    }


    @Override
    public JPanel getPanel() {
        return mainPanel;
    }

    @Override
    public String getIdentifier() {
        return "NewLibraryItemPanel";
    }

}
