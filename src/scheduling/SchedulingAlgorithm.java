package scheduling;

import process.Process;

import java.util.List;

public interface SchedulingAlgorithm {

    void schedule(List<Process> processes);

}
