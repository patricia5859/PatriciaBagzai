/*
 * maintain three arrays: see below
 * and a variable free which points to a free location where new
 * element can be inserted
 */
package Stack;

import java.util.Scanner;

public class kStacksOneArray 
{
	int[] arr;//stores elements of stacks
	int[] top;//stores top of all stacks
	int[] next;//stores next of all elements
	int free = 0;
	
	//constructor
	private kStacksOneArray(int k, int n)
	{
		arr = new int[n];
		top = new int[k];
		next = new int[n];
		
		//initialize all top's of stacks as -1:
		for(int i=0; i<k; i++)
			top[i] = -1;
		
		//initialize next of all elements as next index
		//except for last
		for(int i=0; i<(n-1); i++)
				next[i] = i+1;
		
		//for last element next is -1:
		next[n-1] = -1;
	}
	
	//sn is the stack number
	private void push(int value, int sn)
	{
		if(free == -1)
			System.out.println("Stack is full");
		else
		{
			//initialize i as free position
			int i = free;
			
			//free as next of i which is empty now
			free = next[i];
			
			next[i] = top[sn];
			
			top[sn] = i;
			
			arr[i] = value;
		}
	}
	
	private int pop(int sn)
	{
		//i gets a position which will now be free
		int i = top[sn];
		
		top[sn] = next[i];
		
		//make i = free and previous free as next of i
		next[i] = free;
		free = i;
		
		return arr[i];
	}
	public static void main(String[] args) 
	{
		System.out.println("Enter number of stacks and size of array:");
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		int arraySize = s.nextInt();
		kStacksOneArray ks = new kStacksOneArray(k,arraySize);
		
		//push elements in stack 1
		 ks.push(15, 2);
		 ks.push(45, 2);
		 
		//push elements in stack 1
		 ks.push(17, 1);
		 ks.push(49, 1);
		 ks.push(39, 1);
		 
		//push elements in stack 0
		 ks.push(11, 0);
		 ks.push(9, 0);
		 ks.push(7, 0);
		 
		 
		System.out.println(ks.pop(2));
		System.out.println(ks.pop(1));
		System.out.println(ks.pop(0));
		
	}
}
