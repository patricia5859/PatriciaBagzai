import java.util.Scanner;

// Bubble sort:
public class sortedArray {

	public void sort()
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
		//int temp = a[0];
		
		for(int i=0; i<n; i++)
		{
			for(int j=i+1; j<n; j++)
			{
				if (a[i] >= a[j])
				{
					a[i] = a[i] + a[j];
					a[j] = a[i] - a[j];
					a[i] = a[i] - a[j];
				}
			}
			
		}
		for(int i=0; i<n; i++)
		{
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		
		sortedArray obj = new sortedArray();
		obj.sort();

	}

}
