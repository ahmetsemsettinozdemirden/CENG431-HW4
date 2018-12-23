package process;

import process.stateobserver.Observer;

import java.util.List;
import java.util.Random;

public class Process implements Observable {

    private int id;
    private int arrivalTime;
    private int burstTime;
    private int completionTime;
    private int waitingTime;
    private int priority;
    private ProcessState processState;
    private List<Observer> observers;

    public Process(int id, int arrivalTime, int burstTime, int completionTime, int waitingTime, int priority, ProcessState processState) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.completionTime = completionTime;
        this.waitingTime = waitingTime;
        this.priority = priority;
        this.processState = processState;
    }

    @Override
    public boolean addObserver(Observer observer) {
        return observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers)
            observer.update(this);
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getPriority() {
        return priority;
    }

    public ProcessState getProcessState() {
        return processState;
    }
}
