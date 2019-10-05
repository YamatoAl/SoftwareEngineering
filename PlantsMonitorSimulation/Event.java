import java.util.*;

class Event{
	private Typhoon typhoon;
	private Cold cold;
	private HeavyRain heavyRain;
	private Drought drought;
	private Pests pests;
	private Sick sick;
	private static final int NOTHING=0;
	private static final int TYPHOON=1;
	private static final int COLD=2;
	private static final int HEAVYRAIN=3;
	private static final int DROUGHT=4;
	private static final int PESTS=5;
	private static final int SICK=6;
	
	/*public int [] Random(int n){  //1到100產生隨機n個變數
		int[] array = new int[n];
		for (int a = 0; a < array.length; ++a) {
			int i = 0;
			pick:
			while (i == 0) {
				i = (int)(Math.random()*100+1);
				for (int b = 0; b < a; ++b) {
					if (array[b] == i) {
						i = 0;
						continue pick;
					}
				}
			array[a] = i;
			}
		}
		return array;
	}*/
	public Event(){
		typhoon=new Typhoon();
		cold=new Cold();
		heavyRain=new	HeavyRain();
		drought=new Drought();
		pests=new Pests();
		sick=new Sick();
	}
	
	public int disasterCheck(Date d,Item I){
		System.out.println("\n\n----------------------------------------");
		System.out.println("事件發生");
		int T = typhoon.getProbability(d.getMonth());
		int H = heavyRain.getProbability(d.getMonth());
		int D = drought.getProbability(d.getMonth());
		int P = pests.getProbability(d.getMonth());
		int C = cold.getProbability(d.getMonth());
		int S = sick.getProbability(d.getMonth());
		int total = T+H+D+P+C+S;	
		int[] array = new int[7];
		array[0]=0;
		array[1]=T;
		array[2]=T+H;
		array[3]=T+H+D;
		array[4]=T+H+D+P;
		array[5]=T+H+D+P+C;
		array[6]=T+H+D+P+C+S;
		int k = (int)(Math.random()*total+1);
		for(int i=0;i<6;i++){
			if(array[i]<k && array[i+1]>=k){
				if(i==0){
					System.out.println("颱風警報");
					return TYPHOON;
				}
				if(i==1){
					if(I.getPump().getExist()){
						System.out.println("靠著抽水機撐過了豪雨");
						return NOTHING;
					}
					else{
						System.out.println("豪雨侵襲");
						return HEAVYRAIN;
					}
				}
				if(i==2){
					System.out.println("乾旱襲來");
					return DROUGHT;
				}
				if(i==3){
					System.out.println("蟲群出現");
					return PESTS;
				}
				if(i==4){
					if(I.getGreenHouse().getExist()){
						System.out.println("靠著溫室撐過了寒流");
						return NOTHING;
					}
					else{
						System.out.println("寒流襲來");
						return COLD;
					}
				}
				if(i==5){
					System.out.println("傳染病發生");
					return SICK;
				}
			}
		}
		System.out.println("本月什麼事都沒有發生");
		return NOTHING;
	}
	
	public void disasterAction(Plants p,int i){
		if(i==1)
			typhoon.action(p);
		if(i==2)
			cold.action(p);
		if(i==3)
			heavyRain.action(p);
		if(i==4)
			drought.action(p);
		if(i==5)
			pests.action(p);
		if(i==6)
			sick.action(p);
		
	}
}
