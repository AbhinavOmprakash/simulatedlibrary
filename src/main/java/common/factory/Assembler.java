package common.factory;
/*
Some objects might be composed of one or more objects.
in that case an assembler should be used.
 */

import org.springframework.security.core.parameters.P;

public abstract class Assembler<T> implements Factory<T> {
    private final FactoryController<T> mainFactory;
    protected Parts<T> parts;

    public Assembler(FactoryController<T> mainFactory, Parts<T> parts) {
        this.mainFactory = mainFactory;
        this.parts = parts;
    }

    @Override
    public T create(CleanData cleanData){
        createParts(cleanData);
        createMainObject(cleanData);
        T product = assemble(parts);
        saveAssembledProduct(product);
        return product;
    }

    protected abstract void createParts(CleanData data);

    private void createMainObject(CleanData data) {
        T mainProduct = mainFactory.create(data);
        parts.addMainPart(mainProduct);
    }
    
    protected abstract T assemble(Parts<T> parts);

    private void saveAssembledProduct(T product){
        mainFactory.update(product);
    }
}
