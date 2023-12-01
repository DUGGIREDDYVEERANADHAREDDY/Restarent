package com.demo.dao;
import java.util.*;

import com.demo.pojo.employee;

public class employeeDAO {
	private employee emparr[];
	Scanner sc;
	private employee er;
	public employeeDAO()
	{
		sc = new Scanner(System.in);
	}
	public void insertDetails()
	{
		System.out.println("enter the employee details stored");
		int index = sc.nextInt();
		emparr=new employee[index];
		for(int i =0;i<emparr.length;i++)
		{
			emparr[i]=new employee();
			System.out.println("enter the empid");
			emparr[i].setEmpid(sc.nextInt());
			System.out.println("enter the empname");
			emparr[i].setEmpname(sc.next());
			System.out.println("enter the salary");
			emparr[i].setSalary(sc.nextInt());
		}
	}
	public void displayDetails()
	{
		for(employee sr:emparr)
		{	
		System.out.println("employee id"+sr.getEmpid());
		System.out.println("employee name"+sr.getEmpname());
		System.out.println("enter the emp salary"+sr.getSalary());
		}
	}
	public void display()
	{
		for(employee e :emparr)
		{
			if(e!=null)
			{
				System.out.println("the delated  id is"+e.getEmpid());
			}
		}
	}
	public void update()
	{
		System.out.println("enter the number you want update");
		int x = sc.nextInt();
		for(employee e : emparr)
		{
			if(e.getEmpid()==x)
			{
				System.out.println("the update id  is "+e.getEmpid());
			}
		}
		
	}
	/*public void display() {
		System.out.println("the deatils are the"+displayDetails());
	}*/
	public void delete()
	{
		System.out.println("entr the number you wANT TO Delate");
		int x = sc.nextInt();
		for(int i =0;i<emparr.length;i++)
		{
			if(emparr[i].getEmpid()==i)
			{
				emparr[i]=null;
			}
		}
		
		
	}
	

}
