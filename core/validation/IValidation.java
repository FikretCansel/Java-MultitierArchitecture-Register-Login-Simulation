package core.validation;

import entities.concretes.User;

public interface IValidation {

	boolean checkEmailFormat(String email);
	
	boolean checkUser(User user);
	
	
}
