package day6;

public class ListNDG {
	Vertex[] vertexLists;
	int size;
	class Vertex{
		char ch;
		Vertex next;
		Vertex(char ch){
			this.ch=ch;
		}
		void add(char ch) {
			Vertex node=this;
			while(node.next!=null) {
				node=node.next;
			}
			node.next=new Vertex(ch);
		}
	}
	private int getPosition(char ch) {
		for(int i=0;i<size;i++) {
			if(vertexLists[i].ch==ch)
				return i;
		}
		return -1;
	}
	public void print() {
		for(int i=0;i<size;i++) {
			Vertex temp=vertexLists[i];
			while(temp!=null) {
				System.out.print(temp.ch+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	public ListNDG(char[] vertexs,char[][] edges) {
		size=vertexs.length;
		this.vertexLists=new Vertex[size];
		for(int i=0;i<size;i++) {
			this.vertexLists[i]=new Vertex(vertexs[i]);
		}
		for(char[] c:edges) {
			int p1=getPosition(c[0]);
			vertexLists[p1].add(c[1]);
			int p2=getPosition(c[1]);
			vertexLists[p2].add(c[0]);
		}
	}
	

}
