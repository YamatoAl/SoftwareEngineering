import java.util.Scanner;

class PlantsSpec
{
    private int maxHp;
    private int maxWater;
    private int maxGround;
    private int maxInsect;
    private int maxGrowthRate;
    private int maxWeeds;
    private int seedPrice;
    private int soldPrice;
    private int greenHouseType;
    private String type;

    public PlantsSpec(String type2, int maxHp2, int maxWater2, int maxGround2,  int maxInsect2, int maxGrowthRate2, int maxWeeds2, int seedPrice2, int soldPrice2, int greenHouseType2)
    {
        maxHp = maxHp2;
        maxWater = maxWater2;
        maxGround = maxGround2;
        maxInsect = maxInsect2;
        maxGrowthRate = maxGrowthRate2;
        maxWeeds = maxWeeds2;
        seedPrice = seedPrice2;
        soldPrice = soldPrice2;
        greenHouseType =  greenHouseType2;
        type = type2;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxWater() {
        return maxWater;
    }


    public int getMaxGround()
    {
        return maxGround;
    }

    public int getMaxInsect()
    {
        return maxInsect;
    }

    public int getMaxGrowthRate()
    {
        return maxGrowthRate;
    }

    public int getMaxWeeds()
    {
        return maxWeeds;
    }

    public int getSeedPrice()
    {
        return seedPrice;
    }

    public int getSoldPrice()
    {
        return soldPrice;
    }

    public int getGreenHouseType()
    {
        return greenHouseType;
    }

    public String getType()
    {
        return type;
    }
}