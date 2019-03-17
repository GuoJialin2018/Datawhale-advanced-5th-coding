package day7;
import java.util.*;
public class leetcode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null|| triangle.size()==0){
            return 0;
        }
        int[] dp=new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            List<Integer>curTr=triangle.get(i);
            for(int j=0;j<curTr.size();j++){
                dp[j]=Math.min(dp[j],dp[j+1])+curTr.get(j);
            }
        }
        return dp[0];
    }

}
