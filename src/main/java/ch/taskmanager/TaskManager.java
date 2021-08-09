package ch.taskmanager;

import java.util.*;

/**
 * TaskManager with default behaviour (1/3)
 */
public class TaskManager extends AbstractTaskManager {

    public TaskManager(int capacityOfProcesses) {
        super(capacityOfProcesses);
    }

    public void add(Process process) {
        if (runningProcesses.size() < getCapacityOfProcesses()) {
            runningProcesses.add(process);
        } else {
            // we do not accept
            // possible to notify the consumer, that we don't accept because capacity reached.
        }
    }




}
