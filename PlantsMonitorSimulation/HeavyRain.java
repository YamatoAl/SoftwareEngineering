import java.util.Scanner;

class HeavyRain{
	private String type="HeavyRain";
	private int[] probability = {0,0,0,0,20,80,70,20,0,0,0,0,0};
	public HeavyRain(){}
	public String getType(){
		return type;
	}
	public int getProbability(int month){
		return probability[month];
	}
	public void action(Plants P){
		int water = P.getWater();
		int ground = P.getGround();
		int hp = P.getHp();
		P.setWater(water+20);
		P.setGround(ground-30);
		P.setHp(hp-20);
	}
}