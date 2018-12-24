package process.stateobserver;

import process.Observable;

public class BlockedStateObserver implements Observer {

    private static BlockedStateObserver instance;

    private BlockedStateObserver() {}

    @Override
    public void update(Observable observable) {

    }

    public static BlockedStateObserver instance() {
        if (instance == null)
            instance = new BlockedStateObserver();
        return instance;
    }

}
