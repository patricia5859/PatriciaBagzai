import java.util.Scanner;


public class binarySearch {

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
			int first = 0, last = (size-1);
			while(first<=last)
			{
				int  middle=(first+last)/2;
				if(num>a[middle])
				{
					first = middle+1;
				}
				else if(num == a[middle])
					{
						System.out.println("Number found at: "+ (middle+1));
						break;
					}
				else
					{	    last = middle-1;
					}
				
				}
			if(first>last)
			{
				System.out.println("Number not found");
			}
			}
			

		
	public static void main(String[] args) {
		 
		binarySearch bs = new binarySearch();
		bs.inList();

	}

}
