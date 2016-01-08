import java.util.Scanner;


public class substringExists {

	public void is_subString()
	{
		int a = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a string:");
		String fullstr = s.nextLine();
		System.out.println("Enter the string to be searched:");
		String substr = s.nextLine();
		for(int i=0; i<(fullstr.length()-substr.length()+1); i++)
		{
			String str = fullstr.substring(i, (substr.length()-1+i));
			if(str.equals(substr))
			{
				a = 1;
				break;
			}
			else {a =0;}
		}
		if(a==1)
			{
			System.out.println("Yes it is");
			}
		else
		{
			System.out.println("It is not");
		}
		if(fullstr.indexOf(substr) != -1)
		{
			System.out.println("Yes it is from indexOf");
		}
		else
		{
			System.out.println("No it is from indexOf");
		}
	}
	public static void main(String[] args) {
		
		substringExists se = new substringExists();
		se.is_subString();
	}

}
