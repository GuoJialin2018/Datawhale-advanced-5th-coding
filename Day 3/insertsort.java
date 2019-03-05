package day3;

public class insertsort {
	public static void main(String[] args) {
		int[] arr=new int[10];
		for(int i=0;i<10;i++) {
			arr[i]=(int)(100+Math.random()*100);
			System.out.print(arr[i]+" ");
		}
		System.out.println('\n'+"排序后的数组为：");
		sort(arr);
		for(int i=0;i<10;i++) {
			System.out.print(arr[i]+" ");
		}
	}
		// TODO 自动生成的方法存根

	public static void sort(int[] arr) {
		int i=0;
		int j=0;
		int temp;
		for(i=1;i<arr.length;i++) {
			for(j=0;j<i;j++) {
				if(arr[j]>arr[i]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

}
