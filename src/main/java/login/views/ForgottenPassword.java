package login.views;

import common.models.displayPage;

import javax.swing.*;
import java.awt.event.*;

public class ForgottenPassword extends JDialog implements displayPage {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;
    private JPanel textPanel;


    public ForgottenPassword() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        String displayText = "you forgot your password? \n" +
                "how could you do this to me? \n" +
                "I trusted you, you know I am doing a lot of things right now.\n" +
                "and this is how you treat me? \n" +
                "I'm disappointed in you.\n"+
                "\nI AM JOKING \n" +
                "this feature is not withing the intended scope of this project so, I'm sorry\n"+
                "\nSincerely, \n"+
                "This program.";


        textArea1.setText(displayText);

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
//        parent.changeToLoginPage();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
//        parent.changeToLoginPage();
    }

    @Override
    public JPanel getPanel() {
        return contentPane;
    }

    @Override
    public String getIdentifier() {
        return "ForgottenPassword";
    }
}
