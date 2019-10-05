public class Player
{
	private String id;
	private int money;
	
	public Player(String id, int money)
	{
		setId(id);
		setMoney(money);
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public String getId()
	{
		return id;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public String toString()
	{
		return getId() + " " + getMoney();
	}
}