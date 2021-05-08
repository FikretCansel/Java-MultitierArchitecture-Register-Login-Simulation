package core.email;

import entities.concretes.User;

public class Gmail implements ISendEmail{

	@Override
	public void sendEmail(User user) {
		System.out.println(user.getFirstName()+"Gmail ile Email gönderildi"+"link");
	}

}
