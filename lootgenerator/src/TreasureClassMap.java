import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;





public class TreasureClassMap implements Map {
	//Initializes the Node class
	public class Node{
		public String tClass; 
		public String itemOne;
		public String itemTwo;
		public String itemThree;
		public Node next;
		public Node(String tClass, String itemOne, String itemTwo, String itemThree){
			this.tClass = tClass;
			this.itemOne = itemOne;
			this.itemTwo = itemTwo;
			this.itemThree = itemThree;
		}
	}
	Node map; 
	int size = 0;
	//Creates the map of the treasure class
	public TreasureClassMap(String tClass, String itemOne, String itemTwo, String itemThree){
		map = new Node(tClass, itemOne, itemTwo, itemThree);
		this.size++;
	}
	//Returns the size of the current map
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	//Determines whether the given key is in the current map
	public boolean containsKey(String key) {
		return containsKeyHelper(key, map);
	}
	public boolean containsKeyHelper(String name, Node curr){
		if(curr == null){
			return false;
		}
		else if(curr.tClass.equals(name)){
			return true;
		}
		return containsKeyHelper(name, curr.next);
	}
	//Determines whether the given value is in the current map
	public boolean containsValue(String value) {
		return containsValueHelper(value, map);
	}
	public boolean containsValueHelper(String value, Node curr){
		if(curr == null){
			return false;
		}
		else if(curr.itemOne.equals(value) || curr.itemTwo.equals(value) || curr.itemThree.equals(value)){
			return true;
		}
		return containsKeyHelper(value, curr.next);
	}
	//Returns the value of the given key
	public String get(String key) {
		return getHelper(key, map);
	}
	public String getHelper(String key, Node curr){
		Random rand = new Random();
		if(curr == null){
			return null;
		}
		else if(curr.tClass.equals(key)){
			int randomItem = rand.nextInt(3);
			if(randomItem == 0){
				return curr.itemOne;
			}
			else if(randomItem == 1){
				return curr.itemTwo;
			}
			else if(randomItem == 2){
				return curr.itemThree;
			}
		}
		return getHelper(key, curr.next);
	}
	//Puts a new treasure object into the current map
	public Object put(String key, String valueOne, String valueTwo, String valueThree) {
		this.size++;
		putHelper(key, valueOne, valueTwo, valueThree, map);
		return null;
	}
	public void putHelper(String tClass, String itemOne, String itemTwo, String itemThree, Node curr){
		if(curr == null){
			curr = new Node(tClass, itemOne, itemTwo, itemThree);
		}
		else if(curr.next == null){
			curr.next = new Node(tClass, itemOne, itemTwo, itemThree);
		}
		else{
			putHelper(tClass, itemOne, itemTwo, itemThree, curr.next);
		}
	}

	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getOrDefault(Object key, Object defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}
	public void forEach(BiConsumer action) {
		// TODO Auto-generated method stub
		
	}
	public void replaceAll(BiFunction function) {
		// TODO Auto-generated method stub
		
	}
	public Object putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean remove(Object key, Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean replace(Object key, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		return false;
	}
	public Object replace(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object computeIfAbsent(Object key, Function mappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object computeIfPresent(Object key, BiFunction remappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object compute(Object key, BiFunction remappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object merge(Object key, Object value, BiFunction remappingFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}


}
