package Stack;

import java.util.Scanner;

public class ReverseString
{
	private String output = "";
	private Stack theStack;
	private ReverseString(int arraySize)
	{
		this.theStack = new Stack(arraySize);
	}
	
	public String reverseString(String input)
	{
		for(int i=0; i<input.length(); i++)
		{
			char ch = input.charAt(i);
			theStack.push(ch);
		}
		while(!theStack.isEmpty())
		{
			output = output + (""+theStack.pop());
		}
		return output;
	}
	public static class Stack
	{
		int size;
		char[] stack;
		int top;
		//A default value
		char a = 'a';
		
		//Constructor:
		private Stack(int arraySize)
		{
			size = arraySize;
			stack = new char[size];
			top = -1;
		}
		
		private void push(char ch)
		{
			if((top+1)==size)
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
			{
				return stack[top--];
			}
		}
		
		private char peek()
		{
			if(top == -1)
			{
				System.out.println("Stack is empty");
				return a;
			}
			else
			{
				return stack[top];
			}
		}
		private boolean isEmpty()
		{
			if(top == -1)
				return true;
			else
				return false;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Enter a string");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		int size = input.length();
		ReverseString rs = new ReverseString(size);
		String output = rs.reverseString(input);
		System.out.println("Reverse String: "+ output);
	}

}
