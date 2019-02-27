public class CirList_07 {
	private int size;
    private Node head;
    private Node tail;
    public CirList_07() {
    	size=0;
    	head=null;
    }
    private class Node{
    	private Object data;
    	private Node next;
    	public Node(Object data) {
    		this.data=data;
    	}
    }
    public void add(Object obj){
    	Node newHead=new Node(obj);
    	if(size==0) {
    		head=newHead;
    		tail=newHead;
    		head.next=head;
    	}else {
    		tail.next=newHead;
    		newHead.next=head;
    		head=newHead;
    	}
    	size++;
    }
    public boolean del(Object obj) {
    	if(size==0) return false;
    	Node cur=head;
    	Node pre=head;
    	while(cur.data!=obj) {
    		if(cur==tail) {
    			return false;
    		}else {
    			pre=cur;
    			cur=cur.next;
    		}
    	}
    	if(cur==head) {
    		tail.next=cur.next;  		
    		head=cur.next;
    		size--;
    	}else {
    		pre.next=cur.next;
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
    	        }else if(node.next == head){
    	    	    System.out.print(node.data+"]");
    	    	}else{
    	    	    System.out.print(node.data+"->");
    	    	}
    	    	if(node.next!=head) {
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
		CirList_07 CirList=new CirList_07();
		CirList.add("A");
		CirList.add("B");
		CirList.add("C");
		CirList.add("D");
		CirList.display();
		CirList.del("A");
		CirList.display();

	}
}
