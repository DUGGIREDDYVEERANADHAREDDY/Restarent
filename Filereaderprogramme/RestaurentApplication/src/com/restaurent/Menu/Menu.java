package com.restaurent.Menu;

import java.util.Scanner;

import com.restaurent.service.CustomerService;

public class Menu {
	private Scanner sc;
	private CustomerService customerservice;
	public Menu() {
		sc=new Scanner(System.in);
		customerservice=new CustomerService();
	}
	public void diplayMenu() {
		int ch=0;
		String choice="y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.println("*************************WELCOME*********************");
			System.out.println("1.Login as admin");
			System.out.println("2.Login as user");
			System.out.println("3.Registration");
			System.out.println("4.Exit");
			System.out.println("Enter your choie:");
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				break;
			case 2:customerservice.customerValidation();
				break;
			case 3:customerservice.Registration();
				break;
			case 4:
				System.exit(0);
				break;
			}
			System.out.println("do you want to continue(y/n):");
			choice=sc.next();
		}
	}
	public static void main(String[] args) {
		Menu menu=new Menu();
		menu.diplayMenu();
	}
}
