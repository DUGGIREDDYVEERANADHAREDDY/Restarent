package day1;
import java.util.*;

public class Second {
		/*System.out.println("Wellcome to  java");
		int n1= 12;
		int n2 =13;
		int result = n1+n2;
		System.out.println("total of n1 and n2 is- "+result);
		boolean result1 = true;
		System.out.println(result1);
		long mobile = 9652062330l;
		System.out.println(mobile);*/
		private int empid;
		private String name;
		private double salary;
		private int percentage;
		private Scanner sc;
		public void acceptdetail()
		{
		sc = new Scanner(System.in);
		System.out.println("enter the  id of the employee");
		empid= sc.nextInt();
		System.out.println("enter the name of the employee");
		name = sc.next();
		System.out.println("enter the salary of the employee");
		salary = sc.nextInt();
		//System.out.println("enter the percantage of the employee");
		//percentage= sc.nextInt();
		}
		public double calculatebonous() {
		    double bonous = 0.00;
		    if (salary > 30000 && salary < 50000) {
		        bonous = salary + (salary * 0.01);
		    } else if (salary > 50000 && salary < 100000) {
		        bonous = salary + (salary * 0.02);
		    } else if (salary >= 100000) {
		        System.out.println("Salary is greater than or equal to 100000");
		    } else {
		        System.out.println("Salary is less than 30000");
		    }
		    return bonous;
		}
		public void display()
		{
			System.out.println("the salary was add"+calculatebonous());
		}
		public static void main(String args[])
		{
		Second obj1 = new Second();
		obj1.acceptdetail();
		obj1.calculatebonous();
		obj1.display();
		}
		
}
