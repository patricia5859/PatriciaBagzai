package DoublyLinkedList;

import DoublyLinkedList.DeleteNode.Node;

public class ReverseDLList {

	Node head;
	// made this class as static because main() is static and
		// can access only static 
	public static class Node
	{
		int data;
		Node next;
		Node prev;
		
		// Constructor:
		Node(int d)
		{
			data = d;
			next = null;
			prev = null;
		}	
	}
	
	public ReverseDLList reverselist(ReverseDLList rl)
	{
		Node prev = null;
		//Node temp = rl.head.next;
		while(head != null)
		{
			Node temp = rl.head.next;
			head.next = prev;
			//only adding this to reverseof singly linked list:
			head.prev = temp;
			prev = head;
			head = temp;
		}
		head = prev;
		return rl;
	}
	public void printList(Node n)
	{
		while(n != null)
		{
			System.out.println("Data: "+ n.data);
			n = n.next;
		}
	}
	
	public static void main(String[] args) {

		ReverseDLList rl = new ReverseDLList();
		rl.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		
		rl.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		second.prev = rl.head;
		third.prev = second;
		fourth.prev = third;
		fifth.prev = fourth;

		rl.printList(rl.head);
		System.out.println("Calling reverseList():");
		rl.reverselist(rl);
		rl.printList(rl.head);

	}

}
