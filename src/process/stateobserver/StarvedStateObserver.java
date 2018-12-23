package process.stateobserver;

import process.Observable;
import process.ProcessState;

public class StarvedStateObserver implements Observer {

    @Override
    public void update(Observable observable) {
        observable.setState(ProcessState.STARVED); // if waiting time is more than 50
    }
}
