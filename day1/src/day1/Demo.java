package day1;

public class Demo {
	private static Demo d1;
	private Demo()
	{
		
	}
	Demo d1getobj()
	{
		d1 = new Demo();
		return d1;
	}
	public void display1()
	{
		System.out.println("welcome to singelton  pattern");
	}
}
