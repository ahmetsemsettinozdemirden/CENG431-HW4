package process;

import process.stateobserver.*;

import java.util.Random;

public class ProcessFactory {

    private static int id = 0;

    private Random random;

    public ProcessFactory() {
        this.random = new Random();
    }

    public Process createProcess() {
        Process process = new Process(
                ++id,
                random.nextInt(20) + 1,
                random.nextInt(20) + 1,
                0,
                0,
                random.nextInt(10) + 1,
                null);
        System.out.println("Create " + process.toString());
        addObservers(process);
        process.notifyObservers();
        return process;
    }

    private void addObservers(Process process) {
        process.addObserver(BlockedStateObserver.instance());
        process.addObserver(NewStateObserver.instance());
        process.addObserver(ReadyStateObserver.instance());
        process.addObserver(RunningStateObserver.instance());
        process.addObserver(StarvedStateObserver.instance());
        process.addObserver(TerminatedStateObserver.instance());
    }

}
