import process.Process;
import process.ProcessState;

public class CPU {

    public void execute(Process process) {
        System.out.println("Execution " + process);
        process.setState(ProcessState.TERMINATED);
    }

}
