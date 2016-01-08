package Queue;

public class PetrolPump 
{
	int delta = 0;//stores difference of gas and distance at a station
	int upToNow = 0;//is > 0 if travel is possible from a station to next,
	//upToNow is mainly used to increment startPos
	int startPos = 0;//would be changed to i if upToNow at i is < 0
	int total = 0;//will check if (sum of all delta >= 0), i.e. whether overall travel is possible or not
	
	private int canCompleteCircle(int[] gas, int[] dis)
	{
		for(int i=0; i<gas.length; i++)
		{
			//System.out.println("gas.length:"+gas.length);
			int delta = gas[i] - dis[i];
			//System.out.println("delta:"+delta);
			if(upToNow>=0)
				upToNow += delta;
			else
			{
				upToNow = delta;
				startPos = i;
			}
			//System.out.println("uptonow:"+upToNow);
			total += delta;
		}
		//System.out.println("total:"+total);
		if(total>=0)
			return startPos;
		else
			return -1;
	}
	
	public static void main(String[] args) 
	{
		PetrolPump pt = new PetrolPump();
		int[] gas = {5,2,8};
		int[] distance = {6,3,6};
		System.out.println(pt.canCompleteCircle(gas,distance));
	}

}
