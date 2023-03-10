package todomanager3;

import java.util.Scanner;

public class Menu {
	
	public static void adminUser() {
		System.out.println("1. see All completed task");
		System.out.println("2. see All Incompleted task");
		System.out.println("3. logout");
	}
	
	public static void userMenu() {
		System.out.println("1. add the task");
		System.out.println("2. update the task");
		System.out.println("3. delete the task");
		System.out.println("4. search the task");
		System.out.println("5. see all the task");
		System.out.println("6. logout");
	}
	
	public static void main(String[] args) {
		
		UserDatabase userDB = new UserDatabase();
		TaskDatabase taskDB = new TaskDatabase();
		
		DaoUser daouser = new DaoUser(userDB);
		DaoTask daotask = new DaoTask(taskDB);
		Scanner sc = new Scanner(System.in);
		String username, email, password;
		int choice;
		boolean flag = true;
		do {
			System.out.println("Choose one of the options");
			System.out.println("0. exit");
			System.out.println("1. Login");
			choice = sc.nextInt();
			switch(choice) {
			case 0: System.out.println("Thanks for using Application");
			flag = false;
			break;
			case 1:
				System.out.println("please enter email");
				email = sc.next();
				System.out.println("please enter password");
				password = sc.next();
				if(email.equals("admin@g.com") && password.equals("admin")) {
					adminDashboard(sc, daouser,daotask);
				}
				else {
					try {
						if(daouser.validateCredentials(email, password)) {
							userDashboard(sc, daouser, daotask, email);
						}
						
					}catch( Exception e) {
						e.printStackTrace();
				}
				}
			
			
			default : System.out.println("Invalid user");
			}
		}while(flag);
		
	}
	
	public static void adminDashboard(Scanner sc, DaoUser daouser,DaoTask daotask) {
		boolean flag = true;
		do {
			System.out.println("\n ******** admin dashborad************\n");
			adminUser();
			int choice =sc.nextInt();
			switch(choice) {
			
			case 1: try {
					System.out.println(daotask.getAllCompletedTask());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				break;
				
			case 2:
				try {
					System.out.println(daotask.getAllInCompletedTask());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//
				break;
				
			case 3:System.out.println("adming has successful logout");
			flag = false;
				break;
				
			default:
				System.out.println("please provide valid input");
			}
		}while(flag);
	}
	
	public static void userDashboard(Scanner sc,DaoUser daouser,DaoTask daotask, String email) {
		boolean flag = true;
		do {
			System.out.println("\n *************** user dashboard*******");
			userMenu();
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1: //add the task
				try {
					System.out.println("please enter taskId");
					int taskID = sc.nextInt();
					System.out.println("please enter taskTitle");
					String taskTitle =sc.next();
					System.out.println("please enter taskText");
					String taskText =sc.next();
					System.out.println("please enter assignedTo");
					String assignedTo =sc.next();
					
					DaoTask.addTask(taskID, taskTitle, taskText, assignedTo);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
				
			case 2://update the task
				try {
				System.out.println("please enter taskId");
				int taskID= sc.nextInt();
				System.out.println("please enter taskTitle");
				String taskTitle=sc.next();
				System.out.println("please enter taskText");
				String taskText=sc.next();
				System.out.println("please enter assignedTo");
				String assignedTo=sc.next();
				System.out.println("please enter taskCompleted");
				boolean taskCompleted=sc.nextBoolean();
				DaoTask.updateTask(taskID, taskTitle, taskText, assignedTo, taskCompleted);
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 3://delete the task
				try {
				System.out.println("please provide taskId");
				int taskID = sc.nextInt();
				daotask.deleteTask(taskID);
			}catch(Exception e) {
				e.printStackTrace();
			}
				break;
				
			case 4://search the task
				try {
				System.out.println("please provide taskId");
				int taskID = sc.nextInt();
				daotask.searchTask(taskID);
			}catch(Exception e) {
				e.printStackTrace();
			}
				break;
				
			case 5://see all the task
				try {
					daotask.getAllTask();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();;
				}
				break;
				
			case 6://Logout
				System.out.println("user successfully logout");
				flag = false;
				break;
			}
			
		}while(flag);
	}

}
