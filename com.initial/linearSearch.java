import java.util.Scanner;


public class linearSearch {

	public void inList()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = s.nextInt();
		int a[] = new int[size];
		System.out.println("Enter the elements of aaray:");
		for(int i=0; i<size; i++)
		{
			a[i] = s.nextInt();
		}
		int x =0;
		System.out.println("Enter the element to be searched:");
		int num = s.nextInt();
		for(int i=0; i<size; i++)
		{
			if(a[i] == num)
			{
				x = 1;
				break;
			}
			else
			{
				x = 0;
			}
		}
		if(x==1)
		{
			System.out.println("Number found");
		}
		else
		{
			System.out.println("Number not found");
		}
	}
	
	public static void main(String[] args) {
		
		linearSearch ls = new linearSearch();
		ls.inList();

	}

}
