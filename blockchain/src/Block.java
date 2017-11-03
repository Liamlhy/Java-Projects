import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	private int num;
	private int amount;
	private Hash prevHash;
	private long nonce;
	private Hash hash;

	/**
	 * Constructor for Block (without nonce)
	 */
	public Block(int num, int amount, Hash prevHash) throws NoSuchAlgorithmException {
		this.num = num;
		this.amount = amount;
		this.prevHash = prevHash;
		long n = -1;
		do { n++;
			this.hash = calculateHash(this.num, this.amount, n, this.prevHash);
			 }while(!this.hash.isValid());
		this.nonce = n;
		
	}
	/**
	 * Generates hash based on Block data
	 */
	public static Hash calculateHash(int num, int amount, long nonce, Hash prevHash) throws NoSuchAlgorithmException {
		Hash h = null;
		 MessageDigest md = MessageDigest.getInstance("sha-256");
		 md.update(ByteBuffer.allocate(4).putInt(num).array());
         md.update(ByteBuffer.allocate(4).putInt(amount).array());
         if(prevHash != null) {
             md.update(prevHash.getData());
         }
         md.update(ByteBuffer.allocate(8).putLong(nonce).array());
         h = new Hash(md.digest()); 
         return h;
	}

	/**
	 * Constructor for Block (with given nonce)
	 */
	public Block(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException {
		this.num = num;
		this.amount = amount;
		this.prevHash = prevHash;
		this.nonce = nonce;
		this.hash = calculateHash(this.num, this.amount, this.nonce, this.prevHash);  
	}

	public int getNum() { 
		return this.num;
	}

	public int getAmount( ) { 
		return this.amount;
	}

	public long getNonce() {
		return this.nonce;
	}

	public Hash getPrevHash() {
		return this.prevHash;
	}

	public Hash getHash() {
		return this.hash;
	}

	public String toString() {
		String str = "Block "; 
		str = str + num + "(Amount: " + amount + ", Nonce: " + nonce +
				", preHash: " + prevHash + ", hash " + hash + ")"; 
		return str;
	}
}