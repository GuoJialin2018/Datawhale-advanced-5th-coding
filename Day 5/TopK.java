package day5;

public class TopK {
    public static int partion(int[] a,int low,int high) {
    	int key=a[low];
    	while(low<high) {
    		while(low<high&&a[high]>=key) {
    			high--;
    		}
    		a[low]=a[high];
    		while(low<high&&a[low]<=key) {
    			low++;
    		}
    		a[high]=a[low];
    	}
    	a[high]=key;
    	return high;
    }
    public static void sort(int[] array,int low,int high,int k) {
    	if(low<high) {
    		int index=partion(array,low,high);
    		if(index==array.length-k) return;
    		else if(index>array.length-k) {
    			sort(array,low,index-1,k);
    		}else {
    			sort(array,index+1,high,k);
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a[]={2,20,3,7,9,1,17,18,0,4};
		int k=4;
		sort(a,0,a.length-1,k);
		for(int i=1;i<=k;i++) {
			System.out.println(a[a.length-i]);
		}
	}

}
