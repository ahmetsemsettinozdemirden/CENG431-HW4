package process.stateobserver;

import process.Observable;

public class TerminatedStateObserver implements Observer {

    private static TerminatedStateObserver instance;

    private TerminatedStateObserver() {}

    @Override
    public void update(Observable observable) {

    }

    public static TerminatedStateObserver instance() {
        if (instance == null)
            instance = new TerminatedStateObserver();
        return instance;
    }

}
