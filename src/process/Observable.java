package process;

import process.stateobserver.Observer;

public interface Observable {

    boolean addObserver(Observer observer);
    boolean removeObserver(Observer observer);
    void notifyObservers();

}
