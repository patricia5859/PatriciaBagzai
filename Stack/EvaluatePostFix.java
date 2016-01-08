//will work for single digit numbers only

package Stack;

import java.util.Scanner;

public class EvaluatePostFix 
{
	
	public static class Stack
	{
		int top;
		int[] stack;
		int size;
		
		public Stack(int arraySize)
		{
			size = arraySize;
			stack = new int[size];
			top = -1;
		}
		
		public void push(int value)
		{
			if((top+1) == size)
				System.out.println("Stack is full");
			else
			{
				top +=1;
				stack[top] = value;
			}
		}
		
		public int pop()
		{
			if(top == -1)
			{
				System.out.println("Stack is empty");
				return 0;
			}
			else
				return stack[top--];
		}
		
		public int peek()
		{
			if(top == -1)
			{
				System.out.println("Stack is empty");
				return 0;
			}
			else
				return stack[top];
		}
		
		public void isEmpty()
		{
			if(top == -1)
			{
				System.out.println("Stack is empty");
			}
			else
				System.out.println("Stack contains elements");
		}
	}

	private Stack theStack;
	public EvaluatePostFix(int size) 
	{
		this.theStack = new Stack(size);
	}
	public void evaluateExpr(String s)
	{
		for(int i=0; i<s.length(); i++)
		{
			
			char ch = s.charAt(i);
			switch(ch)
			{
			case '+':
			case '-':
			case '*':
			case '/':
				getOperands(ch);
				break;
			case ' ':
				break;
			default:
				theStack.push(Integer.parseInt(""+ch));
				break;
			}
		}
		System.out.println("Result:"+theStack.pop());
	}
	
	public void getOperands(char ch)
	{
		int a = theStack.pop();
		int b = theStack.pop();
		int c;
		if(ch == '+')
			c = a+b;
		else
			if(ch == '-')
				c = b-a;
			else
				if(ch == '*')
					c = a*b;
				else
					c = b/a;
		theStack.push(c);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter PostFix Expression:");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		int size = input.length();
		EvaluatePostFix ep = new EvaluatePostFix(size);
		ep.evaluateExpr(input);
	}

}
