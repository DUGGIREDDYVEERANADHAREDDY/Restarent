package com.restaurent.service;

import java.util.Scanner;

import com.restaurent.DAO.CustomerDAO;
import com.restaurent.pojo.Customer;

public class CustomerService {
	private Scanner sc;
	private CustomerDAO customerdao;
	int customerid=1111;
	public CustomerService() {
		sc=new Scanner(System.in);
		customerdao=new CustomerDAO();
	}
	public void customerValidation() {
		System.out.println("Enter customer name:");
		String customername=sc.next();
		System.out.println("Enter Customer password:");
		String password=sc.next();
		customerdao.validateCustomer(customername,password);
	}
	public void Registration() {
		System.out.println("*****************Welcome to Registration***************************");
		Customer cobj=new Customer();
		
		System.out.println("enter user name:");
		cobj.setCustomername(sc.next());
		System.out.println("Enter Emailid:");
		cobj.setEmailid(sc.next());
		System.out.println("Enter Password:");
		cobj.setPassword(sc.next());
		System.out.println("Enter Address:");
		cobj.setAddress(sc.next());
		System.out.println("enter Mobile numbber:");
		cobj.setMobilenumber(sc.next());
		System.out.println("enter user type:");
		cobj.setUsertype(sc.next());
		customerdao.customerRegistration(cobj);
		
	}
}
