import process.Process;
import scheduling.SchedulingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class ProcessBatch {

    private List<Process> processes;
    private SchedulingAlgorithm schedulingAlgorithm;

    public ProcessBatch(SchedulingAlgorithm schedulingAlgorithm) {
        this.processes = new ArrayList<>();
        this.schedulingAlgorithm = schedulingAlgorithm;
    }

    public void schedule() {
        schedulingAlgorithm.schedule(processes);
    }

    public void determineWaitingTime() {
        // set first process' waiting time to 0
        if (!processes.isEmpty())
            processes.get(0).setWaitingTime(0);
        // next waiting time = previous' burst time + previous's waiting time
        for (int i = 1; i < processes.size(); i++)
            processes.get(i).setWaitingTime(processes.get(i-1).getBurstTime() + processes.get(i-1).getWaitingTime());
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void addProcess(Process process) {
        processes.add(process);
    }

}
