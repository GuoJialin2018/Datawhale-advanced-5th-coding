package day5;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Element {
    public int row, col, val;
    Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
public  class mergeKarray {
	private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element left, Element right) {
            return left.val - right.val;
        }
    };
    public  int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }
        
        int total_size = 0;
        // 默认由小到大顺序
        Queue<Element> Q = new PriorityQueue<Element>(
            arrays.length, ElementComparator);
        for(int i=0;i<arrays.length;i++) {
        	if(arrays[i].length>0) {
        		Element elem=new Element(i,0,arrays[i][0]);
        		Q.add(elem);
        		total_size+=arrays[i].length;
        	}
        }
        int[] result=new int[total_size];
        int index=0;
        while(!Q.isEmpty()) {
        	Element elem=Q.poll();
        	result[index++]=elem.val;
        	if(elem.col+1<arrays[elem.row].length) {
        		elem.col+=1;
        		elem.val=arrays[elem.row][elem.col];
        		Q.add(elem);
        	}
        }
        return result;
 }
    public static void main(String[] args) {
    	 int arr[][] =  {{2, 6, 12, 34},
                 {1, 9, 20, 1000},
                 {23, 34, 90, 2000}};
    	 mergeKarray a=new mergeKarray();
    	 int[] output=a.mergekSortedArrays(arr);
    	 for(int i=0;i<output.length;i++) {
    		 System.out.println(output[i]+",");
    	 }
    }
}
