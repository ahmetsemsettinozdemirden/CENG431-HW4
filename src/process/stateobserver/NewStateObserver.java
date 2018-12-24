package process.stateobserver;

import process.Observable;
import process.Process;
import process.ProcessState;

public class NewStateObserver implements Observer {

    private static NewStateObserver instance;

    private NewStateObserver() {}

    @Override
    public void update(Observable observable) {

        Process process = (Process) observable;

        if (process.getProcessState() == null) {
            process.setState(ProcessState.NEW);
        }
    }

    public static NewStateObserver instance() {
        if (instance == null)
            instance = new NewStateObserver();
        return instance;
    }

}
