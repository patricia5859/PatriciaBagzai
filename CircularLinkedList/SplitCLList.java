package CircularLinkedList;
import LinkedList.Node;

public class SplitCLList {

	public static void splitCLList(CircularLinkedList clist, CircularLinkedList subList1, CircularLinkedList subList2)
	{
		int count = TraverseCLList.printList(clist);
		subList1.first = clist.first;
		Node temp1 = clist.first;
		
		//creating first half:
		for(int i=1; i<(count/2); i++)
		{
			temp1 = temp1.next;
		}
		Node mid = temp1.next;
		temp1.next = clist.first;
		System.out.println("First list:");
		TraverseCLList.printList(subList1);
		
		//creating second half:
		subList2.first = mid;
		Node temp2 = mid;
		while(temp2.next != clist.first)
		{
			temp2 = temp2.next;
		}
		temp2.next = mid;
		System.out.println("Second list:");
		TraverseCLList.printList(subList2);
	}
}
