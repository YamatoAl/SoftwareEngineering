public class Equipment{
	private String name;
	private int price;
	private boolean exist;
	
	public Equipment(String n,int p, boolean e){
		name=n;
		price=p;
		exist=e;
	}
	
	public void setExist(boolean e){
		exist=e;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPrice(){
		return price;
	}
	
	public boolean getExist(){
		return exist;
	}
}