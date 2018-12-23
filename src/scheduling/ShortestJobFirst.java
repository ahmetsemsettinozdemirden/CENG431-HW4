package scheduling;

import process.Process;

import java.util.Collections;
import java.util.List;

public class ShortestJobFirst implements SchedulingAlgorithm {

    @Override
    public List<Process> schedule(List<Process> processes) {

        Collections.sort(processes, (process1, process2) -> {
            if (process1.getBurstTime() == process2.getBurstTime())
                return 0;
            else
                return (process1.getBurstTime() < process2.getBurstTime() ? -1 : 1);
        });

        return processes;
    }

}
