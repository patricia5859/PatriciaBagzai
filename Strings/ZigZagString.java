package Strings;

public class ZigZagString
{
	public void printZigZagString(String s, int n)
	{
		int row = 0;
		String arr[] = new String[n];
		boolean down = true;
		
		int len = s.length();
		for(int i=0; i<len; i++)
		{
			arr[row] = ""+s.charAt(i);
			System.out.println(arr[row]);
			if(row == 0)
				down = true;
			else if(row == (n-1))
				down = false;
			
			if(down)
				row++;
			else
				row--;
		}
		//StringBuffer sb = new StringBuffer();
		//for(String s1:arr)
			//sb.append(s);
		//System.out.println(sb);
		String s1 = new String();
		for(int i=0; i<n; i++)
			s1 += arr[i];
		System.out.println(s1);
	}
	public static void main(String args[])
	{
		String s = "GEEKSFORGEEKS";
		ZigZagString zs = new ZigZagString();
		zs.printZigZagString(s,3);
	}
}
