public class Consumables{
	private String name;
	private int price;
	private int count;
	
	public Consumables(String n,int p, int c){
		name=n;
		price=p;
		count=c;
	}
	
	public void setCount(int c){
		count=c;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public int getCount(){
		return count;
	}
}