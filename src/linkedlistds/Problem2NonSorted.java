package linkedlistds;


//when the lists are not sorted
public class Problem2NonSorted implements Runnable {
	
	LinkedList list; 
	static LinkedList result;
	
	Problem2NonSorted(){
		list = new LinkedList();
	}
	
	public void run() {
		if(result==null) {
			result = new LinkedList();
		}
		while(list.head!=null) {
			//System.out.println(Thread.currentThread().getName());
			result.insertSorted(list.head.val);
			list.head=list.head.next;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Problem2NonSorted r1 = new Problem2NonSorted();
		r1.list.insert(5);
		r1.list.insert(3);
		r1.list.insert(1);
		Problem2NonSorted r2 = new Problem2NonSorted();
		r2.list.insert(2);
		r2.list.insert(6);
		r2.list.insert(4);
		r2.list.insert(4);
		Thread t1 = new Thread(r1,"player1"),
				t2 =new Thread(r2,"player2");
		
		t1.start();
		t2.start();

		t1.join();
		t2.join();
		Problem2NonSorted.result.print();
	}
}
