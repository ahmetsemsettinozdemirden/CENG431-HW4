import process.Process;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private List<Process> readyQueue;

    public Dispatcher() {
        this.readyQueue = new ArrayList<>();
    }

}
