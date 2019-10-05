public class Plants
{
	private int hp;
	private int water;
	private int ground;
	private int insect;
	private int growthRate;
	private String status;
	private int weeds;
	private String specType;
	
	public Plants(int hp, int water, int ground, int insect, int growthRate, String status, int weeds, String specType)
	{
		setHp(hp);
		setWater(water);
		setGround(ground);
		setInsect(insect);
		setGrowthRate(growthRate);
		setStatus(status);
		setWeeds(weeds);
		setSpecType(specType);
	}
	
	public void setHp(int hp)
	{
		this.hp = hp;
	}
	
	public void setWater(int water)
	{
		this.water = water;
	}
	
	public void setGround(int ground)
	{
		this.ground = ground;
	}
	
	public void setInsect(int insect)
	{
		this.insect = insect;
	}
	
	public void setGrowthRate(int growthRate)
	{
		this.growthRate = growthRate;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public void setWeeds(int weeds)
	{
		this.weeds = weeds;
	}
	
	public void setSpecType(String specType)
	{
		this.specType = specType;
	}
	
	public int getHp()
	{
		return hp;
	}
	
	public int getWater()
	{
		return water;
	}
	
	public int getGround()
	{
		return ground;
	}
	
	public int getInsect()
	{
		return insect;
	}
	
	public int getGrowthRate()
	{
		return growthRate;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public int getWeeds()
	{
		return weeds;
	}
	
	public String getSpecType()
	{
		return specType;
	}
	
	public String toString()
	{
		return getHp() + " " + getWater() + " " + getGround() + " " + getInsect() + " " + getGrowthRate() + " " + 
	           getStatus() + " " + getWeeds() + " " + getSpecType();
	}
}