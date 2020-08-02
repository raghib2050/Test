package testPackage;

import java.util.Arrays;

public class FrequencyOfCharacters {

	String input;
	public void count(String input)
	{
		this.input = input;
		char[] strToCharArray = input.toLowerCase().toCharArray();
		int length = strToCharArray.length;
		Arrays.sort(strToCharArray);
		
		System.out.println(strToCharArray);
		
		int k = 0;
		int ctr = 1;
		
		while(k<length)
		{
			if((k+1)!= length)
			{
				if(strToCharArray[k] == strToCharArray[k+1])
					ctr++;
				else {
					System.out.println(strToCharArray[k] + "=>" + ctr);
					ctr = 1;
				}
			}
			else {
				System.out.println(strToCharArray[k] + "=>" + ctr);
			}
			k++;
		}
	}
	
	public static void main(String[] args)
	{
		FrequencyOfCharacters obj = new FrequencyOfCharacters();
		obj.count("beginnersbook");
	}
	
}
