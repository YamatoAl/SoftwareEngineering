import java.util.*;

public class Item{
	private Consumables fertilizer;
	private Consumables pesticide;
	private Consumables drug;
	private Equipment greenHouse;
	private Equipment pump;
	private Equipment sprinklers;
	
	public Item(){
		fertilizer = new Consumables("fertilizer",5,0);
		pesticide = new Consumables("pesticide",5,0);
		drug = new Consumables("drug",50,0);
		greenHouse = new Equipment("Green House",500,false);
		pump = new Equipment("Pump",500,false);
		sprinklers = new Equipment("Sprinklers",1000,false);
	}
	
	public Item(int fc,int pc,int dc,boolean ge,boolean pe,boolean se){
		fertilizer = new Consumables("fertilizer",5,fc);
		pesticide = new Consumables("pesticide",5,pc);
		drug = new Consumables("drug",50,dc);
		greenHouse = new Equipment("Green House",500,ge);
		pump = new Equipment("Pump",500,pe);
		sprinklers = new Equipment("Sprinklers",1000,se);
	}
	
	public boolean useItem(Plants plants){
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\n----------------------------------------");
		System.out.println("選擇使用物品：");
		System.out.println("(1)肥料 剩餘:"+fertilizer.getCount());
		System.out.println("(2)殺蟲劑 剩餘:"+pesticide.getCount());
		System.out.println("(3)病藥 剩餘:"+drug.getCount());
		
		switch(sc.next()){
			case "1":
				if(fertilizer.getCount()>0){
					plants.setGround(plants.getGround()+30);
					fertilizer.setCount(fertilizer.getCount()-1);
					return true;
				}
				else{
					System.out.println("數量不足");
					return false;
				}
			case "2":
				if(pesticide.getCount()>0){
					plants.setInsect(plants.getInsect()+30);
					pesticide.setCount(pesticide.getCount()-1);
					return true;
				}
				else{
					System.out.println("數量不足");
					return false;
				}
			case "3":
				if(plants.getStatus().equals("sick") && drug.getCount()>0){
					plants.setStatus("health");
					System.out.println("植物痊癒了");
					drug.setCount(drug.getCount()-1);
					return true;
				}
				else if(plants.getStatus().equals("sick")){
					System.out.println("病藥數量不足");
					return false;
				}
				else{
					System.out.println("植物無生病");
					return false;
				}
			default:
				System.out.println("未選擇 返回行動頁面");
				return false;
		}
	}
	
	public boolean shop(Player p){
		int buy;
		
		System.out.println("\n----------------------------------------");
		System.out.println("商店 剩餘財產:"+p.getMoney());
		System.out.println("(1)購買肥料 $"+fertilizer.getPrice()+" 庫存:"+fertilizer.getCount());
		System.out.println("(2)購買殺蟲劑 $"+pesticide.getPrice()+" 庫存:"+pesticide.getCount());
		System.out.println("(3)購買病藥 $"+drug.getPrice()+" 庫存:"+drug.getCount());
		if(!greenHouse.getExist())System.out.println("(4)建設溫室 $"+greenHouse.getPrice());
		else System.out.println("(4)溫室 已購買");
		if(!pump.getExist())System.out.println("(5)建設抽水機 $"+pump.getPrice());
		else System.out.println("(5)抽水機 已購買");
		if(!sprinklers.getExist())System.out.println("(6)建設灑水器 $"+sprinklers.getPrice());
		else System.out.println("(6)灑水器 已購買");
		
		Scanner sc=new Scanner(System.in);
		switch(sc.next()){
			case "1":
				System.out.println("選擇購買數量(0~10):");
				buy=sc.nextInt();
				if(buy>10)buy=10;
				if(buy>0 && p.getMoney()>=fertilizer.getPrice()*buy){
					fertilizer.setCount(fertilizer.getCount()+buy);
					p.setMoney(p.getMoney()-fertilizer.getPrice()*buy);
					System.out.println("購買成功");
					return true;
				}
				else{
					System.out.println("購買失敗");
					return false;
				}
			case "2":
				System.out.println("選擇購買數量(0~10):");
				buy=sc.nextInt();
				if(buy>10)buy=10;
				if(buy>0 && p.getMoney()>=pesticide.getPrice()*buy){
					pesticide.setCount(pesticide.getCount()+buy);
					p.setMoney(p.getMoney()-pesticide.getPrice()*buy);
					System.out.println("購買成功");
					return true;
				}
				else{
					System.out.println("購買失敗");
					return false;
				}
			case "3":
				System.out.println("選擇購買數量(0~10):");
				buy=sc.nextInt();
				if(buy>10)buy=10;
				if(buy>0 && p.getMoney()>=drug.getPrice()*buy){
					drug.setCount(drug.getCount()+buy);
					p.setMoney(p.getMoney()-drug.getPrice()*buy);
					System.out.println("購買成功");
					return true;
				}
				else{
					System.out.println("購買失敗");
					return false;
				}
			case "4":
				if(greenHouse.getExist()==false && p.getMoney()>=greenHouse.getPrice()){
					greenHouse.setExist(true);
					p.setMoney(p.getMoney()-greenHouse.getPrice());
					System.out.println("購買成功");
					return true;
				}
				else{
					System.out.println("購買失敗");
					return false;
				}
			case "5":
				if(pump.getExist()==false && p.getMoney()>=pump.getPrice()){
					pump.setExist(true);
					p.setMoney(p.getMoney()-pump.getPrice());
					System.out.println("購買成功");
					return true;
				}
				else{
					System.out.println("購買失敗");
					return false;
				}
			case "6":
				if(sprinklers.getExist()==false && p.getMoney()>=sprinklers.getPrice()){
					sprinklers.setExist(true);
					p.setMoney(p.getMoney()-sprinklers.getPrice());
					System.out.println("購買成功");
					return true;
				}
				else{
					System.out.println("購買失敗");
					return false;
				}
			default:
				System.out.println("未進行消費");
				return false;
		}
	}
	
	public Consumables getFertilizer(){
		return fertilizer;
	}
	
	public Consumables getPesticide(){
		return pesticide;
	}
	
	public Consumables getDrug(){
		return drug;
	}
	
	public Equipment getGreenHouse(){
		return greenHouse;
	}
	
	public Equipment getPump(){
		return pump;
	}
	
	public Equipment getSprinklers(){
		return sprinklers;
	}
	
}