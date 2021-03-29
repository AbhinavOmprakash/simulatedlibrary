package common.models;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface DisplayPage {
    void registerListener(ActionListener listener);
    JPanel getPanel();
    String getIdentifier();
}
