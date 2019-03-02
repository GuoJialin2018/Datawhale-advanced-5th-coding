package day2;

public class queue_03 {
    private int front;
    private int rear;
    private Object[] a;
    private int max;
    private int num;
    public queue_03(int n) {
    	a=new Object[n];
    	front=0;
    	rear=0;
    	num=0;
    	max=n;
    }
    public void add(Object data) {
    	if(num>0&&front==rear) {
    		System.out.println("The queue is full");
    	}else {
    		a[rear]=data;
    		rear=(rear+1)%max;
    		num++;
    	}
    }
    public Object del() {
    	if(num==0) {
    		System.out.println("The queue is empty");
    		return null;
    	}else{
    		Object temp=a[front];
    		front=(front+1)%max;
    		num--;
    		return temp;
    	}
    }
    public boolean isEmpty() {
    	if(num==0)
    		return true;
    	else 
    		return false;
    }
    public static void main(String[] args) {
    	queue_03 T=new queue_03(5);
    	System.out.println(T.del());
    	for(int i=0;i<6;i++) {
    		T.add(i);
    	}
    	for(int i=0;i<5;i++) {
    		System.out.println(T.del());
    	}
    	
    }
}
