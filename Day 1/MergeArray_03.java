import java.util.Arrays;

public class MergeArray_03 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        int []array_1=new int[5];
        int []array_2=new int[5];
        for(int i=0;i<5;i++) {
        	array_1[i]=(int)(10*i+Math.random()*5);
        	array_2[i]=(int)(10*i+Math.random()*5);
        }
        System.out.println("First Array:"+Arrays.toString(array_1));
        System.out.println("Second Array:"+Arrays.toString(array_2));
        int []array_3=new int[array_1.length+array_2.length];
        array_3=mergeTwoArray(array_1,array_2);
        System.out.println("Merged Array:"+Arrays.toString(array_3));
	}

	private static int[] mergeTwoArray(int[] array_1, int[] array_2) {
		// TODO 自动生成的方法存根
		int []array_3=new int[array_1.length+array_2.length];
		int i=0,j=0,k=0;
		while(i<array_1.length&&j<array_2.length) {
			if(array_1[i]<array_2[j]) {
				array_3[k]=array_1[i];
				i++;
				k++;
			}else {
				array_3[k]=array_2[j];
				j++;
				k++;
			}
			if(i==array_1.length) {
				System.arraycopy(array_2,j,array_3,k,array_2.length-j);
			}else {
				System.arraycopy(array_1,i,array_3,k,array_1.length-i);
			}
			
		}
		return array_3;
	}

}
