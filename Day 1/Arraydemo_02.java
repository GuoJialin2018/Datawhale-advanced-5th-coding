import java.util.Arrays;

public class Arraydemo_02 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
         int[] arr=new int[10];
         for(int i=0;i<10;i++) {
        	 arr[i]=i;
         }
         System.out.println("Original Array: "+Arrays.toString(arr));
         System.out.println("Search 3: "+search(arr,3));
         System.out.println("delete 4: "+delete(arr,4));
         System.out.println("add 11: "+add(arr,11));
         System.out.println("Reset 5 as 100: "+reset(arr,5,100));
         
	}

	private static String search(int[] arr, int i) {
		// TODO 自动生成的方法存根
		for(int k=0;k<arr.length;k++) {
			if(arr[k]==i) {
				return "Have Found "+i+" At the Index of k";
			}
		}
		return "Have Not Found"+i;
	}

	private static String delete(int[] arr, int i) {
		// TODO 自动生成的方法存根
		for(int k=0;k<arr.length;k++) {
			if(arr[k]==i) {
				arr[k]=-1;
				return "Have Found "+i+" And delete it as -1";
			}
		}
	    return "Have Not Found"+i;
	}

	private static String add(int[] arr, int i) {
		// TODO 自动生成的方法存根
		for(int k=0;k<arr.length;k++) {
			if(arr[k]==-1) {
				arr[k]=i;
				return "Have Found -1 And add it as 11";
			}
		}
		return "Have Not Found"+i;
	}

	private static String reset(int[] arr, int i, int j) {
		// TODO 自动生成的方法存根
		for(int k=0;k<arr.length;k++) {
			if(arr[k]==i) {
				arr[k]=j;
				return "Have Found "+i+" And reset it as "+j;
			}
		}
		return "Have Not Found"+i;
	}

}
