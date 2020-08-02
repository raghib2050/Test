package testObject;

import java.util.HashMap;

public class A {
	
	public HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public void putInMap()
	{
		map.put("abc", 1);
		map.put("def", 2);
		map.put("ghi", 3);
	}
	
	
	public static void main(String[] args)
	{
		A obj = new A();
		obj.putInMap();
		System.out.println(obj.map);
	}

}
