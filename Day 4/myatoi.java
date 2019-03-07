package day4;

public class myatoi {
    public int myAtoi(String str) {
        if(str.length()<1){
           return 0;
       }
       int pos=0;
       while(pos<str.length()&&str.charAt(pos)==' '){
           pos++;
       }
       str=str.substring(pos,str.length());
       if("".equals(str)){
           return 0;
       }
       boolean operator=true;
       String numString;
       if(str.charAt(0)<'0'||str.charAt(0)>'9'){
           if(str.charAt(0)!='+'&&str.charAt(0)!='-'){
               return 0;
           }
           if(str.charAt(0)=='-'){
               operator=false;
           }
           numString=getNumStr(str.substring(1,str.length()));
       }else{
           numString=getNumStr(str);
       }
       if("".equals(numString)){
           return 0;
       }
       if(numString.length()>10){
           if(operator){
               return Integer.MAX_VALUE;
           }else{
               return Integer.MIN_VALUE;
           }   
       }
       long num=Long.parseLong(numString);
       if(!operator){
           num=-num;
       }
       if(num<Integer.MIN_VALUE){
           return Integer.MIN_VALUE;
       }
       if(num>Integer.MAX_VALUE){
           return Integer.MAX_VALUE;
       }
       return (int)num;
   }
   private String getNumStr(String s){
       StringBuilder num=new StringBuilder();
       boolean isStart=true;
       for(int i=0;i<s.length();i++){
           if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
               if(isStart&&s.charAt(i)=='0'){
                   continue;
               }
               isStart=false;
               num.append(s.charAt(i));
           }else{
               break;
           }
       }
       return num.toString();
   }

}
