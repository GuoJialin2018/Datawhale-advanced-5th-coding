package day7;

import java.lang.reflect.Array;
import java.util.Stack;

public class LIS {
	public static void main(String[] args) {
		int[] arr= {5,6,7,1,2,3,8};
		int[] brr=new int[arr.length];
		System.out.println("\n 排序前的数组");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
			brr[i]=arr[i];
		}
		quickSort(arr,0,arr.length-1);
		System.out.println("\n 排序后的数组");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println();
		getLCS(brr,arr);
	}
	public static int partition(int[]array,int left,int right) {
		int key;
		key=array[left];
		while(left<right) {
			while(left<right &&array[right]>key) {
				right--;
			}
			array[left]=array[right];
			while(left<right && array[left]<key) {
				left++;
			}
			array[right]=array[left];
		}
		array[left]=key;
		return left;
	}
	public static void quickSort(int[] array, int left, int right) {
		int mid;
		if(left<right) {
			mid=partition(array,left,right);
			quickSort(array,left,mid-1);
			quickSort(array,mid+1,right);
		}
	}
	public static void getLCS(int[] array,int[]data) {
		int len1=array.length;
		int len2=data.length;
		int[][] newArr=new int[len1+1][len2+1];
		for(int i=0;i<newArr.length;i++) {
			newArr[i][0]=0;
		}
		for(int j=0;j<newArr[0].length;j++) {
			newArr[0][j]=0;
		}
		for(int i=1;i<newArr.length;i++) {
			for(int j=1;j<newArr[i].length;j++) {
				if(array[i-1]==data[j-1]) {
					newArr[i][j]=newArr[i-1][j-1]+1;
				}else {
					newArr[i][j]=Math.max(newArr[i-1][j],newArr[i][j-1]);
				}
			}
		}
		Stack<Integer> stack=new Stack();
		int m=array.length-1;
		int n=data.length-1;
		while(n>=0&&m>=0) {
			if(array[m]==data[n]) {
				stack.push(array[m]);
				m--;
				n--;
			}else{
				if(newArr[m+1][n]>newArr[m][n+1]) {
					n--;
				}else {
					m--;
				}
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+",");
		}
	}
	
    
}
