import java.util.HashMap;
import java.util.Map;

public class TwoSum_leetcode_01 {
      public int[] twoSum(int[]nums,int target) throws Exception {
    	  Map<Integer,Integer> map=new HashMap<>();
    	  for(int i=0;i<nums.length;i++) {
    		  map.put(nums[i], i);
    	  }
    	  for(int i=0;i<nums.length;i++) {
    		  int answer=target-nums[i];
    		  if(map.containsKey(answer)&&map.get(answer)!=i) {
    			  return new int[] {i,map.get(answer)};
    		  }
    	  }
    	  throw new Exception("No answer");
      }
}
