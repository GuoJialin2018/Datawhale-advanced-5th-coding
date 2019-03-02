package day2;

public class queue_02 {
	class Node{
		Node next;
		Object element;
		public Node(Node next,Object element) {
			this.next=next;
			this.element=element;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next=next;
		}
		public Object getElement() {
			return element;
		}
		public void setElement(Object element) {
			this.element=element;
		}
	}
	Node front;
	Node rail;
	int size=0;
	public queue_02() {
		front=rail=null;
	}
	public boolean isEmpty() {
		return size==0?true:false;
	}
	public void addQueue(Object ele) {
		if(size==0) {
			front=new Node(null,ele);
			rail=front;
			size++;
		}
		Node s=new Node(null,ele);
		rail.setNext(s);
		rail=s;
		size++;
	}
	public boolean delQueue() {
		if(isEmpty()) {
			System.out.println("The queue is empty!");
			return false;
		}
		System.out.println(front.element +" is del");
		front=front.next;
		size--;
		return true;
	}
	public static void main(String[] args) {
		queue_02 queue=new queue_02();
		queue.addQueue(1);
		queue.addQueue(2);
		queue.addQueue(3);
		queue.delQueue();
	}

}
