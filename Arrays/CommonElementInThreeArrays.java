package Arrays;

public class CommonElementInThreeArrays 
{
	public void getCommonElements(int[] arr1, int[] arr2, int[] arr3, int n1, int n2, int n3)
	{
		int i=0, j=0, k=0;
		while((i<n1) && (j<n2) && (k<n3))
		{
			if((arr1[i] == arr2[j])&&(arr2[j] == arr3[k]))
			{
				System.out.println(arr1[i]);
				i++; j++; k++;
			}
			else 
			{
				if(arr1[i]<arr2[j])
					i++;
				else 
				{
					if(arr2[j]<arr3[k])
						j++;
					else
						k++;
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		int[] arr1 = {1,5,10,20,40,80};
		int[] arr2 = {6,7,20,80,100};
		int[] arr3 = {3,4,15,20,30,70,80,120};
		CommonElementInThreeArrays ct = new CommonElementInThreeArrays();
		ct.getCommonElements(arr1,arr2,arr3,arr1.length,arr2.length,arr3.length);
	}
}
