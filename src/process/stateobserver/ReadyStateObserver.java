package process.stateobserver;

import process.Observable;
import process.ProcessState;

public class ReadyStateObserver implements Observer {

    @Override
    public void update(Observable observable) {
        observable.setState(ProcessState.READY);
    }

}
