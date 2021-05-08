package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidation {
	
	
	public boolean emailFormatControl(String email){
		
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		 
		Pattern pattern = Pattern.compile(regex);
		 
		Matcher matcher = pattern.matcher(email);
		
		boolean result= matcher.matches();
		
		return result;
	}
}
