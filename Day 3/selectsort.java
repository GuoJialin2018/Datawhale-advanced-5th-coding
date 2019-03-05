package day3;

public class selectsort {
    public static void sort(int arr[]) {
    	for(int i=0;i<arr.length;i++) {
    		int k=i;
    		for(int j=k+1;j<arr.length;j++) {
    			if(arr[j]<arr[k]) {
    				k=j;
    			}    			
    		}
    		if(i!=k) {
    			int temp=arr[i];
    			arr[i]=arr[k];
    			arr[k]=temp;
    		}
    	}
    }
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
		// TODO 自动生成的方法存根

	}

}
