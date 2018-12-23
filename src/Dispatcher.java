import process.Process;
import process.ProcessState;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private List<Process> readyQueue;

    public Dispatcher() {
        this.readyQueue = new ArrayList<>();
    }

    public void sendExecution(CPU cpu) {
        Process process = readyQueue.remove(0);
        cpu.execute(process);
        process.setState(ProcessState.RUNNING);
    }

}
