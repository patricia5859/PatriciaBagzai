/*
 * enQueue() This operation adds a new node after rear and moves rear to the next node.
 * deQueue() This operation removes the front node and moves front to the next node.
 */

package Queue;

public class QueueLinkedList
{
	Node front;
	Node rear;
	
	public QueueLinkedList() 
	{
		front = null;
		rear = null;
	}
	private static class Node
	{
		int data;
		Node next;
		
		private Node(int d)
		{
			this.data = d;
			this.next = null;
		}
	}
	
	private void enQueue(int value)
	{
		Node newNode = new Node(value);
		if(rear == null)
		{
			front = newNode;
		}
		else
		{
			rear.next = newNode;
		}
		rear = newNode;
		
	}
	
	private int deQueue()
	{
		if(front == null)
		{
			System.out.println("Queue is empty");
			return -1;
		}
		else
		{
			int temp = front.data;
			front = front.next;
			return temp;
		}
	}
	
	public static void main(String[] args) 
	{
		QueueLinkedList ql = new QueueLinkedList();
		ql.enQueue(1);
		ql.enQueue(2);
		ql.enQueue(3);
		ql.enQueue(4);
		ql.enQueue(5);
		System.out.println(ql.deQueue());
		System.out.println(ql.deQueue());
		//System.out.println(ql.deQueue());
	}

}
