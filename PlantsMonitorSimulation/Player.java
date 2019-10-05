public class Player
{
	private String id;
	private int money;
	
	public Player(String id){
		setID(id);
		setMoney(1000);
	}
	
	public Player(String id, int money)
	{
		setID(id);
		setMoney(money);
	}
	
	public void setID(String id)
	{
		this.id = id;
	}
	
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public String getID()
	{
		return id;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public String toString()
	{
		return getID() + " " + getMoney();
	}
}