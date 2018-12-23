package scheduling;

import process.Process;

import java.util.List;

public interface SchedulingAlgorithm {

    List<Process> schedule(List<Process> processes);

}
