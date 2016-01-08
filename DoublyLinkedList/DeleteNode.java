package DoublyLinkedList;

import DoublyLinkedList.InsertNode.Node;

public class DeleteNode {

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
	
	public void deleteHeadNode(Node head,Node n)
	{
		if(n == head)
		{
			//delete head:
			System.out.println("Got head to delete");
			head = head.next;
			head.prev = null;
		}
		else
		{
			//delete last node:
			if(n.next == null)
			{
				Node temp = n.prev;
				temp.next = null;
			}
			else
			{
				//delete a node somewhere in between:
				Node prevNode = n.prev;
				Node nextNode = n.next;
				prevNode.next = n.next;
				nextNode.prev = prevNode;
				
			}
		}
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
		
		DeleteNode dn = new DeleteNode();
		dn.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		
		dn.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		second.prev = dn.head;
		third.prev = second;
		fourth.prev = third;
		fifth.prev = fourth;

		dn.printList(dn.head);
		System.out.println("Delete 4");
		dn.deleteHeadNode(dn.head, fourth);
		dn.printList(dn.head);
		
		System.out.println("Delete head");
		//dn.deleteHeadNode(dn.head, dn.head);
		//dn.printList(dn.head);
		
		//System.out.println("Delete 5");
		//dn.deleteHeadNode(dn.head, fifth);
		//dn.printList(dn.head);
	}

}
