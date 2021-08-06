package ch.taskmanager;

/**
 * - handling multiple processes inside an operating system
 * - should have a prefixed maximum capacity of running processes
 *      - defined as build time
 * -
 */
public abstract class AbstractTaskManager {

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
     * - sorting them by
     *      - time of creation (implicitly we can consider it the time in which has
     *        been added to the TM),
     *      - priority or
     *      - id
     */
    public void list() {

    }

    /**
     * killing a specific process
     */
    public void kill(Process process) {

    }

    /**
     * killing all prcesses with a specific priority
     */
    public void killGroup() {

    }

    /**
     * killing all running processes
     */
    public void killAll() {

    }
}