package com.demo.server;

import com.demo.dao.employeeDAO;

public class employeeservice {
	private employeeDAO empdao;
	public  employeeservice()
	{
		empdao=new employeeDAO();	
	}
	public void insertDetails()
	{
		empdao.insertDetails();
	}
	public void displaydetails()
	{
		empdao.displayDetails();
	}
	public void display()
	{
		empdao.display();
	}
	public void delete()
	{
		empdao.delete();
	}
	public void update()
	{
		empdao.update();
	}
	

}
