package day6;

import java.util.ArrayList;

public class Astar {
	public static class Node{
		public Node(int x,int y) {
			this.x=x;
			this.y=y;
		}
		public int x;
		public int y;
		public int F;
		public int G;
		public int H;
		public void calcF() {
			this.F=this.G+this.H;
		}
		public Node parent;
	}
	public static final int[][] NODES = { 
	        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	        { 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	        { 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	        { 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	        { 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
	        { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	    };
	public static final int STEP=10;
	private ArrayList<Node> openList=new ArrayList<Node>();
	private ArrayList<Node> closeList=new ArrayList<Node>();
	public Node findMinNodeInOpenList() {
		Node tempNode=openList.get(0);
		for(Node node:openList) {
			if(node.F<tempNode.F) {
				tempNode=node;
			}
		}
		return tempNode;
	}
	public boolean canReach(int x,int y) {
		if(x>=0&&x<NODES.length&&y>=0&&y<NODES[0].length) {
			return NODES[x][y]==0;
		}
		return false;
	}
    public ArrayList<Node> findNeighborNodes(Node currentNode){	
    	ArrayList<Node> arrayList=new ArrayList<Node>();
    	int topX=currentNode.x;
    	int topY=currentNode.y-1;
    	if(canReach(topX,topY)&&!exists(closeList,topX,topY)) {
    		arrayList.add(new Node(topX,topY));
    	}
    	int bottomX=currentNode.x;
    	int bottomY=currentNode.y+1;
    	if(canReach(bottomX,bottomY)&&!exists(closeList,bottomX,bottomY)) {
    		arrayList.add(new Node(bottomX,bottomY));
    	}
    	int leftX=currentNode.x-1;
    	int leftY=currentNode.y;
    	if(canReach(leftX,leftY)&&!exists(closeList,leftX,leftY)) {
    		arrayList.add(new Node(leftX,leftY));
    	}
    	int rightX=currentNode.x+1;
    	int rightY=currentNode.y;
    	if(canReach(rightX,rightY)&&!exists(closeList,rightX,rightY)) {
    		arrayList.add(new Node(rightX,rightY));
    	}
    	return arrayList;
    }
    public Node findPath(Node startNode,Node endNode) {
    	openList.add(startNode);
    	while(openList.size()>0) {
    		Node currentNode=findMinNodeInOpenList();
    		openList.remove(currentNode);
    		closeList.add(currentNode);
    		ArrayList<Node> neighborNodes=findNeighborNodes(currentNode);
    		for(Node node:neighborNodes) {
    			if(exists(openList,node)) {
    				foundPoint(currentNode,node);
    			}else {
    				notFoundPoint(currentNode,endNode,node);
    			}
    		}
    		if(find(openList,endNode)!=null) {
    			return find(openList,endNode);
    		}
    	}
    	return find(openList,endNode);
    }
    private void foundPoint(Node tempStart,Node node) {
    	int G=calcG(tempStart,node);
    	if(G<node.G) {
    		node.parent=tempStart;
    		node.G=G;
    		node.calcF();
    	}
    }
    private void notFoundPoint(Node tempStart,Node end,Node node){
    	node.parent=tempStart;
    	node.G=calcG(tempStart,node);
    	node.H=calcH(end,node);
    	node.calcF();
    	openList.add(node);
    }
    private int calcG(Node start,Node node) {
    	int G=STEP;
    	int parentG=node.parent!=null?node.parent.G:0;
    	return G+parentG;
    }
    private int calcH(Node end,Node node) {
    	int step=Math.abs(node.x-end.x)+Math.abs(node.y-end.y);
    	return step*STEP;
    }
    public static Node find(ArrayList<Node> nodes,Node point) {
    	for(Node n:nodes) {
    		if((n.x==point.x)&&(n.y==point.y)) {
    			return n;
    		}
    	}
    	return null;
    }
    public static boolean exists(ArrayList<Node> nodes,Node node) {
    	for(Node n:nodes) {
    		if((n.x==node.x)&&(n.y==node.y)) {
    			return true;
    		}
    	}
    	return false;
    }
    public static boolean exists(ArrayList<Node> nodes,int x,int y) {
    	for(Node n:nodes) {
    		if((n.x==x)&&(n.y==y)) {
    			return true;
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
    	Node startNode=new Node(5,1);
    	Node endNode=new Node(5,5);
    	Node parent=new Astar().findPath(startNode, endNode);
    	for(int i=0;i<NODES.length;i++) {
    		for(int j=0;j<NODES[0].length;j++) {
    			System.out.println(NODES[i][j]+",");
    		}
    		System.out.println();
    	}
    	ArrayList<Node> arrayList=new ArrayList<Node>();
    	while(parent!=null) {
    		arrayList.add(new Node(parent.x,parent.y));
    		parent=parent.parent;
    	}
    	System.out.println("\n");
    	for(int i=0;i<NODES.length;i++) {
    		for(int j=0;j<NODES[0].length;j++) {
    			if(exists(arrayList,i,j)) {
    				System.out.print("@,");
    			}else {
    				System.out.print(NODES[i][j]+",");
    			}
    		}
    		System.out.println();
    	}
    }

}
