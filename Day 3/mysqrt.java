package day3;

public class mysqrt {
	public static int mySqrt(int x) {
		long res=x;
		while(res*res>x) {
			res=(res+x/res)/2;
		}
		return (int)res;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.print(mySqrt(10213));

	}

}
