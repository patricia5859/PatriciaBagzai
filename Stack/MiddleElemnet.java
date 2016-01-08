/*
 * in order to find middle element we maintain a Node as "mid"
 * when a new Node is pushed into the stack
 * Ex: stack {1,2,3,4}, topmost element: 4
 * mid = 2
 * in order to delete mid element:
 * mid = 2, stack{1,2,4}
 * again delete: mid = 4
 */

package Stack;

import DoublyLinkedList.DeleteNode.Node;

public class MiddleElemnet 
{
	Node top;
	Node mid;
	int count = 0;
	//Constructor:
	private MiddleElemnet()
	{
		top = null;
	}
	
	private static class Node
	{
		int data;
		Node next;
		Node prev;
		
		//constructor:
		private Node(int d)
		{
			data = d;
			next = null;
			prev = null;
		}
	}
	
	private void push(int value)
	{
		Node newNode = new Node(value);
		//System.out.println("newNode.data: "+ newNode.data);
		newNode.next = top;
		if(top!=null)
			top.prev = newNode;
		top = newNode;
		count++;
		if(top.next == null)
			mid = top;
		else
		{
			//System.out.println("count: "+count);
			if(count%2 != 0)
				mid = mid.prev;
			//System.out.println("midData: "+mid.data);
		}
		//printList(top);
	}
	
	private int pop()
	{
		if(count == 1)
			mid = null;
		else
			if(count%2 == 0)
				mid = mid.next;
		int temp = top.data;
		top.next.prev = null;
		top = top.next;
		count -= 1;
		return temp;
	}
	
	private boolean isEmpty(MiddleElemnet me)
	{
		if(me.top == null)
			return true;
		else
			return false;
	}
	
	private int findMiddle()
	{
		return mid.data;
			
	}
	
	private void deleteMiddle()
	{
		if(count == 1)
			mid = top = null;
		else
		{
			if(count%2 == 0)
			{
				Node midPrev = mid.prev;
				Node midNext = mid.next;
				midPrev.next = midNext;
				midNext.prev = midPrev;
				mid = mid.prev;
				count--;
			}
			else
			{
				Node midPrev = mid.prev;
				Node midNext = mid.next;
				midPrev.next = midNext;
				midNext.prev = midPrev;
				mid = mid.next;
				count--;
				//System.out.println("midData: "+ mid.data);
			}
		}
		//printList(top);
	}
	
	public void printList(Node n)
	{
		while(n != null)
		{
			System.out.println("Data: "+ n.data);
			n = n.next;
		}
	}
	
	public static void main(String[] args) 
	{
		MiddleElemnet me = new MiddleElemnet();
		me.push(1);
		me.push(2);
		me.push(3);
		me.push(4);
		me.push(5);
		me.push(6);
		int mid = me.findMiddle();
		System.out.println(mid);
		me.deleteMiddle();
		int mid1 = me.findMiddle();
		System.out.println(mid1);
		me.deleteMiddle();
		int mid2 = me.findMiddle();
		System.out.println(mid2);
	}

}
