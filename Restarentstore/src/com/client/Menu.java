package com.client;
import java.util.*;

import com.service.Service;
public class Menu {
	Service service;
	Scanner sc;
	
	public Menu()
	{
		service =new Service();
		sc= new Scanner(System.in);
	}
	
	
	public void displaymenu()
	{
		String choice="y";
		int ch=0;
		while(choice.equals("y"))
		{
			System.out.println("1.login username and password");
			System.out.println("2.existing user");
			System.out.println("3.insert items");
			System.out.println("4.retrive data");
			System.out.println("5.orderitems");
			System.out.println("6.history");
			System.out.println("7.cart");
			System.out.println("9.exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				//service.newuser();
				//break;
			case 2:
				service.existinguser();
				String choice1="y";
				int ch1=0;
				while(choice1.equals("y"))
				{
					System.out.println("1.you can register here");
					ch1=sc.nextInt();
					switch(ch1)
					{
					case 1:
						service.newuser();
						break;
					
					}
				}
				
				break;
			case 3:
				service.insertitems();
				break;
			case 4:
				service.retrivedata();
				break;
			case 5:
				service.orderitems();
				break;
			case 6:
				service.historyof();
				break;
			case 7:
				service.cart();
				break;
				
			case 9:
				System.exit(0);
				break;
				
			}
			System.out.println("you want to continue(y/n)");
			choice=sc.next();
		}
	}
	
	
	
	
	

}
