package common.models;
/*
objects that are stored into the database and queried, must implement this.
If using inheritance, only the superclass needs to implement this, since most queries
will likely be polymorphic queries.
 */

public interface Searchable {
    String getTableName();
    String getSearchableAttribute();

}
