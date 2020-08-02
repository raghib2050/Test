package testPackage;

public class Double {
	
	public void sum(int a, double b)
	{
		System.out.println("First method");
	}
	
	public void sum(double a, int b)
	{
		System.out.println("Second method");
	}
	public static void main(String[] args)
	{
		Double obj = new Double();
		obj.sum(2, 6.0);
	}

}
