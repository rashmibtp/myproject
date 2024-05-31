/*
 
Given a String Sort this string based on the frequency of the characters 
Highest frequency character comes and then the second highest frequency character and so on 
if 2 characters have the same frequency then we will sort them based on alphabetical order 

input :: tree
output :: eert 

aaa
input :: rashmi
output :: ahimrs

*/

import java.util.*;


class StringSortingProblem{


    private static String sortCharactersByFrequency(String str){
      int[] arr = new int[26];
      for(int i=0;i<str.length();i++){
        //index of alphabet
        arr[str.charAt(i) - 'a']++;
      }
      System.out.println(Arrays.toString(arr));
      int max=0,index=0;boolean allDone=false;
      String result="";
      while(!allDone){
        max=-1;
        index=-1;
        for(int j=0;j<arr.length;j++){
          if(arr[j]!=0){
            if(arr[j]>max){
              max=arr[j];
              index=j;
            }
          }
        }
        if(index==-1) break;
        for(int k=0;k<arr[index];k++){
          result += (char) ('a'+index);
        }
        arr[index]=0;
        }
      return result;
    }
  
    public static void main(String[] args){
      int a = 'a';
      System.out.println(a);//ASCII value
      System.out.println(sortCharactersByFrequency("ccaadfzzzzzzgedfdfdgggggabbbcc"));
      System.out.println(sortCharactersByFrequency("tree"));
      System.out.println(sortCharactersByFrequency("rashmi"));
    }
}


