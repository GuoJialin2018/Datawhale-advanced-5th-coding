
public class majorityElement_leetcode_169 {
    public int majorityElement(int[] nums) {
        int count=0,ret=0;
        for(int num:nums){
            if(count==0)
                ret=num;
            if(num!=ret){
                count--;
            }
            if(num==ret){
                count++;
            }
        }
        return ret;
    }
}
