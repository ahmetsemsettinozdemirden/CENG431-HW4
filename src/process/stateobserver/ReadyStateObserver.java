package process.stateobserver;

import process.Observable;
import process.Process;
import process.ProcessState;

public class ReadyStateObserver implements Observer {

    private static ReadyStateObserver instance;

    private ReadyStateObserver() {}

    @Override
    public void update(Observable observable) {

        Process process = (Process) observable;

        if (process.getWaitingTime() != null && process.getWaitingTime() <= 50) {
            process.setState(ProcessState.READY);
        }
    }

    public static ReadyStateObserver instance() {
        if (instance == null)
            instance = new ReadyStateObserver();
        return instance;
    }

}
