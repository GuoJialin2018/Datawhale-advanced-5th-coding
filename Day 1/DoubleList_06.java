
public class DoubleList_06 {
	private int size;
    private Node head;
    private Node tail;
    public DoubleList_06() {
    	size=0;
    	head=null;
    	tail=null;
    }
    private class Node{
    	private Object data;
    	private Node next;
    	private Node prev;
    	public Node(Object data) {
    		this.data=data;
    	}
    }
    public void addHead(Object obj){
    	Node newHead=new Node(obj);
    	if(size==0) {
    		head=newHead;
    		tail=newHead;
    		size++;
    	}else {
    		head.prev=newHead;
    		newHead.next=head;
    		head=newHead;
    		size++;
    	}
    }
    public void addTail(Object obj) {
    	Node newNode=new Node(obj);
    	if(size==0) {
    		head=newNode;
    		tail=newNode;
    		size++;
    	}else {
    		newNode.prev=tail;
    		tail.next=newNode;
    		tail=newNode;
    		size++;
    	}
    }
    public boolean del(Object obj) {
    	if(size==0) return false;
    	Node cur=head;
    	Node pre=head;
    	while(cur.data!=obj) {
    		if(cur.next==null) {
    			return false;
    		}else {
    			pre=cur;
    			cur=cur.next;
    		}
    	}
    	if(cur==head) {
    		head=cur.next;
    		cur.next.prev=null;
    		size--;
    	}else {
    		pre.next=cur.next;
    		cur.next.prev=pre;
    		size--;
    	}
    	return true;
    }
    public void display() {
    	if(size>0) {
    		Node node=head;
    	    if(size==1) {
    	    	 System.out.println("["+node.data+"]");
    	    }
    	    while(node!=null) {
    	    	if(node.equals(head)){
    	    	    System.out.print("["+node.data+"->");
    	        }else if(node.next == null){
    	    	    System.out.print(node.data+"]");
    	    	}else{
    	    	    System.out.print(node.data+"->");
    	    	}
    	    	if(node.next!=null) {
    	    		node = node.next;
    	    	}else {
    	    		break;
    	    	}
    	        
    	    }
    	    System.out.println();
    	}else {
    		System.out.println("[]");
    	}
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DoubleList_06 DoubleLis=new DoubleList_06();
		DoubleLis.addHead("A");
		DoubleLis.addTail("B");
		DoubleLis.addHead("C");
		DoubleLis.addTail("D");
		DoubleLis.display();
		DoubleLis.del("B");
		DoubleLis.display();

	}
	

}
