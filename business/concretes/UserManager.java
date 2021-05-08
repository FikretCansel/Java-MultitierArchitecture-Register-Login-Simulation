package business.concretes;

import business.abstracts.UserService;
import core.email.ISendEmail;
import core.validation.IValidation;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;





public class UserManager implements UserService {

	private IValidation validation;
	private UserDao userDao;
	private ISendEmail sendEmail;
	public UserManager(IValidation validation, UserDao userDao,ISendEmail sendEmail) {
		this.validation = validation;
		this.userDao = userDao;
		this.sendEmail=sendEmail;
	}

	@Override
	public boolean register(User user) {
		if (!validation.checkEmailFormat(user.getEmail())) {
			System.out.println("email format hatas�");
			return false;
		}

		if (user.getPassword().length() < 6 || user.getLastName().length() < 2 || user.getFirstName().length() < 2) {
			System.out.println("ad,soyad,�ifre uzunlugunu kontrol ediniz");
			
			return false;
		}
		if (userDao.getExistEmail(user.getEmail())) {
			System.out.println("bu kullan�c� zaten kay�tl�");
			return false;
		}
		
		
		userDao.add(user);
		
		sendEmail.sendEmail(user);
		
		System.out.println("Kay�t Ba�ar�l�");

		return true;
	}

	@Override
	public boolean login(User user) {
		if (!validation.checkEmailFormat(user.getEmail())) {
			System.out.println("email hatal�");
			return false;
		}
		if (user.getPassword() == "") {
				System.out.println("�ifren bo� b�rak�lamaz");
				return false;
		}

		if (!userDao.getExistEmail(user.getEmail())) {
			System.out.println("kullan�c� bulunamad�");
			return false;
		}

		if (!(userDao.getPassword(user.getEmail()) == user.getPassword())) {
			System.out.println("�ifre yanl��");
			return false;
		}
		
		System.out.println("Giri� Ba�ar�l�");
		
		return true;
	}

}
