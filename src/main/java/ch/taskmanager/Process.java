package ch.taskmanager;

public class Process {
    private final int pid;
    private int priority;

    public Process(int pid) {
        this.pid = pid;
    }

    public void kill() {
        // it will destroy this object
    }
}
