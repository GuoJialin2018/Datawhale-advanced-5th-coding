package day6;
class Vertex{
	public char lable;
	public boolean wasVisited;
	public Vertex(char lab) {
		lable=lab;
		wasVisited=false;
	}
}
class Queue{
	private final int MAX_SIZE=20;
    private Object[] array;
    private int front;
    private int rear;
    private int length;
    public Queue() {
    	this.length=MAX_SIZE;
    	init();
    }
    public Queue(int length) {
    	this.length=length;
    }
    public void init() {
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
    	return(rear-front)%array.length+1;
    }
    public void insert(Object object)throws Exception{
    	if(isFull()) {
    		throw new Exception("insert is failed and the queue is full");
    	}
    	array[rear+1]=object;
    	rear=(rear+1)%array.length;
    }
    public Object remove()throws Exception{
    	if(isEmpty()) {
    		throw new Exception("remove is failed and the queue is full");
    	}
    	Object object=array[front];
    	array[front]=null;
    	front=(front+1)%array.length;
    	return object;
    }
}
class Stack{
	private final int SIZE=20;
	private int[] st;
	private int top;
	public Stack() {
		st=new int[SIZE];
	    top=-1;
	}
	public void push(int j) {
		st[++top]=j;
	}
	public int pop() {
		if(top==0) {
			return -1;
		}
		return st[--top];
	}
	public int peek() {
		return st[top];
	}
	public boolean isEmpty() {
		return (top==-1);
	}
}



public class Graph {
	private final int MAX_VERTS=20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Stack theStack;
	private Queue theQueue;
	public static void main(String[] args) throws Exception {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
 
		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(3, 4);
 
		System.out.print("visits:");
		// theGraph.dfs();
		theGraph.bfs();
		theGraph.dfs();
		System.out.println();
	}
	public Graph() {
		vertexList=new Vertex[MAX_VERTS];
		adjMat=new int[MAX_VERTS][MAX_VERTS];
		nVerts=0;
		for(int i=0;i<MAX_VERTS;i++) {
			for(int j=0;j<MAX_VERTS;j++) {
				adjMat[i][j]=0;
			}
		}
		theStack =new Stack();
		theQueue=new Queue();
	}
	public void addVertex(char lab) {
		vertexList[nVerts++]=new Vertex(lab);
	}
	public void addEdge(int start,int end) {
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	public void displayVertex(int v) {
		System.out.println(vertexList[v].lable);
	}
    public int getAdjUvisitedVertex(int v) {
    	for(int i=0;i<nVerts;i++) {
    		if(adjMat[v][i]==1&&vertexList[i].wasVisited==false) {
    			return i;
    		}
    	}
    	return -1;
    }
    public void dfs() {
    	vertexList[0].wasVisited=true;
    	displayVertex(0);
    	theStack.push(0);
    	while(!theStack.isEmpty()) {
    		int v=getAdjUvisitedVertex(theStack.peek());
    		if(v==-1) {
    			theStack.pop();
    		}else {
    			vertexList[v].wasVisited=true;
    			displayVertex(v);
    			theStack.push(v);
    		}
    		
    	}
    	for(int i=0;i<nVerts;i++) {
    		vertexList[i].wasVisited=false;
    	}
    }
    public void bfs() throws Exception {
    	vertexList[0].wasVisited=true;
    	displayVertex(0);
    	theQueue.insert(0);
    	int v2;
    	while(!theQueue.isEmpty()) {
    		int v1=(int) theQueue.remove();
    		while((v2=getAdjUvisitedVertex(v1))!=-1) {
    			vertexList[v2].wasVisited=true;
    			displayVertex(v2);
    			theQueue.insert(v2);
    		}
    	}
    	for(int j=0;j<nVerts;j++) {
    		vertexList[j].wasVisited=false;
    	}
    }
}
