import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PlantsMonitorSimulation
{
	private static Scanner sc = new Scanner(System.in);
	private static Player player;
	private static Date date;
	private static Plants plants;
	private static PlantsSpec spec;
	private static Item item;
	private static Game game;
	
	public static void main(String[] args)
	{
		while (true)
		{
			System.out.printf("\nPlants Monitor Simulation\n\nMain Menu\n\n    0 - Exit\n    1 - New Game\n    2 - Load Game\n\n" +                  "Please Enter a Choice: ");
			
			int choice = sc.nextInt();
			
			if (choice == 0)
				return;
			else if (choice == 1)
				newGame();
			else if (choice == 2)
				loadGame("GameSave.txt");
		}
	}
	
	public static void newGame()
	{
		System.out.printf("\nInput Your ID: ");
		String playerID = sc.next();
		player = new Player(playerID); // 10000 is initial money
//		System.out.println("Player(Object) " + player);
		game = new Game(player);
		game.gameplay();
	}
	
	public static void loadGame(String filename)
	{
		// Load Game
		BufferedReader br = null;
		String text = "";
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null)
				text += line + " ";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//		System.out.println("\nRead From " + filename + "\n" + text);
		
		String[] tokens = text.split("\\s");
		player = new Player(tokens[0], Integer.parseInt(tokens[1]));
		date = new Date(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), tokens[4]);
		spec = new PlantsSpec("Default",100,100,100,100,200,100,0,0,0);
		plants = new Plants(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]), 
		                    Integer.parseInt(tokens[9]), tokens[10], Integer.parseInt(tokens[11]), spec);
		item = new Item(Integer.parseInt(tokens[13]), Integer.parseInt(tokens[14]), Integer.parseInt(tokens[15]),
						tokens[16].equals("true"), tokens[17].equals("true"), tokens[18].equals("true"));
		
//		System.out.println("Player(Object) " + player + "\nDate(Object) " + date + "\nPlants(Object) " + plants);
		game = new Game(player, date, plants, tokens[12], item);
		game.gameplay();
	}
}