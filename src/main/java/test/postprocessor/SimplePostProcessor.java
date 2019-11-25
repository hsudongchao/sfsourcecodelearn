package test.postprocessor;

public class SimplePostProcessor
{
	private String connectionString;
	private String password;
	private String username;

	public void setConnectionString(String connectionString)
	{
		this.connectionString = connectionString;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@Override
	public String toString()
	{
		return "SimplePostProcessor{" +
				"connectionString='" + connectionString + '\'' +
				", password='" + password + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
