import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LearningGenie {
	/**
	 * The engine of the program that starts the game with the user
	 * @param args, the command-line arguments for the main function (which is not needed in this program)
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("Data.txt");
		Scanner in = new Scanner(System.in);
		DecisionTree learningGenie = new DecisionTree(file);
		FileWriter out = new FileWriter(file);
		System.out.println("I am the learning genie!");
		System.out.println("I can figure out whatever you are thinking of by asking questions.");
		System.out.println("I know " + learningGenie.countObjects() + " thing!");
		String userChoiceToContinue = "yes";
		while (userChoiceToContinue.equals("yes")) {
			System.out.println("Think of a food!");
			learningGenie.guess(in);
			System.out.println("Do you want to continue? ");
			userChoiceToContinue = in.nextLine().toLowerCase();	
		}
		learningGenie.write(out);
		out.close();
	}
}
