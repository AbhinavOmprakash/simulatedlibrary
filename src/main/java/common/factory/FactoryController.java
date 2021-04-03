package common.factory;
/*
responsible for saving objects created by the factory.
 */
import common.models.DataManager;

import java.util.List;

public class FactoryController<T> implements Factory<T> {
    protected DataManager dataManager;
    protected Factory<T> factory;

    public FactoryController(DataManager dataManager, Factory<T> factory) {
        this.dataManager = dataManager;
        this.factory = factory;
    }

    public T create(CleanData cleanData){
        T product = factory.create(cleanData);
        dataManager.addItem(product);
        System.out.println("created new product"+product.getClass());
        return product;
    }

    public List<T> createMany(List<CleanData> cleanData) {
        // to be overriden by subclasses if they require.
        return null;
    }

    public void update(T product){
        dataManager.updateData(product);
    }
}
