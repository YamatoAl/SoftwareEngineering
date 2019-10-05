import java.util.Scanner;

class Pests{
	private String type="Pests";
	private int[] probability = {0,20,20,20,20,20,20,20,20,20,20,20,20};
	public Pests(){}
	public String getType(){
		return type;
	}
	public int getProbability(int month){
		return probability[month];
	}
	public void action(Plants P){
		int insect = P.getInsect();
		P.setInsect(insect-30);
	}
}