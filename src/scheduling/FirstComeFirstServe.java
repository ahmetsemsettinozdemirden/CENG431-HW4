package scheduling;

import process.Process;
import java.util.Collections;
import java.util.List;

public class FirstComeFirstServe implements SchedulingAlgorithm {

    @Override
    public List<Process> schedule(List<Process> processes) {

        Collections.sort(processes, (process1, process2) -> {
            if (process1.getArrivalTime() == process2.getArrivalTime())
                return 0;
            else
                return (process1.getArrivalTime() < process2.getArrivalTime() ? -1 : 1);
        });

        return processes;
    }
}
