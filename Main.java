import business.abstracts.UserService;
import business.concretes.UserManager;
import core.email.Outlook;
import core.validation.RegexAdapter;
import dataAccess.concrete.HibernateUserDao;
import entities.concretes.User;


public class Main {

	public static void main(String[] args) {
		
		
		UserService userService=new UserManager(new RegexAdapter(),
				new HibernateUserDao(),
				new Outlook());
		
		User fikret=new User(1,"fikret@gmail.com","123456789","fikret","cansel");
		
		System.out.println(userService.register(fikret));
		
		
		User fikret2=new User(1,"fikret@gmail.com","","fikret","cansel");
		
		userService.login(fikret2);
		
		System.out.println("bitti");

	}

}
