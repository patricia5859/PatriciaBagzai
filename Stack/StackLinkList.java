package Stack;

public class StackLinkList 
{
	Node top;
	
	//Constructor:
	public StackLinkList() 
	{
		top = null;
	}
	
	public static class Node
	{
		int data;
		Node next;
		
		//Constructor:
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	public void push(int value)
	{
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
	}
	
	public void pop()
	{
		if(top == null)
			System.out.println("Stack is empty");
		else
		{
			top = top.next;
		}
	}
	
	public void displayStack(StackLinkList lst)
	{
		if(lst == null)
			System.out.println("Stack is empty");
		else
		{
			Node n = top;
			while(n != null)
			{
				System.out.println("Data: "+n.data);
				n = n.next;
			}
		}
	}
	
	public void isEmpty(StackLinkList lst)
	{
		if(lst.top == null)
			System.out.println("Stack is empty");
		else
			System.out.println("Stack is not empty");
	}
	
	public static void main(String[] args) 
	{
		StackLinkList sl = new StackLinkList();
		sl.push(1);
		sl.push(2);
		sl.push(3);
		sl.push(4);
		sl.push(5);
		sl.displayStack(sl);
		sl.isEmpty(sl);
		sl.pop();
		sl.displayStack(sl);
		sl.push(5);
		sl.displayStack(sl);
	}

}
