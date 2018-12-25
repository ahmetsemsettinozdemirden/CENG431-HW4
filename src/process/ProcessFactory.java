package process;

import process.stateobserver.BlockedStateObserver;
import process.stateobserver.NewStateObserver;
import process.stateobserver.ReadyStateObserver;
import process.stateobserver.RunningStateObserver;
import process.stateobserver.StarvedStateObserver;
import process.stateobserver.TerminatedStateObserver;

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
                null,
                random.nextInt(10) + 1,
                null);
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
