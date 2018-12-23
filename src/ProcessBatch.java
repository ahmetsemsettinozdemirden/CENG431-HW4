import process.Process;
import scheduling.SchedulingAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessBatch {

    private List<Process> processes;
    private SchedulingAlgorithm schedulingAlgorithm;
    private Random random;

    public ProcessBatch(SchedulingAlgorithm schedulingAlgorithm) {
        this.processes = new ArrayList<>();
        this.schedulingAlgorithm = schedulingAlgorithm;
        this.random = new Random();
    }

    private void schedule() {
        this.processes = schedulingAlgorithm.schedule(processes);
    }

    public void createProcesses(Integer numberOfProcesses) {

        for (int i = 0; i < numberOfProcesses; i++) {
            Process process = new Process(i, random.nextInt(20) + 1, random.nextInt(20) + 1, null, null, random.nextInt(10) + 1, null);
            processes.add(process);
            process.notifyObservers();
        }

    }

}
