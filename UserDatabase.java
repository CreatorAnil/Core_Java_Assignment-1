package todomanager3;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
	private List<User> users = new ArrayList<>();
	
	public UserDatabase() {
		users.add(new User("anil","anil@g.com","anil"));
		users.add(new User("sunil","sunil@g.com","sunil"));
	}
	
	public List<User> getAllUsers(){
		return this.users;
	}
	
	public boolean login(String email, String password) {
		for( User u: users) {
			if(u.getEmail().equals(email)) {
				if(u.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
}
