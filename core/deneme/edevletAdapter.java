package core.deneme;

import vertifys.edevletVertify;

public class edevletAdapter implements IVertify{

	

	@Override
	public boolean register() {
		edevletVertify edevlet=new edevletVertify();
		edevlet.dogrulma();
		return false;
	}

}
