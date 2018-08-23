package linkedlistds;

//using custom implementation of LinkedList
//when other both list are sorted
public class Problem2Sorted implements Runnable {

	static LinkedList list1; static LinkedList list2;
	static LinkedList result;
	public void run() {
		if(result==null) {
			result = new LinkedList();
		}
		while(list1.head!=null && list2.head!=null) {
			//System.out.println(Thread.currentThread().getName());
			if(list1.head==null) {
				result.tail.next = list2.head;
				break;
			}
			if(list2.head==null) {
				result.tail.next = list2.head;
				break;
			}
			if(list1.head.val<list2.head.val) {
				result.insert(list1.head.val);
				list1.head=list1.head.next;
			}
			else {
				result.insert(list2.head.val);
				list2.head=list2.head.next;					
			}
			
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Problem2Sorted.list1 = new LinkedList();
		list1.insert(1);
		list1.insert(3);
		list1.insert(5);
		
		Problem2Sorted.list2 = new LinkedList();
		list2.insert(2);
		list2.insert(4);
		list2.insert(6);
		
		Thread t1 = new Thread(new Problem2Sorted()),t2 =new Thread(new Problem2Sorted()) ,
				t3= new Thread(new Problem2Sorted()),t4= new Thread(new Problem2Sorted());
		t1.start();
		/*t2.start();  //No requirement for threads here, Only can be added if there's bulk data in Lists
		t3.start();
		t4.start();*/
		t1.join();
		/*t2.join();
		t3.join();
		t4.join();*/
		Problem2Sorted.result.print();
	}
}
