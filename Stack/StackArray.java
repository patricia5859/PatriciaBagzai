 package Stack;

public class StackArray 
{
	int size;
	int[] stack;
	int top;
	
	public void createStack(int arraySize)
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
			stack[top++] = value;
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
	
	
	public static void main(String[] args) 
	{
		StackArray st = new StackArray();
		st.createStack(5);
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		//st.pop();
		int value = st.peek();
		System.out.println(value);
		st.push(6);
		boolean b = st.isEmpty();
		System.out.println(b);

	}

}
