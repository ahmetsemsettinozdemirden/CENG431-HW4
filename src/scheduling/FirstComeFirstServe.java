package scheduling;

import process.Process;

import java.util.List;

public class FirstComeFirstServe implements SchedulingAlgorithm {

    @Override
    public void schedule(List<Process> processes) {
        processes.sort((process1, process2) -> {
            if (process1.getArrivalTime() == process2.getArrivalTime())
                return 0;
            else
                return (process1.getArrivalTime() < process2.getArrivalTime() ? -1 : 1);
        });
    }
}
