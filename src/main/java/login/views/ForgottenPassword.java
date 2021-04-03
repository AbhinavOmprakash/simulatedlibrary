package login.views;

import common.models.DisplayPage;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ForgottenPassword implements DisplayPage {
    private JPanel panel;
    private JTextPane textPane1;
    public JButton backButton;

    public ForgottenPassword() {
        String text = "you forgot your password? \n" +
                "how could you do this to me? \n" +
                "I trusted you, you know I am doing a lot of things right now.\n" +
                "and this is how you treat me? \n" +
                "I'm disappointed in you.\n"+
                "\nI AM JOKING \n" +
                "this feature is not withing the intended scope of this project so, I'm sorry\n"+
                "\nSincerely, \n"+
                "This program.";

        textPane1.setText(text);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public String getIdentifier() {
        return "forgotten password";
    }

    @Override
    public void registerListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    @Override
    public void refresh() {

    }
}
