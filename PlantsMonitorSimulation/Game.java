import java.util.*;
import java.lang.*;
import java.io.*;

public class Game{
	
	private static final int BASEHP=100,BASEWATER=100,BASEGROUND=100,BASEINSECT=100,BASEGROWTH=5,BASEWEEDS=100,BASESEED=10,BASESOLD=100;
	private static final int NOHOUSE=0,YESHOUSE=1,NEEDHOUSE=2;
	private static final int ROUNDINMONTH=4,POINTINROUND=2;
	private int actionPoint;
	private Player player;
	private Date date;
	private Event event;
	private Plants plants;
	private Item item;
	/*Name,maxHp,maxWater,maxGround,maxInsect,maxGrowth,maxWeeds,seedPrice,soldPrice,houseType*/
	private PlantsSpec corn=new PlantsSpec("Corn",BASEHP,BASEWATER-20,BASEGROUND,BASEINSECT,BASEGROWTH*6,BASEWEEDS,BASESEED*3,BASESOLD*3,NOHOUSE);
	private PlantsSpec potato=new PlantsSpec("Potato",BASEHP,BASEWATER,BASEGROUND-20,BASEINSECT,BASEGROWTH*6,BASEWEEDS,BASESEED*3,BASESOLD*3,NOHOUSE);
	private PlantsSpec radish=new PlantsSpec("Radish",BASEHP-10,BASEWATER-20,BASEGROUND-20,BASEINSECT-10,BASEGROWTH*8,BASEWEEDS-10,BASESEED*5,BASESOLD*5,NOHOUSE);
	private PlantsSpec cabbage=new PlantsSpec("Cabbage",BASEHP-20,BASEWATER-30,BASEGROUND-20,BASEINSECT-30,BASEGROWTH*10,BASEWEEDS-20,BASESEED*10,BASESOLD*10,YESHOUSE);
	private PlantsSpec strawberry=new PlantsSpec("Strawberry",BASEHP-30,BASEWATER-30,BASEGROUND-30,BASEINSECT-30,BASEGROWTH*12,BASEWEEDS-30,BASESEED*15,BASESOLD*15,YESHOUSE);
	private PlantsSpec orchid=new PlantsSpec("Orchid",BASEHP-50,BASEWATER-50,BASEGROUND-50,BASEINSECT-50,BASEGROWTH*15,BASEWEEDS-50,BASESEED*30,BASESOLD*30,NEEDHOUSE);
	private boolean exitCheck=false;
	private static final int WATERPLUS=10;
	private static final int GROUNDPLUS=10;
	private static final int INSECTPLUS=10;
	private static final int WEEDPLUS=10;
	private static final int MINSEEDPRICE=BASESEED*3;
	private static final int MINUSHP=0,MINUSWATER=-5,MINUSGROUND=-5,MINUSINSECT=-5,GROWTHPLUS=5,MINUSWEEDS=-5;
	
	public Game(Player p){
		this.player=p;
		this.date=new Date();
		this.plants=new Plants(0,0,0,0,0,null,0,corn);
		this.item=new Item();
		this.event=new Event();
	}
	
	public Game(Player p,Date d,Plants pt,Item i){
		this.player=p;
		this.date=d;
		this.plants=pt;
		this.item=i;
		this.event=new Event();
	}
	
	public Game(Player p,Date d,Plants pt,String sp,Item i){
		this.player=p;
		this.date=d;
		switch(sp){
			case "Corn":
				pt.setSpec(corn);
				break;
			case "Potato":
				pt.setSpec(potato);
				break;
			case "Radish":
				pt.setSpec(radish);
				break;
			case "Cabbage":
				pt.setSpec(cabbage);
				break;
			case "Strawberry":
				pt.setSpec(strawberry);
				break;
			case "Orchid":
				pt.setSpec(orchid);
				break;
			default:
				System.out.println("Error: PlantsSpec Not Found!");
		}
		this.plants=pt;
		this.item=i;
		this.event=new Event();
	}
	
	public void gameplay(){
		for(;;){
			save();
			for(actionPoint=POINTINROUND;actionPoint>0;){
				if(deadCheck()){
					seeding();
				}
				displayPlayer();
				displayPlants();
				action();
				if(exitCheck)break;
			}
			if(exitCheck)break;
			if(plants.getStatus().equals("typhoon")){
				int k = (int)(Math.random()*100+1);			//1到100隨機找一個數字
				if(k<=50){
					plants.setHp(0);
					System.out.println("\n颱風侵襲");
				}
				else{
					System.out.println("\n颱風預報失準");
					plants.setStatus("health");
				}
			}
			else if(plants.getStatus().equals("sick")){
				plants.setHp(0);
				System.out.println("\n傳染病肆虐了你的植物");
			}
			round();
//			System.out.println("--------------------\n");
			
			if(deadCheck()){
				System.out.println("\n你的植物已經死了");
			}
		}
	}
	
	public void save(){
		
		try{
			
			FileWriter fw = new FileWriter("GameSave.txt");
		
			fw.write(player.getID()+" "+player.getMoney()+" "+date.getMonth()+" "+date.getRound()+" "+date.getWeather()+" "+plants.getHp()+" "+plants.getWater()+" "+plants.getGround()+" "+plants.getInsect()+" "+plants.getGrowthRate()+" "+plants.getStatus()+" "+plants.getWeeds()+" "+plants.getSpec().getType()+" "+item.getFertilizer().getCount()+" "+item.getPesticide().getCount()+" "+item.getDrug().getCount()+" "+item.getGreenHouse().getExist()+" "+item.getPump().getExist()+" "+item.getSprinklers().getExist());
			fw.flush();
			fw.close();
		}
		catch(java.io.IOException ex) {
			ex.printStackTrace() ;
		}

	}
	
	public void displayPlayer(){
		System.out.println("\n\n----------------------------------------");
		System.out.println("ID:"+player.getID()+" $:"+player.getMoney()+" "+date.getMonth()+"月第"+date.getRound()+"/"+ROUNDINMONTH+"回合 "+date.getWeather());
	}
	
	public void displayPlants(){
		System.out.println("----------------------------------------");
		System.out.println("植物現況:");
		System.out.println(plants.getSpec().getType());
		System.out.println("HP:"+plants.getHp()+"/"+plants.getSpec().getMaxHp()+" 水分:"+plants.getWater()+"/"+plants.getSpec().getMaxWater());
		System.out.println("肥沃度:"+plants.getGround()+"/"+plants.getSpec().getMaxGround()+" 蟲害:"+plants.getInsect()+"/"+plants.getSpec().getMaxInsect());
		System.out.println("雜草量:"+plants.getWeeds()+"/"+plants.getSpec().getMaxWeeds()+" 成長進度:"+plants.getGrowthRate()+"/"+plants.getSpec().getMaxGrowthRate());
		System.out.print("狀態:");
		if(plants.getStatus().equals("health"))System.out.println("健康");
		else System.out.println(plants.getStatus());
	}
	
	public void action(){
		Scanner keyin=new Scanner(System.in);
		
		System.out.println("----------------------------------------");
		System.out.println("剩餘行動點數:"+actionPoint);
		System.out.println("(1)澆水 (2)施肥 (3)除蟲");
		System.out.println("(4)除草 (5)收穫 (6)商店");
		System.out.println("(7)使用物品 (8)睡覺 (9)離開");
		
		switch(keyin.next()){
			case "1":
				watering();
				break;
			case "2":
				fertilizer();
				break;
			case "3":
				insecticide();
				break;
			case "4":
				weeding();
				break;
			case "5":
				harvest();
				break;
			case "6":
				if(item.shop(player))actionPoint--;
				break;
			case "7":
				if(item.useItem(plants))actionPoint--;
				break;
			case "8":
				sleep();
				break;
			case "9":
				exitCheck=true;
				break;
			default:
				System.out.println("未尋獲選項");
				break;
		}
	}
	
	public void watering(){
		
		if(item.getSprinklers().getExist())plants.setWater(plants.getWater()+WATERPLUS*2);
		else plants.setWater(plants.getWater()+WATERPLUS);
		actionPoint--;
	}
	
	public void fertilizer(){

		plants.setGround(plants.getGround()+GROUNDPLUS);
		actionPoint--;
		System.out.println("植物肥沃度上升");
	}
	
	public void insecticide(){
		
		plants.setInsect(plants.getInsect()+INSECTPLUS);
		actionPoint--;
	}
	
	public void weeding(){
		
		plants.setWeeds(plants.getWeeds()+WEEDPLUS);
		actionPoint--;
	}
	
	public void harvest(){
		if(plants.getGrowthRate()==plants.getSpec().getMaxGrowthRate()){
			player.setMoney(player.getMoney()+plants.getSpec().getSoldPrice());
			plants.setHp(0);
			actionPoint=0;
			seeding();
		}
		else System.out.println("作物還未成長完畢");
	}
	
	public void seeding(){
		Scanner keyin=new Scanner(System.in);
		if(player.getMoney()<MINSEEDPRICE){
			System.out.println("你已經破產了!");
			exitCheck=true;
		}
		else{
			System.out.println("\n----------------------------------------");
			System.out.println("目前財產:$"+player.getMoney());
			System.out.println("選擇新的作物類型：");
			System.out.println("(1)Corn $"+corn.getSeedPrice());
			System.out.println("(2)Potato $"+potato.getSeedPrice());
			System.out.println("(3)Radish $"+radish.getSeedPrice());
			System.out.println("(4)Cabbage $"+cabbage.getSeedPrice());
			System.out.println("(5)Strawberry $"+strawberry.getSeedPrice());
			System.out.println("(6)Orchid $"+orchid.getSeedPrice());
			
			for(;plants.getHp()<=0;){
				switch(keyin.next()){
					case "1":
						if(player.getMoney()>corn.getSeedPrice()){
							plants=new Plants(corn);
							player.setMoney(player.getMoney()-corn.getSeedPrice());
						}
						else System.out.println("財產不足");
						break;
					case "2":
						if(player.getMoney()>potato.getSeedPrice()){
							plants=new Plants(potato);
							player.setMoney(player.getMoney()-potato.getSeedPrice());
						}
						else System.out.println("財產不足");
						break;
					case "3":
						if(player.getMoney()>radish.getSeedPrice()){
							plants=new Plants(radish);
							player.setMoney(player.getMoney()-radish.getSeedPrice());
						}
						else System.out.println("財產不足");
						break;
					case "4":
						if(player.getMoney()>cabbage.getSeedPrice()){
							plants=new Plants(cabbage);
							player.setMoney(player.getMoney()-cabbage.getSeedPrice());
						}
						else System.out.println("財產不足");
						break;
					case "5":
						if(player.getMoney()>strawberry.getSeedPrice()){
							plants=new Plants(strawberry);
							player.setMoney(player.getMoney()-strawberry.getSeedPrice());
						}
						else System.out.println("財產不足");
						break;
					case "6":
						if(player.getMoney()>orchid.getSeedPrice()){
							plants=new Plants(orchid);
							player.setMoney(player.getMoney()-orchid.getSeedPrice());
						}
						else System.out.println("財產不足");
						break;
					default:
						System.out.println("未尋獲選項");
						break;
				}
			}
		}
	}
	
	public void sleep(){
		actionPoint=0;
	}
	
	public void round(){

		date.next();
		plants.roundChange(MINUSHP,MINUSWATER,MINUSGROUND,MINUSINSECT,GROWTHPLUS,MINUSWEEDS);
		if(date.getRound()==1 && !deadCheck()){
			event.disasterAction(plants,event.disasterCheck(date,item));
		}
	}
	
	public boolean deadCheck(){
		if(plants.getHp()<=0 || plants.getWater()<=0 || plants.getInsect()<=0 || plants.getWeeds()<=0 || plants.getGround()<=0 /*|| plants.getStatus().equals("sick")*/) {
			plants.setHp(0);
			return true; //dead
		}
		else return false; //alive
	}
}