package process.stateobserver;

import process.Observable;
import process.ProcessState;

public class StarvedStateObserver implements Observer {

    @Override
    public void update(Observable observable) {

        if (observable.getWaitingTime() > 50) {
            observable.setState(ProcessState.STARVED);
        }
    }
}
