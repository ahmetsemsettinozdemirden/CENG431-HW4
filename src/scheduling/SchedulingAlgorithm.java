package scheduling;

import java.util.List;

public interface SchedulingAlgorithm {

    List<Process> schedule(List<Process> processes);

}
