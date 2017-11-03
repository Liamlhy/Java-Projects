import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class BlockChainDriver {

	public static void main (String args []) throws NumberFormatException, NoSuchAlgorithmException {
		BlockChain bc = new BlockChain(Integer.parseInt(args[0]));
		Scanner s = new Scanner(System.in);
		while (true){
			System.out.print(bc.toString());
			System.out.print("Command? ");
			String input = s.nextLine();	
			if (input.equals("quit")){
				return;
			}
			else if (input.equals("mine")) {
			System.out.print("Amount transferred? ");
			String amount = s.nextLine();
			Long nonce = bc.mine(Integer.parseInt(amount)).getNonce();
			System.out.println("amount = " + Integer.parseInt(amount) + 
								", nonce = " + nonce);
			System.out.println();
		}
		else if (input.equals("append")) {
			System.out.print("Amount transferred? ");
			String amount = s.nextLine();
			System.out.print("Nonce? ");
			String nonce = s.nextLine();
			bc.append(new Block (bc.getSize(), Integer.parseInt(amount), bc.getHash(),Long.parseLong(nonce)));
			System.out.println();
		} 
		else if (input.equals("remove")) {
			bc.removeLast();
			if(bc.isValidBlockChain()) {
            		System.out.println("Remove succeeds!");
          		} 
			else {
             		System.out.println("Remove fails!");
          		}
			System.out.println();
		}
		else if (input.equals("check")) {
			if (bc.isValidBlockChain()) {
				System.out.println("Chain is valid!");
			}
			else {
				System.out.println("Chain is not valid!");
			}
			System.out.println();
		}
		else if (input.equals("report")) {
			bc.printBalances();
			System.out.println();
		}
		else if (input.equals("help")) {
			System.out.println("Valid commands:");
            System.out.println("mine: discovers the nonce for a given transaction");
            System.out.println("append: appends a new block onto the end of the chain");
            System.out.println("remove: removes the last block from the end of the chain");
            System.out.println("check: checks that the block chain is valid");
            System.out.println("report: reports the balances of Alice and Bob");
            System.out.println("help: prints this list of commands");
            System.out.println("quit: quits the program");
            System.out.println();
		}
		else if (input.equals("quit")) {
			return;
		}
		else {
			System.out.println("Invalid input!");
		}
		}
}
}
