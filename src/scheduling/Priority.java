package scheduling;

import process.Process;

import java.util.Collections;
import java.util.List;

public class Priority implements SchedulingAlgorithm {

    @Override
    public List<Process> schedule(List<Process> processes) {

        Collections.sort(processes, (process1, process2) -> {
            if (process1.getPriority() == process2.getPriority())
                return 0;
            else
                return (process1.getPriority() < process2.getPriority() ? -1 : 1);
        });

        return processes;
    }

}
