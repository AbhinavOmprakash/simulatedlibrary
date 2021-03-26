package common;

public interface DataObservable {
    void registerListener(DataObserver listener);
    void removeListener(DataObserver listener);
    void notifyObservers();
}
