package day2;

import java.util.Stack;

public class LongestValidParentheses_leetcode_32 {
	public static int LonVal(String s) {
		int max=0,start=0;
		if(null==s)return 0;
		int len=s.length();
		Stack<Integer> stack=new Stack<>();
		for(int  i=0;i<len;i++) {
			if('('==s.charAt(i)) {
				stack.push(i);
				continue;
			}else {
				if(stack.isEmpty()) {
					start=i;
					continue;
				}else {
					stack.pop();
					if(stack.isEmpty()) {
						max=Math.max(max, i-start);
						System.out.println(max);
					}else {
						max=Math.max(max, i-stack.peek());
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        System.out.println(LonVal(")()())"));
	}

}
