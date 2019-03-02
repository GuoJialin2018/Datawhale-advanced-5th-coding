package day2;

import java.util.Scanner;

public class recursion_02 {

	public static void main(String[] args) {
		System.out.println("请输入所求得n阶乘:");
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.next());
		System.out.println(fun(n));
		sc.close();
		// TODO 自动生成的方法存根
	}
	public static int fun(int n) {
		if(n==1) {
			return 1;
		}
		return n*fun(n-1);		
	}
		// TODO 自动生成的方法存根
}


