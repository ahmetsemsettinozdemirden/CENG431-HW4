import process.Process;
import process.ProcessFactory;
import scheduling.Priority;
import scheduling.SchedulingAlgorithm;

public class ProcessManagementApplication {

    public static void main(String[] args) {

        SchedulingAlgorithm schedulingAlgorithm = new Priority();
        ProcessBatch processBatch = new ProcessBatch(schedulingAlgorithm);

        ProcessFactory processFactory = new ProcessFactory();
        for (int i = 0; i < 10; i++)
            processBatch.addProcess(processFactory.createProcess());

        processBatch.schedule();
        processBatch.determineWaitingTime();

        for (Process process: processBatch.getProcesses())
            System.out.println("before dispatcher" + process);

        CPU cpu = new CPU();
        Dispatcher dispatcher = new Dispatcher(cpu);

        dispatcher.setReadyQueue(processBatch.getProcesses());
        while (!dispatcher.isQueueEmpty()) {
            dispatcher.dispatch();
        }

    }

}
