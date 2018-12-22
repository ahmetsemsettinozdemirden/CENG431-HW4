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

    private void schedule() {
        this.processes = schedulingAlgorithm.schedule(processes);
    }

}
