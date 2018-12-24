import process.Process;
import process.ProcessState;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private List<Process> readyQueue;
    private CPU cpu;

    public Dispatcher(CPU cpu) {
        this.cpu = cpu;
    }

    public boolean isQueueEmpty() {
        return readyQueue.isEmpty();
    }

    public void dispatch() {
        if (readyQueue.isEmpty())
            throw new RuntimeException("No such process in the ready queue.");
        Process process = readyQueue.remove(0);
        process.setState(ProcessState.RUNNING);
        cpu.execute(process);
    }

    public void setReadyQueue(List<Process> processes) {
        readyQueue = new ArrayList<>();
        for (Process process: processes)
            if (process.getProcessState().equals(ProcessState.READY))
                readyQueue.add(process);
    }

}
