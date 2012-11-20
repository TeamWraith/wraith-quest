package net.teamwraith.wraithquest;

public class Quest {

//	Represents the possible states of a quest. Might allow for possible branching?
	static enum QuestState {
		NOT_STARTED, STARTED, FAILED, COMPLETED
	}
	
//	Name of the quest.
	private String 		name = "null name";
//	Description of the quest.
	private String 		description = "null description";
//	Type of quest; probably temporary.
	private String 		type;
//	Array of tasks that the quest will undergo.
	private Task[] 		tasks;
//	Current state of the quest.
	private QuestState 	state = QuestState.NOT_STARTED;
//	Current task. 0: Quest isn't initialised. Will increment for each step.
	private int 		currentTask = 0;
	
	public int getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(int currentTask) {
		this.currentTask = currentTask;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public QuestState getState() {
		return state;
	}

	public void setState(QuestState state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		System.out.println(type);
		if (type.equals("character"))
			this.type = "character";
		else if(type.equals("cutscene"))
			this.type = "cutscene";
		else
			this.type = "quest"; // defaults to quest
	}
	
	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Task[] getTasks() {
		return tasks;
	}

	public void setTasks(Task[] tasks) {
		this.tasks = tasks;
	}
	
}
