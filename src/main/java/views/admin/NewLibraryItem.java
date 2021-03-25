package views.admin;

import views.displayPage;

import javax.swing.*;

public class NewLibraryItem implements displayPage {
    private JPanel panel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JTextField textField5;
    private JComboBox comboBox2;
    private JTextArea textArea1;
    private JComboBox comboBox3;

    @Override
    public JPanel getPanel() {
        return null;
    }

    @Override
    public String getIdentifier() {
        return "NewLibraryItemPanel";
    }
}
