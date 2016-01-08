/*
 * n daily prices, find span for each day 
 * where span Si on day i is defined as maximum number of consecutive days
 * just before the given day, for which price on current day
 * is less than price of given day, EX--price[100,80,60,70,60,75,85]
 * S[1,1,1,2,1,4,6]
 * using stack we enhance the time complexity, by not traversing array 
 * twice each time
 */

package Stack;

import java.util.Scanner;

public class StockSpanProblem 
{
		
	//Constructor:
	/*private StockSpanProblem(int arraySize)
	{
		size = arraySize;
		stack = new int[size];
		top = -1;
	}*/
	private static class Stack
	{
		int size;
		static int[] stack;
		int top;

		private Stack(int arraySize)
		{
			size = arraySize;
			stack = new int[size];
			top = -1;
		}
		
		private void push(int value)
		{
			top += 1;
			stack[top] = value;
		}
		
		private int pop()
		{
			if((top+1) == size)
			{
				System.out.println("Stack is empty");
				return -1;
			}
			else
				return stack[top--];
		}
		
		private int peek()
		{
			if((top+1) == size)
			{
				System.out.println("Stack is empty");
				return -1;
			}
			else
				return stack[top];
		}
		
		private boolean isEmpty()
		{
			if((top+1) == size)
				return true;
			else
				return false;
		}

	}
		
	private int[] calculateSpan(int[] prices, int n)
	{
		//create a stack and push index of first element to it 
		 Stack stack = new Stack(n); 
		 stack.push(0);
		 
		 //create an array for Span values
		 int S[] = new int[n];
		 //First element of Span will always have S as 1
		 S[0] = 1;
		 
		 //Calculate span values for each of the elements:
		 for(int i=1; i<n; i++)
		 {
			 //pop out the indexes from stack if their elements value is 
			 //less than element at ith position 
			 while((!stack.isEmpty()) && (prices[stack.peek()] <= prices[i]))
			 stack.pop();
			 
			 //now calculate S for ith element:
			 if(stack.isEmpty())
				 S[i] = i + 1; // all the values prior to element at ith position were smaller than element at ith position
			 else
				 //stack.peek() will give index of that element which is 
				 //greater than element at ith position
				 S[i] = i - stack.peek();
			 
			 //push this element to stack:
			 stack.push(i);
		 }
		 return S;
	}
	

	public static void main(String[] args) 
	{
		System.out.println("Enter size of array:");
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int S[] = new int[size]; //will store S values for each day
		int prices[] = new int[size];
		System.out.println("Enter prices");
		for(int i=0; i<size; i++)
		{
			prices[i] = s.nextInt();
		}
		StockSpanProblem sp = new StockSpanProblem();
		//calling calculate span method:
		S = sp.calculateSpan(prices, size);
		System.out.println("Span values:");
		for(int i=0; i<size; i++)
		{
			System.out.println(prices[i] + " ----> " + S[i]);
		}
	}

}
