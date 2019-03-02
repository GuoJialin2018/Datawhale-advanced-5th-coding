package day2;

public class queue_01 {
	private static final int MAX_SIZE=100;
	private Object[] array;
	private int front;
	private int rear;
	private int length;
	public queue_01() {
		this.length=MAX_SIZE;
		init();
	}
	public queue_01(int length) {
		this.length=length;
		init();
	}
	private void init() {
		array=new Object[this.length+1];
		front=rear;
	}
	public boolean isFull() {
		return (rear+1)%array.length==front;
	}
	public boolean isEmpty() {
		return front==rear;
	}
	public int size() {
		return(rear-front+array.length)%array.length;
	}
	public void clear() {
		array=null;
		array=new Object[this.length];
	}
	public void put(Object object)throws Exception{
		if(isFull()) {
			throw new Exception("put is failed and the queue is full!");
		}
		array[rear]=object;
		rear=(rear+1)%array.length;		
	}
	public Object get()throws Exception{
		if(isEmpty()) {
			throw new Exception("get is failed and the queue is empty!");
		}
		Object object=array[front];
		array[front]=null;
		front=(front+1)%array.length;
		return object;
	}
	public static void main(String[] args){
		queue_01 queue=new queue_01(5);
		char[] data=new char[] {'A','B','C','D','E'};
		try {
			for(int i=0;i<data.length;i++) {
				System.out.println("Input data "+data[i]);
				queue.put(data[i]);
			}
			System.out.println("队列大小"+queue.size());
			while(!queue.isEmpty()) {
				System.out.println("出队数据 "+queue.get());
			}
			System.out.println("队空否?\t"+queue.isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
