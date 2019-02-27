
public class ReverseList_08 {
	    private int size;
	    private Node head;
	    public ReverseList_08() {
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
	    public void reverse() {
	    	Node prev=null;
	    	Node cur=head;
	    	while(cur!=null) {
	    		Node next=cur.next;
	    		cur.next=prev;
	    		prev=cur;
	    		cur=next;
	    		head=prev;
	    	}
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
			ReverseList_08 ReverseList=new ReverseList_08();
			ReverseList.add("A");
			ReverseList.add("B");
			ReverseList.add("C");
			ReverseList.add("D");
			ReverseList.display();
			ReverseList.reverse();
			ReverseList.display();

		}

}
