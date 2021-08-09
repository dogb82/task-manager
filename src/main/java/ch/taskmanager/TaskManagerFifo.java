package ch.taskmanager;

/**
 * TaskManager with FIFO approach (2/3).
 */
public class TaskManagerFifo extends AbstractTaskManager {

	protected TaskManagerFifo(int capacityOfProcesses) {
		super(capacityOfProcesses);
	}

	@Override
	public void add(Process process) {
		if (runningProcesses.size() == getCapacityOfProcesses()) {
			runningProcesses.remove(0);
		}
		runningProcesses.add(process);
	}
}
