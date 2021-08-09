package ch.taskmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * - handling multiple processes inside an operating system
 * - should have a prefixed maximum capacity of running processes
 *      - defined as build time
 * -
 */
public abstract class AbstractTaskManager {

    private final int capacityOfProcesses;
    List<Process> runningProcesses;

    protected AbstractTaskManager(int capacityOfProcesses) {
        this.capacityOfProcesses = capacityOfProcesses;
        this.runningProcesses = new ArrayList<>(capacityOfProcesses);
    }

    public int getCapacityOfProcesses() {
        return capacityOfProcesses;
    }

    /**
     * Default behaviour:
     * - accept new process till when there is a capacity inside TM
     * - otherwise it won't accept any new process
     *
     * FIFO approach:
     * - accept all new processes
     * - killing and removing from TM list the oldest one (FIFO) when max size reached
     *
     * Priority based:
     * - if new process passed, call has a higher priority compared to any of the existing one,
     *   remove lowest priority that is the oldest, otherwise skip it
     *
     * @param process
     */
    public abstract void add(Process process);

    /**
     * - list all running processes
     * - sorting them by time of creation (implicitly we can consider it the time in which has
     *        been added to the TM),
     *
     * @return
     */
    public List<Process> list() {
        return runningProcesses;
    }

    /**
     * - list all running processes
     * - sorting them by priority
     * @return
     */
    public List<Process> listSortedByPriority() {
        List<Process> sortedByPrio = new ArrayList<>(runningProcesses);
        Collections.sort(sortedByPrio);
        return sortedByPrio;
    }

    /**
     * - list all running processes
     * - sorting them by id
     * @return
     */
    public List<Process> listSortedById() {
        List<Process> sortedById = new ArrayList<>(runningProcesses);
        Collections.sort(sortedById, new Comparator<Process>() {
            @Override
            public int compare(Process proc1, Process proc2) {
                return Integer.compare(proc1.getPid(), proc2.getPid());
            }
        });
        return sortedById;
    }

    /**
     * killing a specific process
     */
    public void kill(Process process) {
        for (int i = 0; i < runningProcesses.size(); i++) {
            if (process.getPid() == runningProcesses.get(i).getPid()) {
                runningProcesses.remove(i);
                return;
            }
        }
    }

    /**
     * killing all prcesses with a specific priority
     */
    public void killGroup(Priority priority) {
        for (int i = 0; i < runningProcesses.size(); i++) {
            if (runningProcesses.get(i).getPriority().equals(priority)) {
                runningProcesses.remove(i);
            }
        }
    }

    /**
     * killing all running processes
     */
    public void killAll() {
        runningProcesses.clear();
    }
}
