package process.stateobserver;

import process.Observable;

public class RunningStateObserver implements Observer {

    private static RunningStateObserver instance;

    private RunningStateObserver() {}

    @Override
    public void update(Observable observable) {

    }

    public static RunningStateObserver instance() {
        if (instance == null)
            instance = new RunningStateObserver();
        return instance;
    }

}
