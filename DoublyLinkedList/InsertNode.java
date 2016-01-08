package DoublyLinkedList;

import LinkedList.SwapLinkedList.Node;

public class InsertNode {

	Node head;
	// made this class as static because main() is static and
		// can access only static 
	public static class Node
	{
		int data;
		Node prev;
		Node next;
		
		//Constructor:
		Node(int d)
		{
			data = d;
			next = null;
			prev = null;
		}
	}
	
	public void insertAtFront(InsertNode in, int key)
	{
		if(in.head == null)
		{
			in.head = new Node(key);
			System.out.println("List:"+ head.data);
		}
		else
		{
			Node newNode = new Node(key);
			newNode.next = in.head;
			in.head.prev = newNode;
			in.head = newNode;
			printList(newNode);
		}
	}
	
	public void insertAfter(Node prevNode, int key)//2,-2
	{
		Node newNode = new Node(key);
		Node temp = prevNode.next;//3
		prevNode.next = newNode;//2 -> -2
		newNode.prev = prevNode;//2 <- -2
		newNode.next = temp;//-2 -> 3
		temp.prev = newNode;//-2 <- 3
	}
	
	public void insertBefore(Node nextNode, int key)//(5,-4)
	{
		Node newNode = new Node(key);
		Node temp = nextNode.prev;//4
		newNode.next = nextNode;//-4 -> 5
		newNode.prev = temp;//-4 <- -5
		temp.next = newNode;
		nextNode.prev = newNode;//-4 <- 5
	}
	
	public void insertEnd(InsertNode in, int key)
	{
		Node newNode = new Node(key);
		Node n = in.head;
		while(n.next != null)
		{
			n = n.next;
		}
		n.next = newNode;
		newNode.prev = n;
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
	
		InsertNode in = new InsertNode();
		in.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		
		in.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		second.prev = in.head;
		third.prev = second;
		fourth.prev = third;
		fifth.prev = fourth;

		in.printList(in.head);
		/*System.out.println("Head.prev: "+in.head.prev);
		System.out.println("Last.next:" + fifth.next);
		System.out.println("Third.next.data:" + third.next.data);
		System.out.println("Third.prev.data:" + third.prev.data);*/
		
		in.insertAtFront(in,0);
		System.out.println("inserting -2 in between:");
		in.insertAfter(second, -2);
		in.printList(in.head);
		
		in.insertEnd(in, 6);
		System.out.println("Inserting 6 at the end of the list:");
		in.printList(in.head);
		
		in.insertBefore(fifth, -4);
		System.out.println("Inserting -4 before 5");
		in.printList(in.head);
	}

}
