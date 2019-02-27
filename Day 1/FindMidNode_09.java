public class FindMidNode_09 {
    private int size;
    private Node head;
    public FindMidNode_09() {
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
    public Node FindMid(Object obj) {
    	Node fast=head;
    	Node slow=head;
    	while(fast!=null) {
    		if(fast.next!=null) {
    			fast=fast.next.next;
    		}else {
    			break;
    		}
    		slow=slow.next;
    	}
    	return slow;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		FindMidNode_09 singleList=new FindMidNode_09();
		singleList.add("A");
		singleList.add("B");
		singleList.add("C");
		singleList.add("D");
		singleList.add("E");
		singleList.add("F");
	    System.out.println(singleList.FindMid(1).data);


	}

}
