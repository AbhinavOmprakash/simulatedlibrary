package admin.views;

import admin.models.RawLibItemData;
import common.Router;
import common.factory.FactoryGui;
import common.factory.RawData;
import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

//todo reorganize methods.
@SuppressWarnings({"rawtypes", "unchecked"})
public class NewLibraryItem implements DisplayPage, FactoryGui {
    private JPanel panel;
    private JTextField titleField;
    private JTextField subjectField;
    private JTextField UPCfield;
    private JTextField ISBNField;
    private JComboBox isBorrowable;
    private JComboBox libItemType;

    public JButton addItemButton;
    private JPanel mainPanel;
    private JComboBox contributorTypes;
    private JTextField contributorName;
    private JSpinner borrowPeriod;
    public JButton backButton;

    public NewLibraryItem() {
        populateItemTypes();
        populateContributors();
        populateBorrowable();
    }

    @Override
    public void registerListener(ActionListener listener) {
        addItemButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }

    @Override
    public void refresh() {

    }

    @Override
    public JButton getCreateButton() {
        return addItemButton;
    }

    private void populateItemTypes() {
        String[] allLibraryItemTypes = {"Book", "AudioBook",
                "Archive","DVD"};
        for(String type : allLibraryItemTypes){
            libItemType.addItem(type);
        }
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

    @Override
    public RawData getRawData() {
        return new RawLibItemData(titleField.getText(),
                subjectField.getText(),
                getContributors(),
                UPCfield.getText(),
                ISBNField.getText(),
                isBorrowable.getSelectedItem(),
                borrowPeriod.getValue(),
                libItemType.getSelectedItem());
    }

    private Map<String, String> getContributors() {
        return new HashMap<>(Map.of((String) contributorTypes.getSelectedItem(), contributorName.getText()));
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
