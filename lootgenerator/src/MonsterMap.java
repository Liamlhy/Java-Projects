import java.util.Collection;
import java.util.Map;
import java.util.Set;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;





@SuppressWarnings("rawtypes")
public class MonsterMap implements Map {
	//Initializes the Node class
	public class Node{
		public String name; 
		public String type; 
		public int level;
		public String tClass;
		public Node next;
		public Node(String name, String type, int level, String tClass){
			this.name = name;
			this.type = type;
			this.level = level;
			this.tClass = tClass;
		}
	}
	Node map = null; 
	int size = 0;
	//Creates the map of the monster class
	public MonsterMap(String name, String type, int level, String tClass){
		map = new Node(name, type, level, tClass);
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
		else if(curr.tClass.equals(value)){
			return true;
		}
		return containsKeyHelper(value, curr.next);
	}
	//Returns the value of the given key
	public String get(String key) {
		return getHelper(key, map);
	}
	public String getHelper(String key, Node curr){
		if(curr == null){
			return null;
		}
		else if(curr.name.equals(key)){
			return curr.tClass;
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
	//Puts a new monster object into the current map
	public Object put(String name, String type, int level, String tClass) {
		this.size++;
		putHelper(name, type, level, tClass, map);
		return null;
	}
	public void putHelper(String name, String type, int level, String tClass, Node curr){
		if(curr == null){
			curr = new Node(name, type, level, tClass);
		}
		else if(curr.next == null){
			curr.next = new Node(name, type, level, tClass);
		}
		else{
			
			putHelper(name, type, level, tClass, curr.next);
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
