package Queue;
/*
 * notes in copy
 * maintain a circular list and thus we use
 * another variable "count" to look if queue is full. 
 */

public class QueueUsingArrays
{
	int front, rear, capacity, count, arr[];
	
	//constructor:
	private QueueUsingArrays(int size)
	{
		capacity = size;
		arr = new int[capacity];
		front = 0;
		rear = -1;
		count = 0;
	}
	
	private void enqueue(int value)
	{
		if(isFull())
		{
			System.out.println("Queue is full");
			return;
		}
		else
		{
			rear = (rear+1)%capacity;
			arr[rear] = value;
			count++;
		}
	}
	
	private int dequeue()
	{
		if(isEmpty())
			return -1;
		else
		{
			int temp = arr[front];
			front = (front+1)%capacity;
			count--;
			return temp;
		}
	}
	
	private boolean isFull()
	{
		if(count == capacity)
			return true;
		else 
			return false;
	}
	
	private boolean isEmpty()
	{
		if(count == 0)
			return true;
		else
			return false;
	}
	public static void main(String[] args) 
	{
		QueueUsingArrays bs = new QueueUsingArrays(5);
		bs.enqueue(1);
		//System.out.println("out:"+bs.dequeue());
		bs.enqueue(2);
		bs.enqueue(3);
		bs.enqueue(4);
		bs.enqueue(5);
		System.out.println("out:"+bs.dequeue());
		//bs.enqueue(6);
	}

}

