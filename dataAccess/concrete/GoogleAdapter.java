package dataAccess.concrete;

import dataAccess.abstracts.UserDao;
import dataAccess.concrete.google.GoogleSystem;
//import dataAccess.concrete.google.googleSystem;
import entities.concretes.User;

public class GoogleAdapter implements UserDao{
	
	private GoogleSystem google;
	
	
	public GoogleAdapter() {
		this.google=new GoogleSystem();
	}

	@Override
	public void add(User user) {
		System.out.println("Google ile eklendi");
		google.signUp(user);
	}

	@Override
	public boolean getExistEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
