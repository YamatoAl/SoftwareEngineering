public class Date
{
	private int month;
	private int round;
	private String weather;
	
	public Date(int month, int round, String weather)
	{
		setMonth(month);
		setRound(round);
		setWeather(weather);
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public void setRound(int round)
	{
		this.round = round;
	}
	
	public void setWeather(String weather)
	{
		this.weather = weather;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getRound()
	{
		return round;
	}
	
	public String getWeather()
	{
		return weather;
	}
	
	public String toString()
	{
		return getMonth() + " " + getRound() + " " + getWeather();
	}
}