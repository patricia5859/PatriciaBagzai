package Stack;

import java.util.Scanner;

public class ReverseStringRecursion 
{
	
	public static class Stack
	{
		int size;
		char[] stack;
		int top;
		//default character:
		char a = 'a';
		
		//constructor:
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
				System.out.println("stack is empty");
				return a;
			}
			else
				return stack[top--];
		}
		
		private void peek()
		{
			if(top == -1)
			{
				System.out.println("stack is empty");
			}
			else
				 System.out.println(stack[top]);
		}
		
		private boolean isEmpty()
		{
			if(top == -1)
				return true;
			else
				return false;
		}
	}
	
	private String output = "";
	private void fillStack(Stack s, String input)
	{
		for(int i=0; i<input.length(); i++)
		{
			char ch = input.charAt(i);
			s.push(ch);
		}
	}
	private String reverseStackRecursion(Stack s)
	{
		if(s.isEmpty()==true)
			return output;
		output = ""+s.pop() + reverseStackRecursion(s);
		return output;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter string to be reversed:");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		int length = input.length();
		ReverseStringRecursion rs = new ReverseStringRecursion();
		Stack newStack = new Stack(length);
		rs.fillStack(newStack, input);
		String result = rs.reverseStackRecursion(newStack);
		System.out.println("Reversed String :" + result);
	}

}
