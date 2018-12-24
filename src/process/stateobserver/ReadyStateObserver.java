package process.stateobserver;

import process.Observable;
import process.ProcessState;

public class ReadyStateObserver implements Observer {

    @Override
    public void update(Observable observable) {

        if (observable.getWaitingTime() != null && observable.getWaitingTime() <= 50) {
            observable.setState(ProcessState.READY);
        }
    }

}
