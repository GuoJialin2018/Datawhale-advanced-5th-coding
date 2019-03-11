package day5;

import java.util.Arrays;

public class MaxHeap{
    private int[] buildMaxHeap(int[] array){
    	for(int i=(array.length-2)/2;i>=0;i--) {
    		adjustDownToUp(array,i,array.length);
     	}
    	return array;
    }
    private void adjustDownToUp(int[] array,int k,int length) {
    	int temp=array[k];
    	for(int i=2*k+1;i<length-1;i=2*i+1) {
    		if(i<length &&array[i]<array[i+1]) {
    			i++;
    		}
    		if(temp>=array[i]) {
    			break;
    		}else {
    			array[k]=array[i];
    			k=i;
    		}
    	}
    	array[k]=temp;
    }
    public int[] heapSort(int[] array) {
    	array=buildMaxHeap(array);
    	for(int i=array.length-1;i>1;i--) {
    		int temp=array[0];
    		array[0]=array[i];
    		array[i]=temp;
    		adjustDownToUp(array,0,i);
    	}
    	return array;
    }
    public int[]deleteMax(int[] array){
    	array[0]=array[array.length-1];
    	array[array.length-1]=-9999;
    	adjustDownToUp(array,0,array.length);
    	return array;
    }
    public int[] insertData(int[] oldarray,int data) {
    	int[] array=new int[oldarray.length+1];
    	for(int i=0;i<oldarray.length-1;i++) {
    		array[i]=oldarray[i];
    	}
    	array[array.length-1]=data;
    	int k=array.length-1;
    	int parent=(k-1)/2;
    	while(parent>=0&&data>array[parent]) {
    		array[k]=array[parent];
    		k=parent;
    		if(parent!=0) {
    			parent=(parent-1)/2;
    		}else {
    			break;
    		}
    	}
    	array[k]=data;
    	return array;
    }
    public void toString(int [] array) {
    	for(int i:array) {
    		System.out.print(i+",");
    	}
    }
	public static void main(String[] args) {
	    MaxHeap hs = new MaxHeap();
		int[] array = {1,2,3,4,5,6,7,9,8};
		System.out.print("构建大根堆：");
		hs.toString(hs.buildMaxHeap(array));
		System.out.print("\n"+"删除堆顶元素：");
		hs.toString(hs.deleteMax(array));
		System.out.print("\n"+"插入元素63:");
		hs.toString(hs.insertData(array, 63));
	    System.out.print("\n"+"大根堆排序：");
        hs.toString(hs.heapSort(array));    
	
	}
}
