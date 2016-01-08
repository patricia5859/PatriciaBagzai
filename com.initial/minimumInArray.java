import java.util.Scanner;


public class minimumInArray {

	public int min()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int n = s.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the elements of array:");
		for(int i=0; i<n; i++)
		{
			a[i] = s.nextInt();
		}
		int temp = a[0];
		for(int i=0; i<n; i++)
		{
			if (temp>= a[i])
				temp = a[i];
		}
		return temp;
	}
	public static void main(String[] args) {
		
		minimumInArray obj = new minimumInArray();
		int res = obj.min();
		System.out.println("Smallest element: "+res);

	}

}
