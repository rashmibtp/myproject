/*
Practicing some interview questions

Need to find how many sticker needed to make string2 using string1's character
*/

import java.util.*;
import java.util.Map.Entry;



class StickerProblem{
  

    public static int countStickers(String str1, String str2) throws IllegalStateException {
      if(str1.length()==0){ return 0;}
      if(str2.length()==0){ return 0;}
      str1 = str1.toLowerCase();
      str2 = str2.toLowerCase();
      Map<Character,Integer> map1 = new HashMap<Character,Integer>();
      for(int i=0;i<str1.length();i++){
        if(str1.charAt(i)!=' '){
          if(map1.get(str1.charAt(i))!=null){
            map1.put(str1.charAt(i),map1.get(str1.charAt(i))+1);
          }
          else{
            map1.put(str1.charAt(i),1);
          }
        }
      }

      HashMap<Character,Integer> map2 = new HashMap<Character,Integer>();
      for(int i=0;i<str2.length();i++){
        if(str2.charAt(i)!=' '){
          if(map2.get(str2.charAt(i))!=null){
            map2.put(str2.charAt(i),map2.get(str2.charAt(i))+1);
          }
          else{
            map2.put(str2.charAt(i),1);
          }
        }
      }
      int maxValue =1; //assuming there is one character at least so need one sticker
      for(Entry<Character,Integer> e : map2.entrySet()){
        if(map1.get(e.getKey())==null){
          return -1;
        }
        int value1 = map1.get(e.getKey());
        int value2 = e.getValue();
        //if(map1.get(e.getKey()).compareTo(e.getValue())<0){}
        if(value1<value2){
          // get the count how many stickers are needed in that case
          int count = value2/value1;
          if(maxValue<count){
            maxValue = count;
          }
        }
      }

      return maxValue;
    }

    public static void main(String[] args){
      System.out.println(countStickers("facebook","BOO"));//1
      System.out.println(countStickers("facebook","coffee"));//2
      System.out.println(countStickers("facebook","a kabab"));//3
      System.out.println(countStickers("facebook","zoo foo boo"));//-1
      System.out.println(countStickers("facebookz","zzoo foo boo"));//3

    }
}


