package day3;

public class BinarySearch {
	public static int bisearch(int[]arr,int a,int low,int high) {
		if(low<=high) {
			int mid=(low+high)/2;
			if(a==arr[mid]) {
				return mid+1;
			}else if(a>arr[mid]) {
				return bisearch(arr,a,mid+1,high);
			}else {
				return bisearch(arr,a,low,mid-1);
			}
		}
		return -1;
	}
	public static int partition(int[]arr,int low,int high) {
		int key=arr[low];
		while(low<high) {
			while(low<high&&arr[high]>=key) {
				high--;
			}
			arr[low]=arr[high];
			while(low<high&&arr[low]<=key) {
				low++;
			}
			arr[high]=arr[low];
		}
	    arr[low]=key;
	    return low;
	}
	public static void sort(int[]arr,int low,int high) {
		if(low>=high) {
			return ;
		}
		int index=partition(arr,low,high);
		sort(arr,low,index-1);
		sort(arr,index+1,high);
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
		for(int i=0;i<10;i++) {
			System.out.println('\n'+"查到的数字位置为：");
			int j=bisearch(arr,arr[i],0,9);
			System.out.print(j+" ");
		}
		// TODO 自动生成的方法存根

	}

}
