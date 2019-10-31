package test.lookup.app;

import test.lookup.bean.User;

public abstract class GetBeanTest
{
	public String showMe() {
		return this.getBean().showMe();
	}

	public abstract User getBean();
}
