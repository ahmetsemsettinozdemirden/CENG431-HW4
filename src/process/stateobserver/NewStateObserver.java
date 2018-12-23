package process.stateobserver;

import process.Observable;
import process.ProcessState;

public class NewStateObserver implements Observer {

    @Override
    public void update(Observable observable) {
        observable.setState(ProcessState.NEW);
    }

}
