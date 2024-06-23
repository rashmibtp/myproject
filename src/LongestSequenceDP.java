/*
Given 2 String find longest recurring sequence of

input :: ABCD, ABCD
output :: ABC or ACD 

input :: BACD, ABCD
output :: BCD

BELOW IS NOT A FULL PROOF SOLUTION, NEED TO REWORK

*/
import java.util.*;


class LongestSequence {
  public static void main(String[] args){
      System.out.println(LCS("ABCD","ABCD"));
      System.out.println(LCS_DP("DACD","ABCD"));
      System.out.println(LCS_DP("BACD","ABCD"));
      System.out.println(LCS_DP("ABCBDAB","BDCABA"));
      System.out.println(LCS_DPList("ABCD","BACD"));
  }
  public static int longest=1;

  public static List<String> LCS(String s1,String s2){
    List<String> result = new ArrayList<String>();
    recurrCommonSeq(result,"",s1,s2,0,0);
    return result;  
  }

  
  
  //Stack overlfow error
  public static void recurrCommonSeq (List<String> list, String commonStr, String s1, 
    String s2, int i, int j){
      if(i==s1.length() || j==s2.length()){
        if(commonStr.length()>=longest){
          longest=commonStr.length();
          list.add(commonStr);
        }
        return;
      }
      while(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j)){
        commonStr+=s1.charAt(i);
        i++;j++;
      }
      if(commonStr.length()>longest){
        longest=commonStr.length();
      }
      recurrCommonSeq (list, commonStr,s1,s2,i+1,j);
      recurrCommonSeq (list, commonStr,s1,s2,i,j+1);

    }

    public static String LCS_DP(String s1,String s2){
      int[][] table = new int[s1.length()+1][s2.length()+1];
      memoization(table,s1,s2);
      StringBuffer result = new StringBuffer();
      printArray(table);
      for(int x=s1.length(), y= s2.length();x!=0 && y!=0;){
        if(table[x][y]==table[x-1][y]){
          x--;
        }
        else if(table[x][y]==table[x][y-1]){
          y--;
        }
        else {
          assert s1.charAt(x-1) ==s2.charAt(y-1);
          result.append(s1.charAt(x-1));
          x--;
          y--;
        }
      }
      return result.reverse().toString();
    }

    public static List<String> LCS_DPList(String s1,String s2){
      int[][] table = new int[s1.length()+1][s2.length()+1];
      memoization(table,s1,s2);
      printArray(table);
      List<String> result = new ArrayList<String>();
      recurrDP(result, new StringBuffer(), table, s1.length(),s2.length(),s1,s2);
      return result;
    }

    //not giving the desired results
    public static void recurrDP(List<String> list, StringBuffer currStr, int[][]table, int x, int y, String s1,String s2){
      System.out.println("x= "+x+ " y= "+y+ " str= "+currStr);
      if(x==0 || y==0){
        list.add(currStr.reverse().toString());
        return;
      }
      if(s1.charAt(x-1) ==s2.charAt(y-1)){
          currStr.append(s1.charAt(x-1));
          recurrDP(list, currStr, table, x-1, y-1, s1, s2);
        }
      else {
        if(table[x][y]==table[x-1][y]){
          recurrDP(list, currStr, table, x-1, y, s1, s2);
        }
        if(table[x][y]==table[x][y-1]){
          recurrDP(list, currStr, table, x, y-1, s1, s2);
        }
        
      }
      
    }

    public static void memoization(int[][] table, String s1, String s2){
      //filling the table
      for(int i=0;i<s1.length();i++){
        for(int j=0;j<s2.length();j++){
          if(s1.charAt(i)==s2.charAt(j)){
            table[i+1][j+1]=table[i][j]+1;
          }
          else{
            table[i+1][j+1]= Math.max(table[i+1][j], table[i][j+1]);
          }
        }
      }
    }


    public static void printArray(int[][] array){
    for (int[] x : array)
    {
      for (int y : x)
      {
          System.out.print(y + " ");
      }
      System.out.println();
    }

  }
  }
