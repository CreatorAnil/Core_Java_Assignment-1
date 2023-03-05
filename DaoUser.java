package todomanager3;

import java.util.List;

public class DaoUser{
	private UserDatabase userDatabase;
	
	public DaoUser(UserDatabase userDatabase){
		super();
		this.userDatabase = userDatabase;
	}
	
	public List<User> getAllUsers() throws Exception{
		if(userDatabase.getAllUsers().size() ==0) {
			throw new Exception("No user");
		}
		return this.userDatabase.getAllUsers();
	}
	
	public boolean validateCredentials(String email, String password) throws Exception {
		if(email==null || email.isEmpty()) {
			throw new Exception("email cannot be empty or null");
		}
		return this.userDatabase.login(email, password);
	}

}
