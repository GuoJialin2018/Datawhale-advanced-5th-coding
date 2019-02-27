
public class MissingPositive_leetcode_41 {
	public int firstMissingPositive(int[] nums) {
        if(nums.length==0)return 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                while(nums[i]>0&&nums[i]<i+1&&nums[i]!=nums[nums[i]-1]){
                    int temp=nums[nums[i]-1];
                    nums[nums[i]-1]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

}
