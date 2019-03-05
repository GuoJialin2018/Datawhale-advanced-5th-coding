package day3;

public class BubbleSort {
    public static void sort(int []arr) {
    	int temp;
    	for(int i=0;i<arr.length-1;i++) {
    		for(int j=0;j<arr.length-i-1;j++) {
    			if(arr[j+1]<arr[j]) {
    				temp=arr[j];
    				arr[j]=arr[j+1];
    				arr[j+1]=temp;
    			}
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
