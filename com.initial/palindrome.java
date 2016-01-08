import java.util.Arrays;
import java.util.Scanner;


public class palindrome {

	public void checkPalindrome()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number:");
		int n = s.nextInt();
		//int q = n;
		int length = (int)(Math.log10(n)+1);
		System.out.println("Length of number:"+length);
		int check = 0;
		int a[] = new int[length];
		int r = 0, i = 0;
		while(n!=0)
		{
			r=n%10;
			n=n/10;
			a[i] = r;
			i++;
		}
		System.out.println(Arrays.toString(a));
		for(i=0; i<(length/2); i++)
		{
			if(a[i] != a[length-1])
			{
				check=1;
				break;
			}
			else
			{
				check = 0;
			}
			length -=1;	
		}
		if(check==0)
		{
			System.out.println("Number is palindrome");
		}
		else
		{
			System.out.println("Number is not a palindrome");
		}
	}
	
	public static void main(String[] args) {
		
		palindrome p = new palindrome();
		p.checkPalindrome();
	}

}
