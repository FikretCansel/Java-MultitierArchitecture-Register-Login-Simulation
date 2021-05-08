package core.validation;

import entities.concretes.User;
import regex.RegexValidation;

public class RegexAdapter implements IValidation{

	
	private RegexValidation regexAdapter;
	
	public RegexAdapter() {
		this.regexAdapter=new RegexValidation();
	}
	
	
	@Override
	public boolean checkEmailFormat(String email) {
		boolean result=regexAdapter.emailFormatControl(email);
		return result;
	}


	@Override
	public boolean checkUser(User user) {
		regexAdapter.emailFormatControl(user.getEmail());
		//regexAdapter.password(user.getPassword())
		return false;
	}
	
	

	
	
	
}
