package day4;

public class NaiveMatch {
	public static int NaiveMatch(String s,String d) {
		int i=0,j=0;
		while(i<s.length()&&j<d.length()) {
			if(s.charAt(i)==d.charAt(j)) {
				i++;
				j++;
			}else {
				i=i-(j-1);
				j=0;
			}
			
		}
		if(j==d.length()) {
			return i-j;
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String s1="asdsdaweqasdwet";
		String s2="tryrtyfghvu";
		String d="awe";
		System.out.println(NaiveMatch(s1,d));
		System.out.println(NaiveMatch(s2,d));

	}

}
