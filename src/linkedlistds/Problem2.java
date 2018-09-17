package linkedlistds;

//Here we are using Java's implementation of Linked List
import java.util.LinkedList;;

//When both the list are sorted. all we need is to merge.
public class Problem2 implements Runnable {
	
	static LinkedList<Integer> list1; static LinkedList<Integer> list2;
	static LinkedList<Integer> result;
	public void run() {
		if(result==null) {
			result = new LinkedList<Integer>();
		}
		while(!list1.isEmpty() && !list2.isEmpty()) {
			System.out.println(Thread.currentThread().getName());
			if(list1.isEmpty()) {
				while(!list2.isEmpty()) {
					result.add(list2.getFirst());
					list2.removeFirst();
				}
				break;
			}
			if(list2.isEmpty()) {
				while(!list1.isEmpty()) {
					result.add(list1.getFirst());
					list1.removeFirst();
				}
				break;
			}
			if(list1.getFirst()<list2.getFirst()) {
				result.add(list1.getFirst());
				list1.removeFirst();
			}
			else {
				result.add(list2.getFirst());
				list2.removeFirst();		
			}
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Problem2.list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		
		Problem2.list2 = new LinkedList<Integer>();
		list2.add(2);
		list2.add(4);
		list2.add(6);
		
		Thread t1 = new Thread(new Problem2()),t2 =new Thread(new Problem2()) ,
				t3= new Thread(new Problem2()),t4= new Thread(new Problem2());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		for(int i=0;i<result.size();i++) {
			System.out.print("result is" +Problem2.result.get(i));
		}
	}
}
