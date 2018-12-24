package process.stateobserver;

import process.Observable;
import process.Process;
import process.ProcessState;

public class StarvedStateObserver implements Observer {

    private static StarvedStateObserver instance;

    private StarvedStateObserver() {}

    @Override
    public void update(Observable observable) {

        Process process = (Process) observable;

        if (process.getWaitingTime() > 50) {
            process.setState(ProcessState.STARVED);
        }
    }

    public static StarvedStateObserver instance() {
        if (instance == null)
            instance = new StarvedStateObserver();
        return instance;
    }

}
