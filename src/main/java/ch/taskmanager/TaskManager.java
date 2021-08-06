package ch.taskmanager;

import java.util.*;

public class TaskManager extends AbstractTaskManager {

    private final int capacityOfProcesses;
    private List<Process> runningProcesses;

    public TaskManager(int capacityOfProcesses) {
        this.capacityOfProcesses = capacityOfProcesses;
        this.runningProcesses = new ArrayList<>(capacityOfProcesses);
    }

    public void add(Process process) {
        if (runningProcesses.size() < capacityOfProcesses) {
            runningProcesses.add(process);
        } else {
            runningProcesses.remove(0);
            runningProcesses.add(process);
        }
    }




}
