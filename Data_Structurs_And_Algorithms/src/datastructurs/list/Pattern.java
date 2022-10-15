package datastructurs.list;

public class Pattern {

	public static void main(String[] args) {
		
		
		String s = "SIVALINGAMP";
		
		for(int i=0;i<=s.length();i++)
		{
			for(int j=0;j<s.length();j++)
			{
				if(i==j || j == s.length()-i-1)
				{
					 char value = s.charAt(i);
					System.out.print(value);
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
