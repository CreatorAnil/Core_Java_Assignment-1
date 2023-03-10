package todomanager3;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String userName;
	private String email;
	private String password;
	private List<Task> taskList;
	
	public User(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.taskList = new ArrayList<>();
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}
	

}
