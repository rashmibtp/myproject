/*
Given a String with 1 and 0 
Find the shortest substring containing K ones

input :: 101101010011101, K=3
output :: 111 

input :: 1001001010, K=2
output :: 101



*/

class SlidingWindowWithKOnes {
  public static void main(String[] args){
      //System.out.println(findNextGreaterNumber("1219"));
      System.out.println(findSubstrtWithKOnesInIt("0101011",3));
      System.out.println(findSubstrtWithKOnesInIt("111",3));
      System.out.println(findSubstrtWithKOnesInIt("1101",4));
      System.out.println(findSubstrtWithKOnesInIt("10010010101010",4));
      System.out.println(findSubstrtWithKOnesInIt("000101010101110100111000",4));
      System.out.println(findSubstrtWithKOnesInIt("00010001000110100101",3));

  }

  public static String findSubstrtWithKOnesInIt(String input, int K){
    String output="-1";
    int countOne=0;
    int minLen=Integer.MAX_VALUE;
    for(int l=input.indexOf('1'),r=l;l<input.length()&& r<input.length();r++){
      //System.out.println("l ="+ l+" r="+r);
      if(input.charAt(r)=='1'){
        countOne++;
      }
      if(countOne==K){
        int currLength =r-l+1;
        if(minLen>currLength){
          minLen=currLength;
          output=input.substring(l,r+1);
          //System.out.println(output);
        }
        l=l+output.indexOf('1', output.indexOf('1') + 1);//next index of 1
        r=l-1;//because r++ will run
        //reset
        countOne=0;
        
      }
    }
    return output;
  }
  
}
