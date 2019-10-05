import java.util.Scanner;

class Cold{
	private String type="cold";
	private int[] probability = {0,20,15,10,5,2,0,0,0,2,5,10,15};
	
	public Cold(){}		
	
	public String getType(){
		return type;
	}
	public int getProbability(int month){
		return probability[month];
	}
	public void action(Plants P){
		int hp = P.getHp();
		P.setHp(hp-30);
	}
}