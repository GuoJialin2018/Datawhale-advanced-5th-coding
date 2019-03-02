package day2;

public class stack_02<T> {
	private class Node{
		private T data;
		private Node next;
		public Node() {}
		public Node(T data,Node next) {
			this.data=data;
			this.next=next;
		}		
	}
	private Node top;
	private int size;
	public stack_02() {
		top=null;
	}
	public stack_02(T element) {
		top=new Node(element,null);
		size++;
	}
	public int length() {
		return size;
	}
	public void push(T element) {
		top=new Node(element,top);
		size++;
	}
	public T pop() {
		Node temp=top;
		top=top.next;
		temp.next=null;
		size--;
		return temp.data;
	}
	public T peek() {
		return top.data;
	}
	public boolean empty() {
		return size==0;
	}
	public void clear() {
		top=null;
		size=0;
	}
    public String toString() {
    	if(empty()) {
    		return"[]";
    	}else {
    		StringBuilder sb=new StringBuilder("[");
    		for(Node cur=top;;cur=cur.next) {
    			if(cur==null) break;
    			sb.append(cur.data.toString()+",");
    		}
    		int len=sb.length();
    		return sb.delete(len - 2, len).append("]").toString();
    	}
    }
    public static void main(String[] args) {
    	stack_02<String> stack=new stack_02<String>();
    	stack.push("aaaa");
    	stack.push("bbbb");
    	stack.push("cccc");
    	stack.push("dddd");
    	System.out.println("The stack is"+stack);
    	System.out.println("The top element is "+stack.peek());
    	System.out.println("The pop element is "+stack.pop());
    	System.out.println("The stack is"+stack);
    }
}
