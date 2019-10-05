import java.io.*;
import java.util.*;
public class PMS
{
	public static void main(String[] args)throws Exception
	{
		String s;
		String name;
		String Patient_Period; 
		String device_cate;
		String device_name;
		String dataset;
		Double lower;
		Double upper;
		int monitor_period;
		List<List<String>> input = new ArrayList<List<String>>();
		Scanner inputStream = null;
		try
		{
			inputStream =
				new Scanner(new FileInputStream("input.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File morestuff.txt was not found");
			System.out.println("or could not be opened.");
			System.exit(0);
		}
		monitor_period = inputStream.nextInt();
		while(inputStream.hasNextLine()){
			List<String> aListData = new ArrayList<String>();
			aListData.add(inputStream.next());
			aListData.add(inputStream.next());
			aListData.add(inputStream.next());
			aListData.add(inputStream.next());
			aListData.add(inputStream.next());
			aListData.add(inputStream.next());
			aListData.add(inputStream.next());
			aListData.add(inputStream.next());
			input.add(aListData);
		}
		inputStream.close();
		for(int i=0;i<=monitor_period;i++){
			for(int j=0;j<input.size();j++){
				int patient = Integer.parseInt(input.get(j).get(2));
				Double Num=0.0;
				if(i%patient==0){
					Scanner inputStream2 = null;
					try
					{
						inputStream2 =
							new Scanner(new FileInputStream("BloodPressureDate1.txt"));
					}
					catch(FileNotFoundException e)
					{
						System.out.println("File was not found");
						System.out.println("or could not be opened.");
						System.exit(0);
					}
					for(int r=0;r<=(i/patient);r++){  
						Num=inputStream2.nextDouble();
					}
					lower = Double.parseDouble(input.get(j).get(6));
					upper = Double.parseDouble(input.get(j).get(7));
					if(Num<lower || Num>upper){
						if(Num!=-1.0)
							System.out.println("["+i+"] "+input.get(j).get(1)+ " is in danger! Cause: "+input.get(j).get(4)+" "+Num);
					}
					if(Num==-1.0){System.out.println("["+i+"] "+input.get(j).get(4)+" falls");}
					inputStream2.close();
				}
			}
		}
		
		for(int i=0;i<input.size();i++){
			System.out.println(input.get(i).get(0)+" "+input.get(i).get(1));
			System.out.println(input.get(i).get(3)+" "+input.get(i).get(4));
			Scanner inputStream1 = null;
			String file = input.get(i).get(5);
			try
			{
			//if(!file.equals("BloodPressureData1.txt"))	
				inputStream1 =
					new Scanner(new FileInputStream("BloodPressureDate1.txt"));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File was not found");
				System.out.println("or could not be opened.");
				System.exit(0);
			}
			int patient = Integer.parseInt(input.get(i).get(2));
			for(int j = 0;j<=monitor_period;j=j+patient){
				System.out.print("["+ j + "] ");
				Double d = inputStream1.nextDouble();
				System.out.printf("%.1f\n",d);
			}
			inputStream1.close();
		}
		
	}
}	
