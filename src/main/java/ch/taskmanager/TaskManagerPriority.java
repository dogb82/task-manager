package ch.taskmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TaskManager with Priority based (3/3).
 */
public class TaskManagerPriority extends AbstractTaskManager {

	protected TaskManagerPriority(int capacityOfProcesses) {
		super(capacityOfProcesses);
	}

	@Override
	public void add(Process process) {
		if (runningProcesses.size() == getCapacityOfProcesses()) {
			boolean isHigher = isHigherPrioAsAnyOfExisting(process);
			if (isHigher) {
				removeLowestAndOldestProcess();
			}
		}
		runningProcesses.add(process);
	}

	boolean isHigherPrioAsAnyOfExisting(Process newProcess) {
		for (Process existingProcess : runningProcesses) {
			if (existingProcess.compareTo(newProcess) < 0) {
				return true;
			}
		}
		return false;
	}

	void removeLowestAndOldestProcess() {
		List<Process> sortedList = new ArrayList<>(runningProcesses);
		Collections.sort(sortedList);
		Process lowestAndOldestProcess = sortedList.get(0);
		for (int i = 0; i < runningProcesses.size(); i++) {
			if (runningProcesses.get(i).getPid() == lowestAndOldestProcess.getPid()) {
				runningProcesses.remove(i);
				return;
			}
		}
	}
}
