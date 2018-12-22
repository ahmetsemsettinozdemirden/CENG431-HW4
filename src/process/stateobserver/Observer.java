package process.stateobserver;

import process.Observable;

public interface Observer {

    void update(Observable observable);

}
