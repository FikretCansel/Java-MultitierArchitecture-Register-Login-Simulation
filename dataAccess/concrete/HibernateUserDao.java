package dataAccess.concrete;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("Eklendi");
		
	}

	@Override
	public boolean getExistEmail(String email) {
		return true;
	}

	@Override
	public String getPassword(String email) {
		
		
		return "123456789";
	}

}
