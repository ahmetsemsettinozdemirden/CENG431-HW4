import process.Process;
import process.ProcessState;

public class CPU {

    public void execute(Process process) {
        process.setState(ProcessState.TERMINATED);
    }

}
