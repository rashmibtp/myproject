/*
Look and say sequence
1
11
21
1211
111221
312211
13112221

*/
import java.util.*;

class LookAndSaySequence {
  public static void main(String[] args){
      formLookAndSaySequence(50);
  }

  public static void formLookAndSaySequence(int n){
    String str="1",curr;
    for(int i=1;i<=n;i++){
      System.out.println(str);
      curr=str;
      str="";
      int count=1; char c=curr.charAt(0);
      for(int j=1;j<curr.length();j++){
        if(curr.charAt(j)==c){
          count++;
        }
        else{
          str+=count+""+c;
          count=1;
          c=curr.charAt(j);
        }
      }
      str+=count+""+c;
      
    }
  }
}
