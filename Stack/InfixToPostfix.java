package Stack;

import java.util.Scanner;

public class InfixToPostfix 
{
	private String input;
	private String output = "";
	private int size;
	
	private Stack theStack;//reference to class Stack:

	public InfixToPostfix(int size)
	{	
		this.theStack = new Stack(size); //create stack:
	}
	
	//class stack containing basic functionality
	//push(), pop(), peek(), isEmpty(), display()
	//using char[]
	public static class Stack
	{
		int size;
		char[] stack;
		int top;
		
		public Stack(int arraySize)
		{
			size = arraySize;
			stack = new char[size];
			top = -1;
		}
		
		public void push(char value)
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
		
		public char pop()
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

	public String doTrans(String in)
	{
		for(int i=0; i<in.length(); i++)
		{
			char ch = in.charAt(i);
			switch(ch)
			{
			case '(':
				theStack.push(ch);
				break;
			case '+':
			case '-':
				checkStack(ch, 1);
				break;
			case '*':
			case '/':
				checkStack(ch,2);
				break;
			case ')':
				getOperators();
				break;
			default://for numbers: 
				output = output + ch;
				//System.out.println("number in stack:"+output);
				break;
			}
		}
		//when expression gets over, return all operators from stack:
		while(!theStack.isEmpty())
		{
			output = output + theStack.pop();
		}
		return output;
	}
	
	public void checkStack(char ch, int prec1)
	{
		int prec2;
		while(!theStack.isEmpty())
		{
			char top = theStack.pop();
			if(top == '(')
				theStack.push(top);
			else
			{
				if(top == '+' || top == '-')
					prec2 = 1;
				else
					prec2 = 2;
				if(prec2 >= prec1)
					output = output + top;
				else
				{
					theStack.push(top);
					break;
				}
			}
		}
		theStack.push(ch);
	}
	
	public String getOperators()
	{
		while(theStack != null)
		{
			if(theStack.peek() == '(')
				break;
			else
				output = output + (""+theStack.pop());
		}
		return output;
	}
	

	public static void main(String args[])
	{
		String input;
		String output;
		int size;
		System.out.println("Enter string:");
		Scanner s = new Scanner(System.in);
		input = s.nextLine();
		size = input.length();
		InfixToPostfix inString = new InfixToPostfix(size);
		output = inString.doTrans(input);
		System.out.println("Postfix Expression:" + output);
	}

}
