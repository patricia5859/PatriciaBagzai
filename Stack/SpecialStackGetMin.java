
package Stack;

import java.util.Scanner;

public class SpecialStackGetMin
{

	int size;
	int[] stack;
	int top;
	
	//constructor:
	
	protected SpecialStackGetMin(){}
	protected SpecialStackGetMin(int arraySize)
	{
		size = arraySize;
		this.stack = new int[size];
		top = -1;
		System.out.println("Reached in base const:"+ this.size);
	}
	
	protected void push(int value)
	{
		if((top+1)==size)
		{
			System.out.println("Stack is full");
		}
		else
		{
			top +=1;
			stack[top] = value;
		}
	}
	
	protected int pop()
	{
		if(top == -1)
		{
			System.out.println("Stack is empty....");
			return 0;
		}
		else
		{
			return stack[top--];
		}
	}
	
	protected int peek()
	{
		if(top==-1)
		{
			System.out.println("Stack is empty");
			return 0;
		}
		else
		{
			return stack[top];
		}
	}
	
	protected boolean isEmpty()
	{
		if(top==-1)
			return true;
		else 
			return false;
	}
	
}
 
