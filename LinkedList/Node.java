package LinkedList;


	public class Node
	{
		public int data;
		public Node next;
		
		// Constructor
		public Node(int d)
		{
			setData(d);
			next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
		
	}

