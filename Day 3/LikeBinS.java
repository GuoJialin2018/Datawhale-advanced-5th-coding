package day3;
import day3.BinarySearch;





public class LikeBinS {
	public static int bisearch(int[]arr,int a,int low,int high) {
		if(low<=high) {
			int mid=(low+high)/2;
			if(a==arr[mid]) {
				return mid+2;
			}else if(a>arr[mid]) {
				return bisearch(arr,a,mid+1,high);
			}else {
				return bisearch(arr,a,low,mid-1);
			}
		}
		return -1;
	}
    
	public static void main(String[] args) {
		int[] arr=new int[10];
		for(int i=0;i<10;i++) {
			arr[i]=(int)(100+Math.random()*100);
			System.out.print(arr[i]+" ");
		}
		System.out.println('\n'+"排序后的数组为：");
		BinarySearch.sort(arr,0,9);
		for(int i=0;i<10;i++) {
			System.out.print(arr[i]+" ");
		}
		for(int i=0;i<9;i++) {
			System.out.println('\n'+"查到大于该数字的第一个位置为：");
			int j=bisearch(arr,arr[i],0,9);
			System.out.print(j+" ");
		}
		// TODO 自动生成的方法存根

	}

}
