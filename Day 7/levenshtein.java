package day7;

public class levenshtein {
    public static void leven(String str1,String str2) {
    	int len1=str1.length();
    	int len2=str2.length();
    	int[][] dif=new int[len1+1][len2+1];
    	for(int a=0;a<=len1;a++) {
    		dif[a][0]=a;
    	}
    	for(int a=0;a<=len2;a++) {
    		dif[0][a]=a;
    	}
    	int temp;
    	for(int i=1;i<=len1;i++) {
    		for(int j=1;j<=len2;j++) {
    			if(str1.charAt(i-1)==str2.charAt(j-1)) {
    				temp=0;
    			}else {
    				temp=1;
    			}
    			dif[i][j]=min(dif[i-1][j-1]+temp, dif[i][j-1]+1,dif[i-1][j]+1);
    		}
    	}
    	System.out.println("diff: "+dif[len1][len2]);
    	
    }
    public static int min(int...is) {
    	int min=Integer.MAX_VALUE;
        for(int i:is) {
        	if(min>i) {
        		min=i;
        	}
        }
        return min;
    }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		 String str1 = "eeefd"; 
		 String str2 = "ddefde"; 
		 leven(str1,str2);
	}

}
