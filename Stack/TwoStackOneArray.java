/*
 * Implementing two stacks in one array
 * top1 starting from first end and top2 starting 
 * from second end, utilizing space properly,
 * i.e. no fixed size for any of the arrays 
 * two methods: (push1, push2), (pop1, pop2)
 * if(top1+1 == top2)----> stack full
 * if(top2-1 == top1)----> stack full
 */

package Stack;

import java.util.Scanner;

public class TwoStackOneArray
{
	int size;
	int[] stack;
	int top1, top2;
	
	//constructor:
	private TwoStackOneArray(int arraySize)
	{
		size = arraySize;
		stack = new int[size];
		top1 = -1;
		top2 = size;
	}
	
	private void push1(int value)
	{
		if((top1+1) == top2)
			System.out.println("Stack is full");
		else
		{
			top1 += 1;
			stack[top1] = value; 
		}
	}
	
	private void push2(int value)
	{
		if((top2-1) == top1)
			System.out.println("Stack is full");
		else
		{
			top2 -= 1;
			stack[top2] = value; 
		}
	}
	
	private int pop1()
	{
		if(top1 == -1)
		{
			System.out.println("Stack is empty");
			return -1;
		}
		else
			return stack[top1--];
	}
	
	private int pop2()
	{
		if(top2 == (size-1))
		{
			System.out.println("Stack is empty");
			return -1;
		}
		else
			return stack[top2++];
	}
	
	private int peek1()
	{
		if(top1 == -1)
		{
			System.out.println("Stack is empty");
			return -1;
		}
		else
			return stack[top1];
	}
	
	private int peek2()
	{
		if(top2 == (size-1))
		{
			System.out.println("Stack is empty");
			return -1;
		}
		else
			return stack[top2];
	}
	
	private boolean isEmpty1()
	{
		if(top1 == -1)
			return true;
		else
			return false;
	}
	
	private boolean isEmpty2()
	{
		if(top2 == (size-1))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) 
	{
		TwoStackOneArray ts = new TwoStackOneArray(5);
		ts.push1(8);
		ts.push1(4);
		ts.push2(9);
		ts.push2(7);
		ts.push2(6);
		System.out.println(ts.peek1());
		System.out.println(ts.peek2());
		ts.push1(7);
	}

}
