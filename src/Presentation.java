import process.Process;
import process.ProcessFactory;
import scheduling.FirstComeFirstServe;
import scheduling.Priority;
import scheduling.SchedulingAlgorithm;
import scheduling.ShortestJobFirst;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Presentation {

    private Scanner scanner;

    public Presentation() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        String algorithmMenu= "Enter the Algorithm:\n" +
                "1. Fist come first serve\n" +
                "2. According to priority\n" +
                "3. Shortest job first";
        int algorithm = takeIntegerInput(algorithmMenu, 1, 3);
        SchedulingAlgorithm schedulingAlgorithm;
        switch (algorithm) {
            case 1:
                schedulingAlgorithm = new FirstComeFirstServe();
                break;
            case 2:
                schedulingAlgorithm = new Priority();
                break;
            case 3:
                schedulingAlgorithm = new ShortestJobFirst();
                break;
            default:
                schedulingAlgorithm = new FirstComeFirstServe();
        }
        ProcessBatch processBatch = new ProcessBatch(schedulingAlgorithm);

        String processCountInput = "Enter the process number";
        int processCount = takeIntegerInput(processCountInput, 1, Integer.MAX_VALUE);

        System.out.println("\nCreating processes...\n");

        ProcessFactory processFactory = new ProcessFactory();
        Process createdProcess;
        for (int i = 0; i < processCount; i++) {
            createdProcess = processFactory.createProcess();
            System.out.println("Created " + createdProcess.toString());
            processBatch.addProcess(createdProcess);
        }

        System.out.println("\nScheduling processes ...\n");

        processBatch.schedule();
        processBatch.determineWaitingTime();

        System.out.println("Processes are scheduled and in order:\n");
        int i = 1;
        for (Process process: processBatch.getProcesses()) {
            System.out.println(i + "- " + process.toString());
            i++;
        }

        CPU cpu = new CPU();
        Dispatcher dispatcher = new Dispatcher(cpu);

        System.out.println("\nExecuting processes:\n");

        dispatcher.setReadyQueue(processBatch.getProcesses());
        while (!dispatcher.isQueueEmpty()) {
            dispatcher.dispatch();
        }

        System.out.println("\nProcesses are executed results:\n");

        for (Process process: processBatch.getProcesses())
            System.out.println("Executed " + process);
    }


    private Integer takeIntegerInput(String printText, Integer min, Integer max) {
        System.out.println(printText);
        Integer input = null;
        while (input == null) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < min || input > max)
                    throw new InvalidParameterException();
            } catch (Exception e) {
                input = null;
                System.out.println("Invalid input try again");
                System.out.println(printText);
            }
        }
        return input;
    }
}
