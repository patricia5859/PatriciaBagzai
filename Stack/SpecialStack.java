package Stack;
import Stack.SpecialStackGetMin;
/*
 * getMin() returns the minimum value from the stack.
 * We maintain an auxillary stack along with original stack
 * and while inserting the values in original stack,each value
 * is compared with auxillary's stack topmost value.
 * Topmost element of auxillary stack at the end is minimum.
 */


import java.util.Scanner;

 
public class SpecialStack extends SpecialStackGetMin
{
	SpecialStackGetMin sg;
	
	//constructor:
	SpecialStack(int arraySize)
	{
		super(arraySize);
		System.out.println("Reached in child constructor"+this.size);
		SpecialStackGetMin sg = new SpecialStackGetMin(arraySize);
		System.out.println("Reached in child constructor"+sg.size);
	}
	
	public void push(int value)
	{
		sg.push(value);
		if(this.isEmpty())
			this.push(value);
		else
		{
			int temp = this.pop();
			if(value < temp)
			{
				this.push(temp);
				this.push(value);
			}
		}
	}
	
	public int pop()
	{
		int temp = sg.pop();
		if(this.peek() == temp)
			this.pop();
		return temp;
	}
	
	private int getMin()
	{
		return this.peek();
	}
	public static void main(String[] args) 
	{
		SpecialStack st = new SpecialStack(5);
		//SpecialStackGetMin auxillaryStack = new SpecialStackGetMin(5);
		System.out.println("Enter elements");
		Scanner s = new Scanner(System.in);
		for(int i=0; i<5; i++)
		{
			int temp = s.nextInt();
			st.push(temp);
		}
		st.pop();
		System.out.println("Minimum is: "+st.getMin());
	}
}

