package day2;

import java.util.Stack;

public class validParentheses_leetcode_20 {
    public static boolean isVaild(String s) {
    	Stack<Character> stack=new Stack<Character>();
    	char[] chars=s.toCharArray();
    	for(char a:chars) {
    		if(stack.size()==0) {
    			stack.push(a);  			
    		}else if(isSym(stack.peek(),a)) {
    			stack.pop();
    		}else {
    			stack.push(a);
    		}
    	}
    	return stack.size()==0;
    }
    public static boolean isSym(char c1,char c2) {
    	return(c1=='('&&c2==')')||(c1=='['&&c2==']')||(c1=='{'&&c2=='}');
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
       String s="([)]";
       System.out.println(isVaild(s.toString()));
	}

}
