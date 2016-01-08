package CircularLinkedList;
import LinkedList.Node;

public class CircularLinkedList 
{	
	Node first;

	public static void main(String[] args) 
	{
		CircularLinkedList clist = new CircularLinkedList();
		CircularLinkedList subList1 = new CircularLinkedList();
		CircularLinkedList subList2 = new CircularLinkedList();
		clist.first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5); 
		Node sixth = new Node(6);
		
		//coonecting nodes:
		clist.first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = clist.first;
		
		//Uncomment to see all circular nodes:
		//TraverseCLList.printList(clist);
		
		//Uncomment to split into two halves:
		//SplitCLList.splitCLList(clist, subList1, subList2);
		//TraverseCLList.printList(subList1);
		
		//Uncomment to insert into sorted list: and delete element 4 in above list
		// and manage the refrences for 3rd to fifth:
		//TraverseCLList.printList(clist);
		//InsertIntoSortedList.insertIntoSortedList(clist, 4);
		//TraverseCLList.printList(clist);
	}

}
