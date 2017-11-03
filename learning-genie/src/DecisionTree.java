import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DecisionTree {
	DecisionNode root;

	/**
	 *  Constructs a decision tree with an initial guess node containing Dog
	 */
	public DecisionTree() {
		root = new GuessNode("Spinach");
	}
	/**
	 * Helper Method for constructing a decision tree stored in a serialized form in the given file
	 * @param fl a scanner that gets lines from a file
	 * @return a DecisionNode that will be assigned to root
	 */
	public DecisionNode treeHelper(Scanner fl) {
		if (fl.hasNextLine()) {
			String cur = fl.nextLine();
			if(cur.startsWith("#")) {
				return new QuestionNode(cur.substring(1), treeHelper(fl), treeHelper(fl));
			}else {
				return new GuessNode(cur);
			}
		}
		return new GuessNode("Spinach");
	}
	/**
	 * Constructs a decision tree stored in a serialized form in the given file
	 * @param file a file
	 * @throws FileNotFoundException
	 */
	public DecisionTree(File file) throws FileNotFoundException {
		Scanner fl = new Scanner(file);
		root = treeHelper(fl);
		fl.close();
	}
	/**
	 * Counts the number of guess nodes in the tree
	 * @return an integer, which is the number of guess nodes in the tree
	 */
	public int countObjects() {
		return root.countObjects();
	}
	/**
	 * Performs the guessing game starting at the root of this decision tree using the given Scanner object to query the user for input
	 * Also modifies the decision tree if the genie learns any additional information in playing the game
	 * @param in a Scanner that takes input from the user
	 */
	public void guess(Scanner in) {
		root = root.guess(in);
	}
	/**
	 * Writes this decision tree in the serialized format described above to the given file
	 * @param out a FileWriter that writes to the given file
	 * @throws IOException
	 */
	public void write(FileWriter out) throws IOException {
		root.write(out);
	}
}
