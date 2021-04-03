package common.factory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryGuiController<T> implements ActionListener {
    protected FactoryGui page;
    protected Factory<T> factory;

    public FactoryGuiController(FactoryGui page, Factory<T> factory) {
        this.page = page;
        this.factory = factory;
        this.page.registerListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if overriding, call createNewItem()
        if(e.getSource()==page.getCreateButton()){
            createNewItem();
        }
    }

    protected void createNewItem() {
        RawData rawData = page.getRawData();
        factory.create(rawData.getCompatibleData());
    }
}
