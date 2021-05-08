package dataAccess.abstracts;

import entities.concretes.User;

public interface UserDao {
	
	
	
	void add(User user);
	
	boolean getExistEmail(String email);
	
	String getPassword(String email);
	
}
