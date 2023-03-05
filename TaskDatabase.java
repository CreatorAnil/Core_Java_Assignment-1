package todomanager3;

import java.util.ArrayList;
import java.util.List;

public class TaskDatabase {
	private static List<Task> tasks= new ArrayList<>();

	public TaskDatabase() {
		super();
	}

	public List<Task> getAllTasks() {
		return tasks;
	}
	
	public List<Task> getCompletedTask(){
		List<Task> temp = new ArrayList<>();
		for(Task t:tasks) {
			if(t.isTaskCompleted()==true) {
				temp.add(t);
			}
		}
		return temp;
	}
	
	public List<Task> getInCompleteTask(){
		List<Task> temp = new ArrayList<>();
		for(Task t:tasks) {
			if(t.isTaskCompleted()==false) {
				temp.add(t);
			}
		}
		return temp;
	}
	
	public static void addTask(String taskID, String taskTitle, String taskText, String assignedTo) {
		Task t = new Task(taskID,taskTitle,taskText,assignedTo);
		try {
			tasks.add(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Task updateTask(String taskID, String taskTitle, String taskText, String assignedTo,boolean taskCompleted) {
		for(Task t:tasks) {
			if(t.getTaskID().equals(taskID)) {
				t.setTaskTitle(taskTitle);
				t.setTaskText(taskText);
				t.setAssignedTo(assignedTo);
				t.setTaskCompleted(taskCompleted);
				return t;
			}
			
		}
		return null;
		
	}
	
	public static String deleteTask(String taskID) {
		for(Task t:tasks) {
			if(t.getTaskID().equals(taskID)) {
				tasks.remove(t);
				return taskID;
			}
		}
		return null;
		
	}
	
	public static Task searchTask(String taskID) {
		for(Task t:tasks) {
			if(t.getTaskID().equals(taskID)) {
				return t;
			}
		}
		return null;
	}
	

}
