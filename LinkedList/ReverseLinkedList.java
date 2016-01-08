package LinkedList;

import LinkedList.LinkedList.Node;

public class ReverseLinkedList 
{
	Node head;
	// made this class as static because main() is static and
	// can access only static 
	public static class Node
	{
		public int data;
		public Node next;
		
		// Constructor
		public Node(int d)
		{
			setData(d);
			next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
		
	}

	public ReverseLinkedList reverseLinkedList(ReverseLinkedList llist)
	{
		Node prev = null;
		while(llist.head != null)
		{
			Node temp = llist.head.next;
			llist.head.next = prev;
			prev = llist.head;
			llist.head = temp;
		}
		llist.head = prev;
		return llist;
	}

	public void printList()
    {
		int sum = 0;
        Node n = head;
        while (n != null)
        {
        	//System.out.println("In printlist:");
        	System.out.println("Data: " + n.getData());
        	//System.out.println("Next: " + n.next);
            n = n.next;
        }
        
    }
public static void main(String args[])
{
	ReverseLinkedList rl = new ReverseLinkedList();
	rl.head = new Node(1);
	Node second = new Node(2);
	Node third = new Node(3);
	
	rl.head.next = second;
	second.next = third;
	rl.printList();
	rl.reverseLinkedList(rl);
	rl.printList();
}
}