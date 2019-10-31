package test.lookup.bean;

public class Teacher extends User
{
	@Override
	public String showMe()
	{
		System.out.println("i am Teacher");
		return "teacher";
	}
}
