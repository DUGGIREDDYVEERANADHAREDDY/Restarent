package com.demo.menu;
import java.util.*;

import com.demo.server.employeeservice;

public class Menu {
	Scanner sc;
	employeeservice empser;
	public Menu()
	{
		empser = new employeeservice();
	}
	public void displayMenu()
	{
		sc = new Scanner(System.in);
		String choice="y";
		int ch =0;
		while(choice.equals("y"))
		{
			System.out.println("enter the choice");
			System.out.println("1.insert employeee");
			System.out.println("2.delete");
			System.out.println("3.update");
			System.out.println("4.view");
			System.out.println("5.exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				empser.insertDetails();
				break;
			case 2:
				empser.delete();
				empser.display();
				break;
			case 3:
				empser.update();
				empser.display();
				
				break;
			case 4:
				empser.displaydetails();
				break;
			case 5:
				System.exit(0);	
			}
			System.out.println("you want  to continie y/n");
			choice=sc.next();
		}
	}
	

}
