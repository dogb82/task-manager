package ch.taskmanager;

public enum Priority {
	LOW(0),
	MEDIUM(1),
	HIGH(3);

	private int priorityLevel;

	private Priority(int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public int getPriorityLevel() {
		return priorityLevel;
	}


}
