package day3;

public class mergesort {
	public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }
	public static void merge(int[]a,int low,int mid,int high) {
		int[] temp=new int [high-low+1];
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid &&j<=high) {
			if(a[i]<a[j]) {
				temp[k++]=a[i++];
			}else {
				temp[k++]=a[j++];
			}
		}
			while(i<=mid) {
				temp[k++]=a[i++];
			}
			while(j<=high) {
				temp[k++]=a[j++];
			}
			for(int x=0;x<temp.length;x++) {
				a[x+low]=temp[x];
			}
				
	}

	public static void main(String[] args) {
		int[] arr=new int[10];
		for(int i=0;i<10;i++) {
			arr[i]=(int)(100+Math.random()*100);
			System.out.print(arr[i]+" ");
		}
		System.out.println('\n'+"排序后的数组为：");
		arr=sort(arr,0,9);
		for(int i=0;i<10;i++) {
			System.out.print(arr[i]+" ");
		}
		// TODO 自动生成的方法存根

	}

}
