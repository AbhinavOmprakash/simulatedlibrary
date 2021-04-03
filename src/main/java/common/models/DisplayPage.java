package common.models;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface DisplayPage {
    JPanel getPanel();
    String getIdentifier();
    void registerListener(ActionListener listener);
    void refresh();
}
