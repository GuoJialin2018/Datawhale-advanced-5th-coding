package day7;

public class leetcode_121 {
    public int maxProfit(int[] prices) {
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            max=Math.max(prices[i]-min,max);
        }
        return max;
    }

}