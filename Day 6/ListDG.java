package day6;

public class ListDG {
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
	public ListDG(char[] vertexs,char[][]edges) {
		size=vertexs.length;
		this.vertexLists=new Vertex[size];
		for(int i=0;i<size;i++) {
			this.vertexLists[i]=new Vertex(vertexs[i]);
		}
		for(char[] c:edges) {
			int p=getPosition(c[0]);
			vertexLists[p].add(c[1]);
		}
	}
	private int getPosition(char ch) {
		for(int i=0;i<size;i++) {
			if(vertexLists[i].ch==ch)
				return i;
		}
		return -1;
	}
}
