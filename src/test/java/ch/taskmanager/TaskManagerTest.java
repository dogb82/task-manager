package ch.taskmanager;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TaskManagerTest {

	private TaskManager taskManager;

	@Test
	public void add_givenAFullProcessListAddingOneMore_resultIsSameAsBefore() {
		initAndFillUpTaskManager(0);
		taskManager.add(new Process(1000, Priority.HIGH));
		List<Process> processList = taskManager.listSortedById();
		assertEquals(0, processList.size());
	}

	@Test
	public void killGroup_removingAllLowestPriorityProcesses_returnsListWithoutLowPrio() {
		initAndFillUpTaskManager(6);
		taskManager.killGroup(Priority.LOW);
		assertEquals(4, taskManager.list().size());
	}

	private void initAndFillUpTaskManager(int sizeOfProcess) {
		taskManager = new TaskManager(sizeOfProcess);

		int lenOfPriorities = Priority.values().length;

		for (int i = 0; i < taskManager.getCapacityOfProcesses() + 1; i++) {
			taskManager.add(new Process(100 + i, Priority.values()[i % lenOfPriorities]));
		}
	}
}