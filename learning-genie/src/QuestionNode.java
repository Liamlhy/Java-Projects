import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuestionNode implements DecisionNode{
	public String question;
	public DecisionNode yes;
	public DecisionNode no;
	/**
	 * Constructs a QuestionNode with a given question, yes node and no node
	 * @param question, a String
	 * @param yes, a DecisionNode
	 * @param no, a DecisionNode
	 */
	public QuestionNode(String question, DecisionNode yes, DecisionNode no) {
		this.question = question;
		this.yes = yes;
		this.no = no;
	}
	/**
	 * Counts the number of guessNodes in the tree
	 * return an integer, which is the number of the guess nodes in the tree
	 */
	public int countObjects() {
		return this.yes.countObjects() + this.no.countObjects();
	}
	/**
	 * Performs the guessing game starting at this node using the given Scanner object to query the user for input
	 * If the user answers yes to the question, go to the yes Node and play the game from that Node by calling the guess method
	 * If the user answers no to the question, go to the no Node and play the game from that Node by calling the guess method
	 * return a DecisionNode, an updated node that is the result of knowledge learned during the game
	 */
	public DecisionNode guess(Scanner in) {
		System.out.print(this.question);
		String userAnswer = in.nextLine().toLowerCase();
		if(userAnswer.equals("yes")) {
			this.yes = this.yes.guess(in);
		}else if (userAnswer.equals("no")) {
			this.no = this.no.guess(in);
		}else {
			System.out.println("Please entre either yes or no");
			return this;
		}
		return this;
	}
	/**
	 * Writes this node in the serialized format described above to the given file represented by a FileWriter object.
	 */
	public void write(FileWriter out) throws IOException {
		out.write("#" + this.question + "\n");
		this.yes.write(out);
		this.no.write(out);
	}

}
