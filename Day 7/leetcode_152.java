package day7;

public class leetcode_152 {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;       
        int imax=1,imin=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int tmp=imax;
                imax=imin;
                imin=tmp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);
            max=Math.max(imax,max);
        }
        return max;
        
    }
}
