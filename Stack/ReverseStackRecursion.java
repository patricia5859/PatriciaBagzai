package Stack;

public class ReverseStackRecursion 
{
	int size;
	int[] stack;
	int top;
	
	//constructor
	private ReverseStackRecursion(int arraySize)
	{
		size = arraySize;
		stack = new int[size];
		top =-1;
	}
	
	private void push(int value)
	{
		if((top+1) == size)
			System.out.println("Stack is full");
		else
		{
			top += 1;
			stack[top] = value;
		}
	}
	
	private int pop()
	{
		if(top == -1)
		{
			System.out.println("Stack is empty");
			return -1;
		}
		else
			return stack[top--];
	}
	
	private int peek()
	{
		if(top == -1)
		{
			System.out.println("Stack is empty");
			return -1;
		}
		else
			return stack[top];
	}
	
	private boolean isEmpty()
	{
		if(top == -1)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args)
	{
		

	}

}
