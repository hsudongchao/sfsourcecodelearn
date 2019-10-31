package test.lookup.bean;

public class Student extends User
{
	@Override
	public String showMe()
	{
		System.out.println("i am Student");
		return "student";
	}
}
