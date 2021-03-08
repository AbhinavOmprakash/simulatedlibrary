package library;

public abstract class Accountant {
    protected DataManager<String, User> dataManager;

    public Accountant(DataManager<String, User> dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager<String, User> getDataManager() {
        return dataManager;
    }

    public void setDataManager(DataManager<String, User> dataManager) {
        this.dataManager = dataManager;
    }

}
