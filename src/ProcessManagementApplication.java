import process.Process;
import process.ProcessState;
import scheduling.FirstComeFirstServe;
import scheduling.Priority;
import scheduling.ShortestJobFirst;

import java.util.ArrayList;
import java.util.List;

public class ProcessManagementApplication {

    public static void main(String[] args) {

        List<Process> processes = new ArrayList<>();
        Process process1 = new Process(1, 2, 1, 2, 2, 3, ProcessState.READY);
        Process process2 = new Process(2, 1, 8, 1, 1, 2, ProcessState.READY);
        Process process3 = new Process(3, 4, 4, 4, 4, 1, ProcessState.READY);

        processes.add(process1);
        processes.add(process2);
        processes.add(process3);

        for (int i = 0; i < processes.size(); i++) {
            System.out.print(i + ". process' id is " + processes.get(i).getId() + "\n");
        }

        FirstComeFirstServe firstComeFirstServe = new FirstComeFirstServe();
        processes = firstComeFirstServe.schedule(processes);
        System.out.print("Arrival Time:\n");
        for (int i = 0; i < processes.size(); i++) {
            System.out.print(i + ". process' id is " + processes.get(i).getId() + "\n");
        }

        ShortestJobFirst shortestJobFirst = new ShortestJobFirst();
        processes = shortestJobFirst.schedule(processes);
        System.out.print("Burst Time:\n");
        for (int i = 0; i < processes.size(); i++) {
            System.out.print(i + ". process' id is " + processes.get(i).getId() + "\n");
        }

        Priority priority = new Priority();
        processes = priority.schedule(processes);
        System.out.print("Priority:\n");
        for (int i = 0; i < processes.size(); i++) {
            System.out.print(i + ". process' id is " + processes.get(i).getId() + "\n");
        }
    }

}
