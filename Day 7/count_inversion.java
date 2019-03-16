package day7;

public class count_inversion {
    public long count=0;
    public int[] A;
    public int[] getReverseCount(int[] A,int low,int high) {
    	int mid=(low+high)/2;
    	if(low<high) {
    		getReverseCount(A,low,mid);
    		getReverseCount(A,mid+1,high);
    		mergeArray(A,low,mid,high);
    	}
    	return A;
    	
    }
    public void mergeArray(int[]A,int low,int mid,int high) {
    	int[] left=new int[mid-low+1];
    	int[] right=new int [high-mid];
    	int i=0;
    	int j=0;
    	int k=0;
    	for(;i<left.length;i++) {
    		left[i]=A[low+i];
    	}
    	for(;j<right.length;j++) {
    		right[j]=A[mid+1+j];
    	}
    	i=0;
    	j=0;
    	while(i<left.length&&j<right.length) {
    		if(left[i]>right[j]) {
    			A[low+k++]=right[j++];
    			count+=(left.length-i);
    		}else {
    			A[low+k++]=left[i++];
    		}
    		
    	}
    	while(i<left.length) {
    		A[low+k++]=left[i++];
    	}
    	while(j<right.length) {
    		A[low+k++]=right[j++];
    	}
    	
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		count_inversion test=new count_inversion();
		test.A=new int[5];
		for(int i=0;i<5;i++) {
			test.A[i]=(int)(100+Math.random()*100);
			System.out.print(test.A[i]+" ");
		}
		System.out.println('\n'+"排序后的数组为：");
		int[] arr=test.getReverseCount(test.A, 0, test.A.length-1);
		for(int i=0;i<5;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n"+test.count);
		// TODO 自动生成的方法存根

	}

}
