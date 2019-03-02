package day2;

import java.util.Stack;

public class EvaluateReversePolishNotatio_leetcode_150 {
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack=new Stack<>();
		for(String s:tokens) {
			char c=s.charAt(0);
			if((c!='+')&&(c!='-')&&(c!='*')&&(c!='/')||s.length()!=1){
				stack.push(Integer.parseInt(s));
			}else {
				int num1=stack.pop();
				int num2=stack.pop();
				switch(c) {
				     case'+':
				    	 stack.push(num1+num2);
				    	 break;
				     case'-':
				    	 stack.push(num2-num1);
				    	 break;
				     case'*':
				    	 stack.push(num1*num2);
				    	 break;
				     case '/':
				    	 stack.push(num2/num1);
				    	 break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] s= {"2","1","+","3","*"};
        System.out.println(evalRPN(s));
	}

}
