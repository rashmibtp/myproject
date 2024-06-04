mport java.util.*;
class CircularArray {
  public static void main(String[] args){
      //System.out.println();
      printArray(makeCircularArray(3));
      //System.out.println(Arrays.deepToString(array));
      //System.out.println(Arrays.deepToString(makeCircularArray(4)));
      printArray(makeCircularArray(4));
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

  public static enum DIRECTION{
    LEFT,
    RIGHT,
    UP,
    DOWN;
  }

  public static int[][] makeCircularArray(int size){
    //starting with 0,0 and moving right
    DIRECTION currDirection=DIRECTION.RIGHT;
    int i=0,j=0;
    int rotation=0;
    int[][] arr = new int[size][size];
    int currLength=size-rotation;
    //System.out.println("currLength= "+currLength);
    for(int n=1;n<=(size*size);n++){
      
        System.out.println(i+", "+j+" = "+n);
        arr[i][j]=n;
      
      if(currDirection.equals(DIRECTION.RIGHT) && j<currLength){
        if(j==currLength-1){
          currDirection=DIRECTION.DOWN;
        } else{
          j++;
        }
      }
      if(currDirection.equals(DIRECTION.DOWN) && i<currLength){
        if(i==currLength-1){
          currDirection=DIRECTION.LEFT;
        } else{
          i++;
        }
      }
      if(currDirection.equals(DIRECTION.LEFT) && j>=rotation){
        if(j==rotation){
          currDirection=DIRECTION.UP;
        } else{
          j--;
        }
      }
      if(currDirection.equals(DIRECTION.UP) && i>rotation){
        i--;
      }
      if(i==rotation && j ==rotation){
        //rotation completed, reset things
        rotation++;
        i=rotation;
        j=rotation;
        currLength=size-rotation;
        currDirection=DIRECTION.RIGHT;
        System.out.println(Arrays.deepToString(arr));
      }
      
    }
    return arr;
  }
}
