package day2;

import java.util.Scanner;

public class recursion_02 {

	public static void main(String[] args) {
		System.out.println("�����������n�׳�:");
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.next());
		System.out.println(fun(n));
		sc.close();
		// TODO �Զ����ɵķ������
	}
	public static int fun(int n) {
		if(n==1) {
			return 1;
		}
		return n*fun(n-1);		
	}
		// TODO �Զ����ɵķ������
}


