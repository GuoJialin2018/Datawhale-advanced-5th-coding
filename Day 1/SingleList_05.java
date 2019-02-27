
public class SingleList_05 {
    private int size;
    private Node head;
    public SingleList_05() {
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
    	}else {
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
    		if(cur.next==null) {
    			return false;
    		}else {
    			pre=cur;
    			cur=cur.next;
    		}
    	}
    	if(cur==head) {
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
		SingleList_05 singleList=new SingleList_05();
		singleList.add("A");
		singleList.add("B");
		singleList.add("C");
		singleList.add("D");
		singleList.display();
		singleList.del("C");
		singleList.display();

	}

}
