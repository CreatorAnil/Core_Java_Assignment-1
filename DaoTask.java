package todomanager3;
import java.util.List;


public class DaoTask {
	private TaskDatabase taskDatabase;

	public DaoTask(TaskDatabase taskDatabase) {
		super();
		this.taskDatabase = taskDatabase;
	}

	public List<Task> getAllTask() throws Exception {
		if( taskDatabase.getAllTasks().size()==0) {
			throw new Exception("no task is present");
		}
		return this.taskDatabase.getAllTasks();
	}
	
	public List<Task> getAllCompletedTask() throws Exception{
		if( taskDatabase.getAllTasks().size()==0) {
			throw new Exception("no task is present");
		}
		return this.taskDatabase.getCompletedTask();
	}
	
	public List<Task> getAllInCompletedTask() throws Exception{
		if( taskDatabase.getAllTasks().size()==0) {
			throw new Exception("no task is present");
		}
		return this.taskDatabase.getInCompleteTask();
	}
	
	public static void addTask(String taskID, String taskTitle, String taskText, String assignedTo) {
		TaskDatabase.addTask(taskID, taskTitle, taskText, assignedTo);
		System.out.println("successfully add new task");
	}
	
	public static Task updateTask(String taskID, String taskTitle, String taskText, String assignedTo,boolean taskCompleted) {
		System.out.println("task is updated");
		return TaskDatabase.updateTask(taskID, taskTitle, taskText, assignedTo, taskCompleted);
		
	}
	
	public void deleteTask(String taskID) {
		if(TaskDatabase.deleteTask(taskID)==null) {
			System.out.println(taskID+" is not present in our system");
		}
		else {
			TaskDatabase.deleteTask(taskID);
			System.out.println("succefully deleted " + taskID+" task");
		}
	}
	
	public String searchTask(String taskID) {
		if(TaskDatabase.searchTask(taskID)==null) {
			System.out.println(taskID+" is not present in our system");
		}
		else {
			System.out.println(TaskDatabase.searchTask(taskID).toString());
		}
		return null;		
	}
}