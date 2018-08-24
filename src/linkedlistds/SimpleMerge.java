package linkedlistds;

/*
 * Both list are already sorted need to merge them in 
 * new list in ascending order
 */
public class SimpleMerge {

	public static void main(String[] args) {
		LinkedList list1= new LinkedList();
		list1.insert(1);
		list1.insert(3);
		list1.insert(5);
		LinkedList list2= new LinkedList();
		list2.insert(2);
		list2.insert(4);
		list2.insert(4);
		list2.insert(6);
		LinkedList list3 = merge(list1.head,list2.head);
		list3.print();
	}
	
	public static LinkedList merge(Node head1,Node head2) {
		LinkedList result = new LinkedList();
		Node x= head1; Node y= head2;
		while(x!=null || y!=null) {
			if(x==null) {
				result.tail.next=y;
				break;
			}
			if(y==null) {
				result.tail.next=x;
				break;
			}
			if(x.val<y.val) {
				result.insert(x.val);
				x=x.next;
			}
			else{
				result.insert(y.val);
				y=y.next;
			}
		}
		return result;
	}

}
