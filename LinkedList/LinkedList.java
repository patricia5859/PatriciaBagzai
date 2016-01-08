package LinkedList;
public class LinkedList {

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
	public void insertFirst(Node n)
	{
		n.next = head;
		head = n;
	}
	
	//adding a node in between by passing a node after which new node is to be inserted:
	public void insertAfter(Node newNode, Node prevNode)
	{
		System.out.println("In insertAfter");
		newNode.next = prevNode.next;
		System.out.println("newNode.data:" + newNode.getData());
		prevNode.next = newNode;
		System.out.println("prevNode.data: "+ prevNode.getData());
	}
	// inserting a node at the end of the list:
	public void insertLast(Node newNode)
	{
		Node n = head;
		while(n.next != null)
		{
			n = n.next;
		}
		n.next = newNode;
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
	// adding a node at the start of the linked list
	
	
	// deleting a node with given key:
	public void deleteKey(int key)
	{
		System.out.println("In delete():");
		Node n = head;
		boolean flag = true;
		if(head.getData() != key)
		{	
			//here getData() is used since we had Node.java as 
			// separate file, but for now n.next.data will work
			while((n.next.getData() != key))
			{
				//handling not found case:
				if(n.next.next == null)
				{
					System.out.println("Not found");
					flag = false;
					break;
				}
				else
				{
					//System.out.println("In while:");
					//System.out.println("n.data: "+ n.data);
					n = n.next;
				}
			}
			//if element present in list:
			if(flag)
			{
				n.next = n.next.next;
			}
		}
		else
		{
			// if element present in head:
			head = head.next;
		}
		
	}
	// length of linked list:
	public void lenghtList()
	{
		int count = 0;
		Node n = head;
		if(n!=null)
		{
			while(n.next!=null)
			{
				count += 1;
				n = n.next;
			}
			System.out.println("Length of linked list: "+(count+1));
		}
		else
		{
			System.out.println("Length of linked list: "+ count);
		}
	}

	public static void main(String[] args) {
		
		
		 
		LinkedList llist = new LinkedList();
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(4);
		//System.out.println(llist.head.next);
		
		llist.head.next = second;
		//System.out.println(llist.head.next);
		//System.out.println("Head data: "+ llist.head.data);
		second.next = third;
		System.out.println("Calling printlist():");
		llist.printList();
		
		llist.insertFirst(new Node(0));
		System.out.println("Calling printlist():");
		llist.printList();
		//System.out.println(llist.head.data);
		//System.out.println(llist.head.next.data);
		llist.insertAfter(new Node(3), second);
		System.out.println("Calling printlist():");
		llist.printList();
		
		llist.insertLast(new Node(5));
		System.out.println("Calling printlist():");
		llist.printList();
		
		//uncomment to delete:
		//llist.deleteKey(3);
		//llist.deleteKey(0);
		//llist.deleteKey(7);
		//System.out.println("Calling printlist():");
		//llist.printList();
		
		//uncomment to find lenght of list:
		//llist.lenghtList();
		
		//uncomment ot swap nodes:
		//SwapLinkedList.swapLinkedList(llist,4,5);
		llist.printList();
		
		//uncomment to reverse the list:
		//ReverseLinkedList.reverseLinkedList(llist);
		llist.printList();
	}

}
