package day6;

public class MatrixDG {
	int size;
	char[] vertexs;
	int[][] matrix;
	public MatrixDG(char[] vertexs,char[][] edges) {
		size=vertexs.length;
		matrix=new int[size][size];
		this.vertexs=vertexs;
		for(char[] c:edges) {
			int p1=getPosition(c[0]);
			int p2=getPosition(c[1]);
			matrix[p1][p2]=1;
		}
	}
	private int getPosition(char ch) {
		for(int i=0;i<vertexs.length;i++) {
			if(vertexs[i]==ch)
				return i;
		}
		return -1;
	}
	public void print() {
		for(int[] i:matrix) {
			for(int j:i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
        char[][] edges = new char[][]{
            {'A', 'C'}, 
            {'A', 'D'}, 
            {'A', 'F'}, 
            {'B', 'C'}, 
            {'C', 'D'}, 
            {'E', 'G'}, 
            {'D', 'G'},
            {'I','J'},
            {'J','G'},};
        MatrixDG pG;
        pG = new MatrixDG(vexs, edges);
        pG.print();
	}
	

}
