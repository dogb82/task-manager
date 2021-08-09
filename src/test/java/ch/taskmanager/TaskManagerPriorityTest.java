package ch.taskmanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskManagerPriorityTest {

	private TaskManagerPriority taskManager;

	@Test
	public void isHigherPrioAsAnyOfExisting_givenAnHigherProcess_returnsTrue() {
		initAndFillUpTaskManager(2);
		Process highestProcess = new Process(1000, Priority.HIGH);
		boolean isHigherPrioAsAnyOfExisting = taskManager.isHigherPrioAsAnyOfExisting(highestProcess);
		assertEquals(true, isHigherPrioAsAnyOfExisting);
	}

	@Test
	public void isHigherPrioAsAnyOfExisting_givenALowPrioProcess_returnsFalse() {
		initAndFillUpTaskManager(2);
		Process highestProcess = new Process(1000, Priority.LOW);
		boolean isHigherPrioAsAnyOfExisting = taskManager.isHigherPrioAsAnyOfExisting(highestProcess);
		assertEquals(false, isHigherPrioAsAnyOfExisting);
	}

	@Test
	public void isHigherPrioAsAnyOfExisting_givenAMediumPrioProcess_returnsTrue() {
		initAndFillUpTaskManager(2);
		Process highestProcess = new Process(1000, Priority.MEDIUM);
		boolean isHigherPrioAsAnyOfExisting = taskManager.isHigherPrioAsAnyOfExisting(highestProcess);
		assertEquals(true, isHigherPrioAsAnyOfExisting);
	}

	@Test
	public void removeLowestAndOldestProcess_givenAList_returnListWithoutTheOldestAndLowest() {
		initAndFillUpTaskManager(10);

		taskManager.removeLowestAndOldestProcess();
		assertEquals(taskManager.getCapacityOfProcesses() - 1, taskManager.list().size());
		assertEquals(taskManager.list().get(0).getPid(), 101);
	}

	private void initAndFillUpTaskManager(int sizeOfProcess) {
		taskManager = new TaskManagerPriority(sizeOfProcess);

		int lenOfPriorities = Priority.values().length;

		for (int i = 0; i < taskManager.getCapacityOfProcesses(); i++) {
			taskManager.add(new Process(100 + i, Priority.values()[i % lenOfPriorities]));
		}
	}
}