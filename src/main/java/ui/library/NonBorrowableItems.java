package ui.library;

import javax.swing.*;
import java.awt.event.*;

public class NonBorrowableItems extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public JLabel getDetails() {
        return details;
    }

    public void setDetails(String text) {
        details.setText(text);
    }

    private JLabel details;

    public NonBorrowableItems() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        NonBorrowableItems dialog = new NonBorrowableItems();
        dialog.setDetails("some items are not allowed to be borrowed. \n " +
                "this is either because the item is extremely valuable,\n" +
                " contains sensitive information" +
                "or it requires a climate controlled environment ");

        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
