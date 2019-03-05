package day3;

public class findkthLarge {
    public static int getKth(int k,int[]nums,int low,int high) {
    	int key=nums[low];
    	int left=low;
    	int right=high;
    	while(low<high) {
    		while(low<high&&nums[high]>key) {
    			high--;
    		}
    		nums[low]=nums[high];
    		while(low<high&&nums[low]<key) {
    			low++;
    		}
    		nums[high]=nums[low];
    	}
    	nums[low]=key;
    	if(k==low+1) {
    		return nums[low];
    	}else if(k<low+1) {
    		return getKth(k,nums,left,low-1);
    	}else {
    		return getKth(k,nums,low+1,right);
    	}
    	
  
    }
	public static void main(String[] args) {
		int[] arr=new int[10];
		for(int i=0;i<10;i++) {
			arr[i]=(int)(100+Math.random()*100);
			System.out.print(arr[i]+" ");
		}
		System.out.println('\n'+"排序后的第3大数为：");
		int b=getKth(8,arr,0,9);
		System.out.print(b);
		
		// TODO 自动生成的方法存根

	}

}
