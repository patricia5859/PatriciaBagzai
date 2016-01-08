package Stack;

import java.util.Scanner;

public class NextGreaterElement
{

	private int[] a;
	private void findNextGreater(int[] a)
	{
		int i=0, j=0;
		boolean flag = true;
		for(i=0; i<a.length; i++)
		{
			flag = true;
			for(j=(i+1); j<a.length; j++)
			{
				if(a[j] > a[i])
				{
					System.out.println(a[i] + "----->" + a[j]);
					break;
				}
				else
					flag = false;
			}
			if(flag == false)									//if no greater element found: 
				System.out.println(a[i] + "----->" + "-1");
			if((i+1) == a.length)								//for the last element:
				System.out.println(a[i] + "---->" + "-1");
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter size of array:");
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		System.out.println("Enter elements of array:");
		int[] array = new int[size];
		for(int i=0; i<size; i++)
		{
			array[i] = s.nextInt();
		}
		NextGreaterElement ng = new NextGreaterElement();
		ng.findNextGreater(array);

	}

}
