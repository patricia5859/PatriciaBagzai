
public class two_objects_sameClass {

	public void display(int a)
	{
		int count = a;
		for(int i=0;i<5;i++)
		{
			count += 1;
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		
		two_objects_sameClass obj1 = new two_objects_sameClass();
		two_objects_sameClass obj2 = new two_objects_sameClass();
		obj1.display(0);
		obj2.display(5);
		obj1.display(5);
		String s1 = "Welcome";
		String s2 = "Welcome";
		String s3 = "Welcome";
		String s4 = "Welcome";
		s1 = s1.concat(" Patricia");
		System.out.println("s1"+s1);
		System.out.println("s2"+s2);
		System.out.println("s3"+s3);
		System.out.println("s4"+s4);
	}

}
