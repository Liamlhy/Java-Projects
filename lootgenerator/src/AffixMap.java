import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;





@SuppressWarnings("rawtypes")
public class AffixMap implements Map {
	//Initializes the Node class
	public class Node{
		public String name; 
		public String mod1code;
		public int mod1min;
		public int mod1max;
		public Node next;
		public Node(String name, String mod1code, int mod1min, int mod1max){
			this.name = name;
			this.mod1code = mod1code;
			this.mod1min = mod1min;
			this.mod1max = mod1max;
		}
	}
	Node map; 
	Node current;
	int size = 0;
	//Creates the map of the affix class
	public AffixMap(String name, String mod1code, int mod1min, int mod1max){
		map = new Node(name, mod1code, mod1min, mod1max);
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
			return -1;
		}
		else if(curr.name.equals(key)){
			
			return rand.nextInt((curr.mod1max - curr.mod1min) + 1) + curr.mod1min;
		}
		return getHelper(key, curr.next);
	}
	//Returns the i-th node of the current map
	public String getNumber(int i) {
		return getNumberHelper(i, map);
	}
	public String getNumberHelper(int i, Node curr){
		if(curr == null){
			return null;
		}
		else if(i == 0){
			return curr.name;
		}
		return getNumberHelper(i - 1, curr.next);
	}
	//Puts a new affix object into the current map
	public Object put(String key, String mod1code, int mod1min, int mod1max) {
		this.size++;
		putHelper(key, mod1code, mod1min, mod1max, map);
		return null;
	}
	public void putHelper(String name, String mod1code, int mod1min, int mod1max, Node curr){
		if(curr == null){
			curr = new Node(name, mod1code, mod1min, mod1max);
		}
		else if(curr.next == null){
			curr.next = new Node(name, mod1code, mod1min, mod1max);
		}
		else{
			putHelper(name, mod1code, mod1min, mod1max, curr.next);
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
