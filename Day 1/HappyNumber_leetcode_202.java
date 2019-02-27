import java.util.HashMap;
import java.util.Map;

public class HappyNumber_leetcode_202 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int n=19;
		if(n<=0) System.out.println("false");
        int i=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(true){
          int squares=0;
          while(n!=0){
              int temp=n%10;
              squares+=temp*temp;     
              n/=10;
          }
          n=squares;
          System.out.println(n);;
          if(n==1){
             System.out.println("true");;
             break;
          }else{
              if(map.containsKey(n)) {
            	  System.out.println("false");
            	  break;
              }
  
              else map.put(n,i++);
          }
        
        }
	}

}
