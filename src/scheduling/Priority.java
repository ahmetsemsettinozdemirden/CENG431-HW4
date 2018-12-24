package scheduling;

import process.Process;

import java.util.List;

public class Priority implements SchedulingAlgorithm {

    @Override
    public void schedule(List<Process> processes) {
        processes.sort((process1, process2) -> {
            if (process1.getPriority() == process2.getPriority())
                return 0;
            else
                return (process1.getPriority() < process2.getPriority() ? -1 : 1);
        });
    }

}
