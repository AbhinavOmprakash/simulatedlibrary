package common.factory;
/*
only responsible for creating an object. Not responsible for saving it.
FactoryController does that.
 */

import java.util.List;

public interface Factory<T> {
    T create(CleanData cleanData);
}
