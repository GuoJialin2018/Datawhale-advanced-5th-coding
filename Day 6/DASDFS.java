package day6;
import java.io.*;
import java.util.*;
public class DASDFS {
    private int V;
    private LinkedList<Integer> adj[];
    DASDFS(int v){
    	V=v;
    	adj=new LinkedList[v];
    	for(int i=0;i<v;++i) {
    		adj[i]=new LinkedList<Integer>();
    	}	
    }
    void addEdge(int v,int w) {
		adj[v].add(w);
	}
    void topologicalSortUtil(int v,boolean visited[],Stack stack) {
    	visited[v]=true;
    	int i;
    	Iterator<Integer> it=adj[v].iterator();
    	while(it.hasNext()) {
    		i=it.next();
    		if(!visited[i])
    			topologicalSortUtil(i,visited,stack);
    	}
    	stack.push(v);
    }
    void topologicalSort() {
    	Stack stack=new Stack();
    	boolean visited[]=new boolean[V];
    	for(int i=0;i<V;i++) {
    		visited[i]=false;
    	}
    	for(int i=0;i<V;i++) {
    		if(visited[i]==false)
    			topologicalSortUtil(i,visited,stack);
    	}
    	while(stack.isEmpty()==false)
    		System.out.print(stack.pop()+" ");
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DASDFS g = new DASDFS(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g.topologicalSort(); 

	}

}
