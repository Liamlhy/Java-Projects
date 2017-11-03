
import java.util.Scanner; 
import java.io.File; 
import java.io.IOException; 
public class WordGenerator {

	int word;
	int sentence;
	Scanner text;

	/*This is a constructor for WordGenerator  */
	public WordGenerator(String filename) throws IOException
	{
		text= new Scanner(new File(filename));
	}

	/*
	 * Returns true iff the underlying Scanner of this WordGenerator has text left to process.
	 */

	public boolean hasNext(){
		return text.hasNext();
	}

	/* 
	 * Returns the next word of the underlying Scanner. 
	 * If the Scanner does not have words left. 
	 */

	public String next() { 
		word++;
		String next = text.next();
		if (next.charAt(next.length()-1) == '.'||next.charAt(next.length()-1)  == '?' ||next.charAt(next.length()-1)=='!' ){
			sentence++;
		}
		return next;
	}

	/*
	 *  Returns the number of words produced by the WordGenerator so far.
	 */

	public int getWordCount() throws IOException{
		return 	word; 
	}

	/*
	 *	Returns the number of sentences produced by the WordGenerator so far
	 */

	public int getSentenceCount() throws IOException{ 
		return sentence; 
	} 
}



