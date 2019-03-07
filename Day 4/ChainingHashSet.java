package day4;

public class ChainingHashSet {
    public static class HashSet<K,V>{
    	private int num;
    	private int capacity;
    	private SearchNode<K,V>[] st;
    	public HashSet(int init) {
    		capacity=init;
    		st=(SearchNode<K,V>[]) new Object[capacity];
    		for(int i=0;i<capacity;i++) {
    			st[i]=new SearchNode<>();
    		}
    	}
    	private int hash(K key) {
    		return (key.hashCode() & 0x7fffffff) % capacity;
    	}
    	private V get( K key) {
    		return st[hash(key)].get(key);
    	}
    	public void put(K key, V value) {
    		st[hash(key)].put(key, value);
    	}    	
    }
    public static class SearchNode<K,V>{
    	private Node first;
    	private class Node{
    		K key;
    		V value;
    		Node next;
    	    public Node(K key,V val,Node next) {
    		     this.key=key;
    		     this.value=value;
    		     this.next=next;
    		}	
    	}
    	public V get(K key) {
    		for(Node node=first;node!=null;node=node.next) {
    			if(key.equals(node.key))
    				return node.value;
    		}
    		return null;
    	}
    	public void put(K key, V value) {
    		Node node;
    		for(node=first;node!=null;node=node.next) {
    			if(key.equals(key)) {
    				node.value=value;
    			}
    		}
    		first=new Node(key,value,first);
    	}
    }
}
