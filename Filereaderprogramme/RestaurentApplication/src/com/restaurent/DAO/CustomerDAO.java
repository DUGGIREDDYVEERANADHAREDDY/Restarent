package com.restaurent.DAO;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;
import com.restaurent.pojo.*;
import com.restaurent.service.*;

public class CustomerDAO {
	private ItemService itemservice;
	private SessionFactory sesfactory;
	private Session session;
	private Transaction transaction;
	private Scanner sc;
	public CustomerDAO() {
		itemservice=new ItemService();
		sc=new Scanner(System.in);
		sesfactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class).addAnnotatedClass(Order.class).buildSessionFactory();
	}
	public void validateCustomer(String cust_name, String pass) {
		session=sesfactory.openSession();
		transaction=session.beginTransaction();
		boolean flag=false;
		Query query = session.createQuery("select c from Customer c where c.customername=:cust_name and c.password=:pass");
		query.setParameter("cust_name",cust_name);
		query.setParameter("pass",pass);
		List <Customer> customerlist = query.list();
		for(Customer cobj:customerlist) {
			if(cobj.getUsertype().equalsIgnoreCase("customer")) {
				String ch="y";
				int choice=0;
				 flag=true;
				while(ch.equalsIgnoreCase("y")) {
					System.out.println("6.add item");
					System.out.println("1.List of items in restaurent");
					System.out.println("2.Buy an item");
					System.out.println("3.View the items based on catagory");
					System.out.println("4..View the orderhistory");
					System.out.println("5.Exit");
					System.out.println("Enter your choice:");
					choice=sc.nextInt();
					switch(choice) {
					case 1:itemservice.viewItemList();
						break;
					case 2:itemservice.buyItem(cobj.getCustomername(),cobj.getCustomerid());
						break;
					case 3:itemservice.searchItemsByCatagory();
						break;
					case 4:itemservice.viewOrderHistory(cobj.getCustomername(),cobj.getCustomerid());
						break;
					case 5:
						System.exit(0);
						break;
					case 6:
						itemservice.insertItem();
						break;
					}
					System.out.println("do you want to continue(Y/N):");
					ch=sc.next();
				}
			}
		}
		if(flag==false) {
			System.out.println("entered invalid user details");
		}
		
	}
	public void customerRegistration(Customer cobj) {
		session=sesfactory.openSession();
		transaction=session.beginTransaction();
		session.save(cobj);
		transaction.commit();
	}

}
