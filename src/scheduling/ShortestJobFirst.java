package scheduling;

import process.Process;

import java.util.List;

public class ShortestJobFirst implements SchedulingAlgorithm {

    @Override
    public void schedule(List<Process> processes) {
        processes.sort((process1, process2) -> {
            if (process1.getBurstTime() == process2.getBurstTime())
                return 0;
            else
                return (process1.getBurstTime() < process2.getBurstTime() ? -1 : 1);
        });
    }

}
