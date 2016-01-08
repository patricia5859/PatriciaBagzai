package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class SwapLinkedList 
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
	public SwapLinkedList swapLinkedList(SwapLinkedList llist, int key1, int key2)
	{
		Node n = llist.head;
		if(llist.head.getData() != key1)
		{
			while(n.next.getData() != key1)
			{
				n = n.next;
			}
			Node prev1 = n;
			System.out.println("prev1:"+prev1.getData());
			Node node1 = n.next;
			System.out.println("node1:"+node1.getData());
			n = llist.head;
			while(n.next.getData() != key2)
			{
				n = n.next;
			}
			Node prev2 = n;
			System.out.println("prev2:"+prev2.getData());
			Node node2 = n.next;
			Node temp = node2.next;
			//if nodes are adjacent:
			if(node1.next == node2)
			{
				prev1.next = node2;
				node2.next = node1;
			}
			else
			{
				//most trivial case:
				prev1.next = node2;
				node2.next = node1.next;
				prev2.next = node1;
			}
			node1.next = temp;
		}
		else
		{
			// if first element is head:
			Node node1 = llist.head;
			Node n1 = llist.head;
			while(n1.next.getData() != key2)
			{
				n1 = n1.next;
			}
			Node prev2 = n1;
			Node node2  = n1.next;
			Node temp = node2.next;
			if(llist.head.next == node2)
			{
				// swaping head with its adjacent one:
				llist.head = node2;
				node2.next = node1;
			}
			else
			{
				//code to swap head when not adjacent:
				llist.head = node2;
				node2.next = node1.next;
				prev2.next = node1;
			}
			node1.next = temp;
		
		}
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
		SwapLinkedList sl = new SwapLinkedList();
		//SwapLinkedList sl2 = new SwapLinkedList();
		sl.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		
		sl.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		sl.printList();
		sl.swapLinkedList(sl,4,5);
		sl.printList();
	}
		
		
		
		
	
}
