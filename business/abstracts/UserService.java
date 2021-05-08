package business.abstracts;

import entities.concretes.User;

public interface UserService {
boolean register (User user);
	
boolean login(User user);
}
