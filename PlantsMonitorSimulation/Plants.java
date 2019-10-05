import java.util.Scanner;

class Plants
{
    private int hp;
    private int water;
    private int ground;
    private int insect;
    private int growthRate;
    private int weeds;
    private String status;
    private PlantsSpec spec;


    public Plants(int hp2, int water2, int ground2, int insect2, int growthRate2, String status2, int weeds2, PlantsSpec spec2)
    {
        hp = hp2;
        water = water2;
        ground = ground2;
        insect = insect2;
        growthRate = growthRate2;
        weeds = weeds2;
        status = status2;
        spec = spec2;
    }

    public Plants(PlantsSpec spec2)
    {
        spec = spec2;
        hp = spec.getMaxHp();
        water = spec.getMaxWater();
        ground = spec.getMaxGround();
        insect = spec.getMaxInsect();
        growthRate = 0;
        weeds = spec.getMaxWeeds();
        status = "health";
    }

    public boolean setHp(int hp2)
    {
        if(hp2 < 0)
        {
            hp = 0;
            return false;
        }
        else if(hp2 > spec.getMaxHp())
        {
            hp = spec.getMaxHp();
            return true;
        }
        else
        {
            hp = hp2;
            return true;
        }
    }

    public boolean setWater(int water2)
    {
        if(water2 < 0)
        {
            water = 0;
            return false;
        }
        else if(water2 > spec.getMaxWater())
        {
            water = spec.getMaxWater();
            return true;
        }
        else
        {
            water = water2;
            return true;
        }
    }

    public boolean setGround(int ground2)
    {
        if(ground2 < 0)
        {
            ground = 0;
            return false;
        }
        else if(ground2 > spec.getMaxGround())
        {
            ground = spec.getMaxGround();
            return true;
        }
        else
        {
            ground = ground2;
            return true;
        }
    }

    public boolean setInsect(int insect2)
    {
        if(insect2< 0)
        {
            insect = 0;
            return false;
        }
        else if(insect2 > spec.getMaxInsect())
        {
            insect = spec.getMaxInsect();
            return true;
        }
        else
        {
            insect = insect2;
            return true;
        }
    }

    public boolean setGrowthRate(int growthRate2)
    {
        if(growthRate2 < 0)
        {
            growthRate = 0;
            return false;
        } else if (growthRate2 > spec.getMaxGrowthRate())
        {
            growthRate = spec.getMaxGrowthRate();
            return true;
        }
        else
        {
            growthRate = growthRate2;
            return true;
        }
    }

    public boolean setStatus(String status2)
    {
        status = status2;
        return true;
    }

    public boolean setWeeds(int weeds2)
    {
        if(weeds2< 0)
        {
            weeds = 0;
            return false;
        }
        else if (weeds2 > spec.getMaxWeeds())
        {
            weeds = spec.getMaxWeeds();
            return true;
        }
        else
        {
            weeds = weeds2;
            return true;
        }
    }

    public void setSpec(PlantsSpec spec2)
    {
        spec=spec2;
    }

    public void roundChange(int hpvalue,int watervalue,int groundvalue,int insectvalue,int growthRatevalue ,int weedsvalue)
    {
        hp+=hpvalue;
        water+=watervalue;
        ground+=groundvalue;
        insect+=insectvalue;
        setGrowthRate(growthRate+growthRatevalue);
        weeds+=weedsvalue;
    }

    public int getHp()
    {
        return hp;
    }

    public int getWater()
    {
        return water;
    }

    public int getInsect()
    {
        return insect;
    }
	
	public int getGround()
	{
		return ground;
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

    public PlantsSpec getSpec()
    {
        return spec;
    }
}