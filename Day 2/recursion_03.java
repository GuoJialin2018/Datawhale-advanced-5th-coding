package day2;

import java.util.Scanner;

public class recursion_03 {

	public static void main(String[] args) {
		System.out.println("请输入所求得字符串得全排列:");
		Scanner sc=new Scanner(System.in);
		char[] s=sc.next().toCharArray();
	    fun(s,0,s.length-1);
		sc.close();
		// TODO 自动生成的方法存根
	}
	public static void fun(char[] s,int begin,int end) {
	   if(begin==end) {
		   for(char c:s) {
			   System.out.print(c);
		   }
		   System.out.println("");
	   }else {
		   for(int i=begin;i<=end;i++) {
			   swap(s,begin,i);
			   fun(s,begin+1,end);	   
			   swap(s,begin,i);
		   }
	   }

	}
	public static void swap(char[] s,int i,int j) {
		char temp=s[i];
		s[i]=s[j];
		s[j]=temp;
	}

}
