package CircularLinkedList;
import LinkedList.Node;

public class TraverseCLList 
{
	public static int printList(CircularLinkedList clist)
	{
		int count = 0;
		Node temp = clist.first;
		do
		{
			count += 1;
			//System.out.println("Reached in printList()");
			System.out.println("Data:" + temp.getData());
			temp = temp.next;
		}while(temp != clist.first);
		System.out.println("Lenght of list:" + count);
		return count;
	}
}
