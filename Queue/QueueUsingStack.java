/*
 * We use two stacks, stack1 in which elements
 * are inserted during enQueue() and stack2 which is used
 * to push all elements from stack1 during deQueue().
 * We insert new elements into stack2 from stack1 only
 * if it is empty.
 * using stack2 during deQueue is more efficient then during 
 * enQueue.
 * Stack using array
 */
package Queue;

public class QueueUsingStack 
{
	int top1, top2;
	int size;
	int[] stack1, stack2;

	//constructor:
	private QueueUsingStack(int arraySize)
	{
		size = arraySize;
		this.stack1 = new int[size];
		this.stack2 = new int[size];
		top1 = -1;
		top2 = -1;
	}
	
	private void push1(int value)
	{
		if(isFull(top1))
		{
			System.out.println("Stack is full");
		}
		else
		{
			top1 += 1;
			stack1[top1] = value;
		}
	}
	
	private void push2(int value)
	{
		if(isFull(top2))
		{
			System.out.println("Stack is full");
		}
		else
		{
			top2 += 1;
			stack2[top2] = value;
			//System.out.println("pushing value: "+value+" in stack2");
		}
	}
	
	private int pop1()
	{
		if(isEmpty(top1))
		{
			System.out.println("Stack1 is empty");
			return -1;
		}
		else
			return stack1[top1--];
	}
	
	private int pop2()
	{
		if(isEmpty(top2))
		{
			System.out.println("Stack2 is empty");
			return -1;
		}
		else
			return stack2[top2--];
	}
	
	private boolean isFull(int top)
	{
		if((top+1)==size)
			return true;
		else
			return false;
	}
	
	private boolean isEmpty(int top)
	{
		if(top==-1)
			return true;
		else
			return false;
	}
	private void enQueue(int value)
	{
		push1(value);
	}
	
	private int deQueue()
	{
		if((stack2.length == 0)&&(stack1.length == 0))
		{
			System.out.println("No element");
			return -1;
		}
		else
		{
			if(isEmpty(top2))
			{
				while(top1!=-1)
					push2(pop1());
			}
			int temp = pop2();
			return temp;
		}
	}
	public static void main(String[] args) 
	{
		QueueUsingStack qs = new QueueUsingStack(5);
		qs.enQueue(1);
		qs.enQueue(2);
		int temp = qs.deQueue();
		System.out.println("deQueue: "+temp);
		int temp1 = qs.deQueue();
		System.out.println("deQueue: "+temp1);
		qs.enQueue(3);
		qs.enQueue(4);
		qs.enQueue(5);
		int temp2 = qs.deQueue();
		System.out.println("deQueue: "+temp2);
	}

}

