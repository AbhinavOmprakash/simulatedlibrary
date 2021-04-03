package common.factory;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface FactoryGui{
    void registerListener(ActionListener listener);
    JButton getCreateButton();
    RawData getRawData();
}
