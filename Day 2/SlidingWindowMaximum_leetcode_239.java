package day2;

import java.util.PriorityQueue;

public class SlidingWindowMaximum_leetcode_239 {
	 public static int[] maxSlidingWindow(int[] nums, int k) {
	        if (k == 0) {
	            return nums;
	        }
	        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
	        for (int i = 0; i < k; i++) {
	            queue.add(nums[i]);
	        }

	        int[] res = new int[nums.length - k + 1];
	        for (int i = 0; i < res.length; i++) {
	            res[i] = queue.peek();
	            queue.remove(nums[i]);
	            if (i + k < nums.length) {
	                queue.add(nums[i + k]);	            
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[]nums= {1,3,-1,-3,5,3,6,7};
		int k=3;
		int[] i=maxSlidingWindow(nums, k);
		for(int j=0;j<i.length;j++) {
			System.out.print(i[j]);			
		}
	}

}
