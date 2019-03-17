package day7;

public class LCSequence {
    public static int LCS(String str1,String str2) {
    	int[][] c=new int[str1.length()+1][str2.length()+1];
    	for(int row=0;row<=str1.length();row++) {
    		c[row][0]=0;
    	}
    	for(int col=0;col<=str2.length();col++) {
    		c[0][col]=0;
    	}
    	for(int i=1;i<=str1.length();i++) {
    		for(int j=1;j<=str2.length();j++) {
    			if(str1.charAt(i-1)==str2.charAt(j-1))
    				c[i][j]=c[i-1][j-1]+1;
    			else 
    				c[i][j]=Math.max(c[i-1][j], c[i][j-1]);
    		}
    	}
    	return c[str1.length()][str2.length()];
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str1="BDCABA";
		String str2="ABCBDA";
		int result=LCS(str1,str2);
		System.out.println(result);

	}

}
