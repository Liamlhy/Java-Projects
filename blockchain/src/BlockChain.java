import java.security.NoSuchAlgorithmException;

public class BlockChain {
	public static class Node {
		public Block blk;
		public Node next;
		
		public Node(Block value, Node next){
			this.next = next;
			this.blk = value;
		}
	}
	
	private Node first;
	private Node last;
	
     /**
     * Constructor for first Node in BlockChain
     */
	public BlockChain(int initial) throws NoSuchAlgorithmException {
		if(initial < 0) {
			throw new IllegalArgumentException();
		}
		this.first = new Node(new Block(0, initial, null), null);
		this.last = first;
	}
    /**
     * Mines for nonce that produces valid hash
     */
	public Block mine(int amount) throws NoSuchAlgorithmException {
		return new Block(this.getSize(), amount, last.blk.getHash());
	}
	
	public int getSize() {
		return this.last.blk.getNum() + 1;
	}
     /**
     * Append Block to BlockChain if Block is valid 
     */
	public void append(Block blk) {
		Node temp = new Node(blk, null);
		this.last.next = temp;
		this.last = this.last.next;
	}
	
     /**
     * Removes last block in BlockChain if BlockChain has more than 1 Node
     */
	public boolean removeLast() {
		if(this.getSize() == 1) {
			return false;
		} else {
			Node temp = first;
			while(temp.next != last) {
				temp = temp.next;
			} 
			temp.next = null;
			last = temp;
			return true;
		}
	}
	
	public Hash getHash() {
		return last.blk.getHash();
	}
     /**
     * Checks if BlockChain is valid.
     */
	public boolean isValidBlockChain() {
		int annaAmount = first.blk.getAmount();
		int bobAmount = 0;
		Node temp1 = first.next;
		Node temp2 = first;
		while(temp1 != null) {
			if(bobAmount - temp1.blk.getAmount() < 0 && annaAmount + temp1.blk.getAmount() < 0) { 
				return false;
				}
			if(temp2.blk.getHash() != temp1.blk.getPrevHash()) { 
				return false; 
				}
			if(!temp1.blk.getHash().isValid()) { 
				return false; 
				}	
			annaAmount += temp1.blk.getAmount();
			bobAmount -= temp1.blk.getAmount();
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return true;
	}
     /**
     * Prints balances of Anna and Bob after transactions in BlockChain
     */
	public void printBalances() {
		int aliceAmount = first.blk.getAmount();
		int bobAmount = 0;
		Node temp = first.next;
		while(temp != null) {
			aliceAmount += temp.blk.getAmount();
			bobAmount -= temp.blk.getAmount();
			temp = temp.next;
		}
		System.out.println("Alice: " + aliceAmount + ", Bob: " + bobAmount); 
	}
     /**
     * Return A string containing every Block's information
     */
	public String toString() {
		String result = "";
		Node temp = first;
		for(int i = 0; i < this.getSize(); i++) {
			result += temp.blk.toString() + "\n";
			temp = temp.next;
		}
		return result;
	}
}
