package linkedlistds;

public class LinkedList {
	
	Node head;
	Node tail;
	

	public Node insert(int n) { //order is FIFO
		if(head==null) {
			head = new Node(n);
			tail = head;
		}
		else {
			tail.next = new Node(n);
			tail = tail.next;
		}
		return head;
	}
	
	public synchronized Node insertSorted(int n) { //order is ascending,
		if(head==null) {				// No requirement for tail here.
			head = new Node(n);
			tail = head;
		}
		else {
			Node temp = null;
			if(n<head.val) {
				temp = head;
				head = new Node(n);
				head.next = temp;
				return head;
			}
			Node node= head;
			while(node.next!=null && node.next.val<n) {
				node=node.next;
			}
			temp = node.next;
			node.next = new Node(n);
			node.next.next = temp;
			}
		return head;
	}
	
	public void print() {
		if(head==null) return;
		Node node= head;
		while(node.next!=null) {
			System.out.print(node.val+",");
			node=node.next;
		}
		System.out.println(node.val);
	}

}
