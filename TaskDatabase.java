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
	
	public static void addTask(int taskID, String taskTitle, String taskText, String assignedTo) {
		Task t = new Task(taskID,taskTitle,taskText,assignedTo);
		try {
			tasks.add(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Task updateTask(int taskID, String taskTitle, String taskText, String assignedTo,boolean taskCompleted) {
		for(Task t:tasks) {
			if(t.getTaskID()==taskID) {
				t.setTaskTitle(taskTitle);
				t.setTaskText(taskText);
				t.setAssignedTo(assignedTo);
				t.setTaskCompleted(taskCompleted);
				return t;
			}
			
		}
		return null;
		
	}
	
	public static String deleteTask(int taskID) {
		for(Task t:tasks) {
			if(t.getTaskID() == taskID) {
				tasks.remove(t);
				return "task is succefully removed";
			}
		}
		return null;
		
	}
	
	public static String searchTask(int taskID) {
		for(Task t:tasks) {
			if(t.getTaskID() == taskID) {
				return t.toString();
			}
		}
		return null;
	}
	

}
