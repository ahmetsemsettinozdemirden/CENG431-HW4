package process;

import process.stateobserver.Observer;

import java.util.List;

public class Process implements Observable {

    private Integer id;
    private Integer arrivalTime;
    private Integer burstTime;
    private Integer completionTime;
    private Integer waitingTime;
    private Integer priority;
    private ProcessState processState;
    private List<Observer> observers;

    public Process(Integer id, Integer arrivalTime, Integer burstTime, Integer completionTime, Integer waitingTime, Integer priority, ProcessState processState) {
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

    @Override
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

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getPriority() {
        return priority;
    }

    public ProcessState getProcessState() {
        return processState;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }
}
