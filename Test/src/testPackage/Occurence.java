package testPackage;

import java.util.Arrays;

public class Occurence {
	
	public static String input;
	
	public static void main(String[] args)
	{
//		this.input = input.replaceAll(" ", "");
		input = "Grass is greener on the other side".toLowerCase().replaceAll(" ", "");
		char[] strToCharArray = input.toCharArray();
		Arrays.sort(strToCharArray);
		int length = strToCharArray.length;
		int k = 0;
		int ctr = 1;
		int maxValue = 1;
		char maxChar  = '\0';
		while(k<length)
		{
			if(k+1 == length)
				break;
			if(strToCharArray[k] == strToCharArray[k+1])
				ctr++;
			else
			{
				if(ctr>maxValue)
				{
					maxValue = ctr;
					maxChar = strToCharArray[k];
				}
				ctr = 1;			
			}
			k++;
		}
		
//		return maxChar;
		System.out.println(maxChar);
	}
	
//	public static void main(String[] args)
//	{
//		Occurence obj = new Occurence();
//		System.out.println(obj.count("Hello World"));
//	}

}
