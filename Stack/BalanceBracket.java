package Stack;

import java.util.Scanner;

public class BalanceBracket 
{
	private Stack theStack;
	private BalanceBracket(int arraySize)
	{
		this.theStack = new Stack(arraySize);
	}
	
	private static class Stack
	{
		int size;
		char[] stack;
		int top;
		char a = 'a';// a default character
		
		private Stack(int arraySize)
		{
			size = arraySize;
			stack = new char[size];
			top = -1;
		}
		
		private void push(char ch)
		{
			if((top+1) == size)
				System.out.println("Stack is full");
			else
			{
				top += 1;
				stack[top] = ch;
			}
		}
		
		private char pop()
		{
			if(top == -1)
			{
				System.out.println("Stack is empty");
				return a;
			}
			else
				return stack[top--];
		}
		
		private char peek()
		{
			if(top == -1)
			{
				System.out.println("Stack is empty");
				return a;
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
	}

	private void balanceBracket(String input)
	{
		if((input.length()%2)!=0)
		{
			System.out.println("Invalid");
		}
		else
		{
			boolean flag = true;
			for(int i=0; i<input.length(); i++)
			{
				char ch = input.charAt(i);
				if((ch == '(')||(ch == '[')||(ch == '{'))
					theStack.push(ch);
				else
				{
					if(ch == ')')
						if(theStack.peek() == '(')
							theStack.pop();
						else
						{
							System.out.println("Invalid");
							flag = false;
							break;
						}
					else
					{
						if(ch == ']')
							if(theStack.peek() == '[')
								theStack.pop();
							else
							{
								System.out.println("Invalid");
								flag = false;
								break;
							}
						if(ch == '}')
							if(theStack.peek() == '{')
								theStack.pop();
							else
							{
								System.out.println("Invalid");
								flag = false;
								break;
							}
					}
				}
			}
			if(flag)
				System.out.println("Valid");
		}
		
		
	}
	public static void main(String[] args) 
	{
		System.out.println("Enter string of brackets:");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		int size = input.length();
		BalanceBracket b = new BalanceBracket(size);
		b.balanceBracket(input);

	}

}
