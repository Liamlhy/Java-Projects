
import java.util.Arrays;

public class Hash {
    private byte[] data;
    
    public Hash(byte[] data) { 
    	this.data = data; 
    	}
    
    public byte[] getData() { 
    	return this.data; 
    	}
    
    /**
     * Checks if hash is valid
     */
    public boolean isValid() {
        for(int i = 0; i < 3; i++) {
            if(this.data[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Converts hash to string of hexadecimal numbers
     */
    public String toString() {
        String str = "";
        for(int i = 0; i < this.data.length; i++) {
            str = str + String.format("%02X", Byte.toUnsignedInt(this.data[i]));
        }
        return str;
    }



    /**
     * Checks if this.hash is the same as other
     */
    public boolean equals(Object other) {
        if(other instanceof Hash) {
            Hash h = (Hash) other;
            return Arrays.equals(this.data, h.data);
        } 
        else {
            return false;
        }
    }
}