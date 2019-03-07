package day4;

public class reverse {
	public void reverseString(char[] s) {
		int i=0;
		int j=s.length-1;
		while(i<j) {
			swap(s,i,j);
			i++;
			j--;
		}
	}
	public void swap(char[]ch ,int i,int j) {
		char temp=ch[i];
		ch[i]=ch[j];
		ch[j]=temp;
	}

}
