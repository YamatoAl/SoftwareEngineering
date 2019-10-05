import java.util.Scanner;

class Sick{
	private String type="sick";
	private int[] probability = {0,5,5,5,5,5,5,5,5,5,5,5,5};
	public Sick(){}
	public String getType(){
		return type;
	}
	public int getProbability(int month){
		return probability[month];
	}
	public void action(Plants P){
//		int hp = P.getHp();
/*		if(P.getStatus().equals(type))
			P.setHp(0);
		else */
			P.setStatus(type);
	}
}