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

    public void determineWaitingTime() {

        for (int i = 0; i < processes.size(); i++) {
            if (processes.get(0).equals(processes.get(i))) {
                processes.get(i).setWaitingTime(0); // since it is the first one
            } else {
                processes.get(i).setWaitingTime(processes.get(i-1).getBurstTime() + processes.get(i-1).getWaitingTime());
                // previous process' waiting time + burst time is the current process' waiting time
            }
        }
    }
}
