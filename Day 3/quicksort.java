package day3;

public class quicksort {
	public static int partition(int []array,int low, int high) {
		int key=array[low];
		while(low<high) {
			while(array[high]>=key&&high>low) {
				high--;
			}
			array[low]=array[high];
			while(array[low]<=key&&high>low) {
				low++;
			}
			array[high]=array[low];
		}
		array[high]=key;
		return high;
	}
	public static void sort(int[]array,int low,int high) {
		if(low>=high) {
			return;
		}
		int index=partition(array,low,high);
		sort(array,low,index-1);
		sort(array,index+1,high); 
	}
	public static void main(String[] args) {
		int[] arr=new int[10];
		for(int i=0;i<10;i++) {
			arr[i]=(int)(100+Math.random()*100);
			System.out.print(arr[i]+" ");
		}
		System.out.println('\n'+"排序后的数组为：");
		sort(arr,0,9);
		for(int i=0;i<10;i++) {
			System.out.print(arr[i]+" ");
		}
		// TODO 自动生成的方法存根

	}

}
