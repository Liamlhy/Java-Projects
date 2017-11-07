import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;





public class BaseStatsMap implements Map {
	//Initializes the Node class
	public class Node{
		public String name; 
		public int minac;
		public int maxac;
		public Node next;
		public Node(String name, int minac, int maxac){
			this.name = name;
			this.minac = minac;
			this.maxac = maxac;
		}
	}
	Node map; 
	int size = 0;
	//Creates the map of the base stats
	public BaseStatsMap(String name, int minac, int maxac){
		map = new Node(name, minac, maxac);
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
		else if(curr.name.equals(name)){
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
		else if(curr.name.equals(value)){
			return true;
		}
		return containsKeyHelper(value, curr.next);
	}
	//Returns the value of the given key
	public int get(String key) {
		return getHelper(key, map);
	}
	public int getHelper(String key, Node curr){
		Random rand = new Random();
		if(curr == null){
			System.out.println("hi");
			return -1;
		}
		else if(curr.name.equals(key)){
			return rand.nextInt((curr.maxac - curr.minac) + 1) + curr.minac;
		}
		return getHelper(key, curr.next);
	}
	//Puts a new baseStats object into the current map
	public Object put(String key, int minac, int maxac) {
		this.size++;
		putHelper(key, minac, maxac, map);
		return null;
	}
	public void putHelper(String name, int minac, int maxac, Node curr){
		if(curr == null){
			curr = new Node(name, minac, maxac);
		}
		else if(curr.next == null){
			curr.next = new Node(name, minac, maxac);
		}
		else{
			putHelper(name, minac, maxac, curr.next);
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
