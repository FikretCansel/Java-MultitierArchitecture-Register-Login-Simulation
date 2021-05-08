package core.deneme;

import vertifys.googleVertify;

public class GoogleAdapter implements IVertify{

	@Override
	public boolean register() {
		googleVertify google=new googleVertify();
		google.register();
		return false;
	}

	


	
	
}
