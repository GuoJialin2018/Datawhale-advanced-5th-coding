import java.util.Arrays;

public class ArrayExpand {
   public static void main(String[] args) {
	   int[] oldarray= {1,2};
       int size=1;
       int[] newarray=expand(oldarray,size);
       System.out.println(Arrays.toString(newarray));
   }
   public static int[] expand(int[]oldarray,int size) {
	   int[] newarray=new int[oldarray.length+size];
	   System.arraycopy(oldarray, 0, newarray, 0, oldarray.length);
	   return newarray;
   }
}
