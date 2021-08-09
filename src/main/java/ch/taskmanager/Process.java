package ch.taskmanager;

public final class Process implements Comparable<Process> {
    private final int pid;
    private final Priority priority;

    public Process(int pid, Priority priority) {
        this.pid = pid;
        this.priority = priority;
    }

    public void kill() {
        // it will destroy this object
    }

    public int getPid() {
        return pid;
    }

    public Priority getPriority() {
        return priority;
    }

    /**
     * Compares the priority of two processes which is higher, lower and equal.
     *
     * @param otherProcess
     * @return
     *      -1 = otherProcess is higher (this-process is lower),<br />
     *      0 = equal,<br />
     *      1 = this-process is higher (otherProcess is lower)
     */
    @Override
    public int compareTo(Process otherProcess) {
        int priorityLevelOfOtherProcess = otherProcess.getPriority().getPriorityLevel();
        int priorityLevelOfThisProcess = priority.getPriorityLevel();
        return Integer.compare(priorityLevelOfThisProcess, priorityLevelOfOtherProcess);
    }

    @Override
    public String toString() {
        return "Process{" +
                "pid=" + pid +
                ", priority=" + priority +
                '}';
    }
}
