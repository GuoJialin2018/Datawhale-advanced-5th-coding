package day4;

public class reverseWords {
	public String reverseWords(String s) {
		String[] array=s.split(" ");
		String result="";
		for(int i=array.length-1; i>=0;i--) {
			String s0=array[i].trim();
			if(s0.length()!=0) {
				if(result.equals("")) {
					result+=s0;
				}else {
					result+=" "+s0;
				}
			}
		}
		return result;
    }
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
