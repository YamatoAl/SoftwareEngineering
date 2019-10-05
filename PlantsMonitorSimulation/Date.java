import java.util.*;

public class Date
{
	protected static final int ROUNDINMONTH=4;
	private int month;
	private int round;
	private String weather;
	
	public Date()
	{
		setMonth(1);
		setRound(1);
		randomWeather();
	}
	
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
	
	public void randomWeather()
	{
		Random rand=new Random();
		switch(rand.nextInt(3)){
			case 0:
				setWeather("SUN");
				break;
			case 1:
				setWeather("CLOUDY");
				break;
			case 2: default:
				setWeather("RAIN");
				break;
		}
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
	
	public void next(){
		if(round < ROUNDINMONTH){
			round++;
		}
		else{
			round=1;
			if(month < 12){
				month++;
			}
			else{
				month=1;
			}
		}
		randomWeather();
	}
}