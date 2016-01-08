package Stack;

import java.util.Scanner;

public class SortStackRecursion 
{
	public static class Stack
	{
		int size;
		int[] stack;
		int top;
		
		public Stack(int arraySize)
		{
			size = arraySize;
			stack = new int[size];
			top = -1;
		}
		
		public void push(int value)
		{
			if((top+1)==size)
			{
				System.out.println("Stack is full");
			}
			else
			{
				top +=1;
				stack[top] = value;
				//System.out.println("value entered:"+ stack[top]);
			}
		}
		
		public int pop()
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
		
		public int peek()
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
		
		public boolean isEmpty()
		{
			if(top==-1)
				return true;
			else 
				return false;
		}
	}
	
		
	private void sortStack(Stack a, Stack b)
	{
		b.push(a.pop());
		while(!a.isEmpty())
		{
			int x = a.pop();
			int y = b.peek();
			if(x>y)
				b.push(x);
			else
			{
				while(x<b.peek())
				{
					a.push(b.pop());
				}
				b.push(x);
			}
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Enter size of array:");
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int a[] = new int[size];
		Stack stack = new Stack(size);
		System.out.println("Enter elements of array:");
		/*for(int i=0; i<(size); i++)
		{
			stack.push(s.nextInt());
		}*/
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(9);
		stack.push(3);
		stack.push(6);
		SortStackRecursion sr = new SortStackRecursion();
		Stack newStack = new Stack(size);
		sr.sortStack(stack, newStack);
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
		System.out.println(newStack.pop());
	}

}
