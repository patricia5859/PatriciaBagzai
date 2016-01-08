import java.util.Scanner;


public class palindrome2 {

	public void isPalindrome()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number:");
		int n = s.nextInt();
		if(n==reverse(n))
		{
			System.out.println("Number is palindrome");
		}
		else
		{
			System.out.println("Number is not palindrome");
		}
	}
	public int reverse(int n)
	{
		int reverseNumber = 0;
		while(n!=0)
		{
			int rem = n%10;
			reverseNumber = (reverseNumber*10) + rem;
			n = n/10;
		}
		return reverseNumber;
	}
	public static void main(String[] args) {
		
		palindrome2 obj = new palindrome2();
		obj.isPalindrome();

	}

}
