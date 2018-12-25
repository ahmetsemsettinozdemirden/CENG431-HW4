package process;

import process.stateobserver.Observer;

import java.util.ArrayList;
import java.util.List;

public class Process implements Observable {

    private int id;
    private int arrivalTime;
    private int burstTime;
    private int completionTime;
    private Integer waitingTime;
    private int priority;
    private ProcessState processState;
    private List<Observer> observers;

    public Process(int id, int arrivalTime, int burstTime, int completionTime, Integer waitingTime, int priority, ProcessState processState) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.completionTime = completionTime;
        this.waitingTime = waitingTime;
        this.priority = priority;
        this.processState = processState;
        this.observers = new ArrayList<>();
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

    public void setState(ProcessState processState) {
        this.processState = processState;
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

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public int getPriority() {
        return priority;
    }

    public ProcessState getProcessState() {
        return processState;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Process: " + "id=" + id + ", priority=" + priority + ", arrivalTime=" + arrivalTime +
                ", burstTime=" + burstTime + ", completionTime=" + completionTime + ", waitingTime=" + waitingTime  +
                ", processState=" + processState;
    }
}
