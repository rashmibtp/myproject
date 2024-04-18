// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;
class SortStack {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Stack<Integer> st = new Stack<Integer>();
        st.push(8);st.push(7);st.push(4);st.push(6);
        st.push(5);st.push(2);st.push(3);st.push(1);
        System.out.println(Arrays.toString(st.toArray()));
        sortStack1(st);
        System.out.println(Arrays.toString(st.toArray()));
    }
    
    public static void sortStack1(Stack<Integer> st){
        if(st.isEmpty()) return;
        int curr = st.pop();
        //System.out.print(curr+", ");
        if(st.isEmpty()) {st.push(curr); return;};
        if(st.peek()>curr){
            //replace
            int temp = st.pop();
            st.push(curr);
            curr=temp;
        }
        //System.out.print(curr+", ");
        //System.out.println(Arrays.toString(st.toArray()));
        sortStack1(st);
        //if(st.isEmpty()) return;
        if(st.peek()>curr){
            //replace
            int temp = st.pop();
            st.push(curr);
            curr=temp;
            sortStack1(st);
        }
        st.push(curr);
        //System.out.println(Arrays.toString(st.toArray()));
    }
}
