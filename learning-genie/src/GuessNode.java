import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuessNode implements DecisionNode{
	public String guess;
	public int count;
	/**
	 * Constructs a GuessNode with the given string
	 * @param guess, a string to be recorded in the GuessNode
	 */
	public GuessNode(String guess) {
		this.guess = guess;
		count = 1;
	}
	/**
	 * Counts the number of objects this decision tree records
	 * @return an integer
	 */
	public int countObjects() {
		return count;
	}
	/**
	 * Performs the guessing game starting at this node using the given Scanner object to query the user for input
	 * If the user's guess matches the string stored in the current node, the node stays the same
	 * If the user's guess does not match the string stored in the current node, the node is reassigned to a new QuestionNode
	 * that has the distinguishing question got from the user, a GuessNode that contains the current object and a GuessNode
	 * that contains the object the user guesses
	 * @param in, a Scanner to take in user inputs
	 * @return a DecisionNode, that is an updated node that is the result of any knowledge learned during the game
	 */
	public DecisionNode guess(Scanner in) {
		System.out.println("Are you thinking of " + guess + "?");
		String userInput = in.nextLine().toLowerCase();
		if (userInput.equals("yes")) {
			System.out.println("Excellent, thanks!");
		}else if (userInput.equals("no")){
			System.out.println("What food are you thinking of?");
			String userGuess = in.nextLine();
			System.out.println("What is a yes/no question that distinguishes a " + this.guess + " from a " + userGuess + " ?");
			System.out.print("(Yes corresponds to " + this.guess + "; No corresponds to " + userGuess + ")");
			String userQuestion = in.nextLine();
			System.out.println("Thanks! I'll learn from this experience!");
			return new QuestionNode(userQuestion, new GuessNode(guess), new GuessNode(userGuess));
		}else {
			System.out.println("Please enter either yes or no");
		}
		return this;
	}
	/**
	 * Writes the current node in the serialized format described above to the given file represented by a FileWriter object
	 * @param out, a FileWriter that performs writing to the file
	 */
	public void write(FileWriter out) throws IOException {
		out.write(this.guess + "\n");
	}

}
