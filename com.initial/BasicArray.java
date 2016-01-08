import java.util.Arrays;
import java.util.Scanner;


public class BasicArray {

	public void arrayElements()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int n = s.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements of array:");
		for(int i=0; i<n; i++)
		{
			a[i] = s.nextInt();
		}
		// printing values of array without for loop
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) 
	{
		BasicArray obj = new BasicArray() ;
		obj.arrayElements();
	}

}
