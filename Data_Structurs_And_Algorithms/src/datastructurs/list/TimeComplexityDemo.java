package datastructurs.list;

public class TimeComplexityDemo {

	public static void main(String[] args) {
		double now = System.currentTimeMillis();
		
		TimeComplexityDemo obj = new TimeComplexityDemo();
		obj.findSum(99999);
		
		System.out.println("Time Taken -"+(System.currentTimeMillis()-now)+" milisec");
	}
//	public int findSum(int n)
//	{
//		return n*(n+1)/2;
//	}
	
	public int findSum(int n)
	{
		int sum = 0;
		for(int i =0;i<=n;i++)
		{
			sum = sum +i;
		}
		return sum;
	}

}
