import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class LootGenerator {
	public static void main(String[] args) throws FileNotFoundException{
		File armorFile = new File("/home/eggejasp/workspace/work/LootGenerator/src/data/large/armor.txt");
		File monsterFile = new File("/home/eggejasp/workspace/work/LootGenerator/src/data/large/monstats.txt");
		File treasureFile = new File("/home/eggejasp/workspace/work/LootGenerator/src/data/large/TreasureClassEx.txt");
		File prefixFile = new File("/home/eggejasp/workspace/work/LootGenerator/src/data/large/MagicPrefix.txt");
		File suffixFile = new File("/home/eggejasp/workspace/work/LootGenerator/src/data/large/MagicSuffix.txt");
		

		Scanner armorScanner = new Scanner(armorFile);
		Scanner monsterScanner = new Scanner(monsterFile);
		Scanner treasureScanner = new Scanner(treasureFile);
		Scanner prefixScanner = new Scanner(prefixFile);
		Scanner suffixScanner = new Scanner(suffixFile);
		Scanner userScanner = new Scanner(System.in);
		
		MonsterMap monsters = null;
		TreasureClassMap treasures = null;
		BaseStatsMap baseStats = null;
		AffixMap prefixes = null;
		AffixMap suffixes = null;
		
		String response = "other";
		boolean keepGoing = true;
		String prefix = null;
		String suffix = null;
		
		Random rand = new Random();
		
		while(monsterScanner.hasNextLine()){
			String line = monsterScanner.nextLine();
			String[] parts = line.split("\t", 4);
			String name = parts[0];
			String type = parts[1];
			int level = Integer.parseInt(parts[2]);
			String tClass = parts[3];
			if(monsters == null){
				monsters = new MonsterMap(name, type, level, tClass);
			}
			else{
				monsters.put(name,  type, level, tClass);
			}
		}
		while(treasureScanner.hasNextLine()){
			String line = treasureScanner.nextLine();
			String[] parts = line.split("\t", 4);
			String tClass = parts[0];
			String itemOne = parts[1];
			String itemTwo = parts[2];
			String itemThree = parts[3];
			if(treasures == null){
				treasures = new TreasureClassMap(tClass,  itemOne, itemTwo, itemThree);
			}
			else{
				treasures.put(tClass,  itemOne, itemTwo, itemThree);
			}
		}
		while(armorScanner.hasNextLine()){
			String line = armorScanner.nextLine();
			String[] parts = line.split("\t", 3);
			String name = parts[0];
			int minac = Integer.parseInt(parts[1]);
			int maxac = Integer.parseInt(parts[2]);
			if(baseStats == null){
				baseStats = new BaseStatsMap(name, minac, maxac);
			}
			else{
				baseStats.put(name, minac, maxac);
			}
		}
		while(prefixScanner.hasNextLine()){
			String line = prefixScanner.nextLine();
			String[] parts = line.split("\t", 4);
			String name = parts[0];
			String min1code = parts[1];
			int minac = Integer.parseInt(parts[2]);
			int maxac = Integer.parseInt(parts[3]);
			if(prefixes == null){
				prefixes = new AffixMap(name,  min1code, minac, maxac);
			}
			else{
				prefixes.put(name,  min1code, minac, maxac);
			}
		}
		while(suffixScanner.hasNextLine()){
			String line = suffixScanner.nextLine();
			String[] parts = line.split("\t", 4);
			String name = parts[0];
			String min1code = parts[1];
			int minac = Integer.parseInt(parts[2]);
			int maxac = Integer.parseInt(parts[3]);
			if(suffixes == null){
				suffixes = new AffixMap(name,  min1code, minac, maxac);
			}
			else{
				suffixes.put(name,  min1code, minac, maxac);
			}
		}
		while(keepGoing){
			String currentMonster = pickMonster(monsters);
			System.out.println("Fighting " + currentMonster);
			System.out.println("You have slain " + currentMonster);
			System.out.println(currentMonster + " dropped:");
			System.out.println();
			
			String treasureClass = fetchTreasureClass(monsters, currentMonster);
			String armor = generateBaseItem(treasures, treasureClass, currentMonster);

			if(rand.nextInt(2) == 0){
				prefix = generateAffix(prefixes);
			}
			if(rand.nextInt(2) == 0){
				suffix = generateAffix(suffixes);
			}
			
			if(prefix != null){
				System.out.print(prefix + " ");
			}
			System.out.print(armor + " ");
			if(suffix != null){
				System.out.print(suffix);
			}
			System.out.println();
			
			int defense = generateBaseStats(baseStats, armor);
			System.out.println("Defense: " + defense);
			
			int strength = 0;
			if(prefix != null){
				strength += prefixes.get(prefix);
			}
			if(suffix != null){
				strength += suffixes.get(suffix);
			}
			
			System.out.println(strength + " Strength");
			while(!response.equals("y") && !response.equals("n")){
				System.out.println("Fight again? [y/n]");
				response = userScanner.next();
				
				if(response.toLowerCase().equals("n")){
					keepGoing = false;
				}
				else if(!response.toLowerCase().equals("y")){
					System.out.println("Please enter a valid input.");
				}
			}
			prefix = null;
			suffix = null;
			response = "other";
		}
			
	}
	//Picks the monster that the user is about to fight
	public static String pickMonster(MonsterMap monsters){
		Random rand = new Random();
		int randomValue = rand.nextInt(monsters.size());
		return monsters.getNumber(randomValue);
	}
	//Fetches the treasure class of the current monster
	public static String fetchTreasureClass(MonsterMap monsters, String currentMonster){
		return monsters.get(currentMonster);
	}
	//Generates the item that the slain monster drops
	public static String generateBaseItem(TreasureClassMap treasures,  String treasureClass, String currentMonster){
		while(treasures.containsKey(treasureClass)){
			treasureClass = treasures.get(treasureClass);
		}
		return treasureClass;
	}
	//Generates the stats of the item dropped by the monster
	public static int generateBaseStats(BaseStatsMap baseStats, String armor){
		return baseStats.get(armor);
	}
	//Generates the affix(prefix or suffix) of the dropped item 
	public static String generateAffix(AffixMap affixes){
		Random rand = new Random();
		return affixes.getNumber(rand.nextInt(affixes.size));
	}
}
