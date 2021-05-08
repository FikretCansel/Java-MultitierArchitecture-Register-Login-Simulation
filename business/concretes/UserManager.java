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
			System.out.println("email format hatasý");
			return false;
		}

		if (user.getPassword().length() < 6 || user.getLastName().length() < 2 || user.getFirstName().length() < 2) {
			System.out.println("ad,soyad,þifre uzunlugunu kontrol ediniz");
			
			return false;
		}
		if (userDao.getExistEmail(user.getEmail())) {
			System.out.println("bu kullanýcý zaten kayýtlý");
			return false;
		}
		
		
		userDao.add(user);
		
		sendEmail.sendEmail(user);
		
		System.out.println("Kayýt Baþarýlý");

		return true;
	}

	@Override
	public boolean login(User user) {
		if (!validation.checkEmailFormat(user.getEmail())) {
			System.out.println("email hatalý");
			return false;
		}
		if (user.getPassword() == "") {
				System.out.println("Þifren boþ býrakýlamaz");
				return false;
		}

		if (!userDao.getExistEmail(user.getEmail())) {
			System.out.println("kullanýcý bulunamadý");
			return false;
		}

		if (!(userDao.getPassword(user.getEmail()) == user.getPassword())) {
			System.out.println("þifre yanlýþ");
			return false;
		}
		
		System.out.println("Giriþ Baþarýlý");
		
		return true;
	}

}
