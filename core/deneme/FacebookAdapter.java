package core.deneme;

import vertifys.facebookVertify;

public class FacebookAdapter implements IVertify{

	@Override
	public boolean register() {
		facebookVertify facebook=new facebookVertify();
		facebook.vertify();
		return false;
	}

	

}
