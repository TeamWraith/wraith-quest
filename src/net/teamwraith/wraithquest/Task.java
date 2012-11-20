package net.teamwraith.wraithquest;

public class Task {

// 	Represents the possible states of a task.
//	Allows for branching quests and all that through task checks (in later versions).
	public enum TaskState {
		NOT_ACTIVATED, ACTIVATED, FAILED, COMPLETED
	}
	
// 	Link to the video that this task will trigger
	private String videoLink = "null link"; 
// 	The text of the task point
	private String taskPoint = "null task"; 
//	Password that triggers this task point 
	private String password = "null password"; 
//	Current state.
	private TaskState state;
	
	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getTaskPoint() {
		return taskPoint;
	}

	public void setTaskPoint(String taskPoint) {
		this.taskPoint = taskPoint;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Constructor for object Task.
	 * 
	 * @param taskPoint - String representing the text that will show up under task points.
	 * @param password - the password.
	 */
	public Task(String taskPoint, String password) {
		this.taskPoint = taskPoint;
		this.password = password;
		state = TaskState.NOT_ACTIVATED;
	}
	
	/**
	 * Constructor for object Task.
	 * 
	 * @param videoLink - Link to the youtube video that will play. Not required.
	 * @param taskPoint - String representing the text that will show up under task points.
	 * @param password - the password.
	 */
	public Task(String videoLink, String taskPoint, String password) {
		this(taskPoint,password);
		this.videoLink = videoLink;
	}

}
