package CircularLinkedList;
import LinkedList.Node;

public class InsertIntoSortedList 
{
	public static CircularLinkedList insertIntoSortedList(CircularLinkedList clist, int d)
	{
		Node newNode = new Node(d);
		Node temp = clist.first;
		while(temp != null)
		{
			if(temp.next.data > d)
			{
				break;
			}
			temp = temp.next;
		}
		Node x = temp.next;
		temp.next = newNode;
		newNode.next = x;
		return clist;
	}
}
