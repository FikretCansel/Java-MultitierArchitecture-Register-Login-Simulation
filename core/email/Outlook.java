package core.email;

import entities.concretes.User;

public class Outlook implements ISendEmail{

	@Override
	public void sendEmail(User user) {
		System.out.println(user.getFirstName()+" Outlook ile Email gönderildi ."+"link");	
	}

}
