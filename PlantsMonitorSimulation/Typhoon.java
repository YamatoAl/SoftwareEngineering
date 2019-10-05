import java.util.Scanner;

class Typhoon{
	private String type="typhoon";
	private int[] probability = {0,1,1,2,3,4,6,15,20,20,14,8,4};
	public Typhoon(){}
	public String getType(){
		return type;
	}
	public int getProbability(int month){
		return probability[month];
	}
	public void action(Plants P){
/*		if(P.getStatus().equals(type)){
			int k = (int)(Math.random()*100+1);			//1到100隨機找一個數字
			if(k<=50)
				P.setHp(0);
		}
		else*/
			P.setStatus(type);
	}
}