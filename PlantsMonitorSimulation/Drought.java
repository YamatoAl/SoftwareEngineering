import java.util.Scanner;

class Drought{
	private String type="Drought";
	private int[] probability = {0,30,40,50,40,30,20,0,0,0,0,0,0};
	public Drought(){}
	public String getType(){
		return type;
	}
	public int getProbability(int month){
		return probability[month];
	}
	public void action(Plants P){
		int water = P.getWater();
		int ground = P.getGround();
		P.setWater(water-20);
		P.setGround(ground-20);
	}
}