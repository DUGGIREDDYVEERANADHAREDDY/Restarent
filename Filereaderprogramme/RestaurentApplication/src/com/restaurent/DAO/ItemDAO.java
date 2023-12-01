package com.restaurent.DAO;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;
import com.restaurent.pojo.*;

import java.time.LocalDate;
import java.util.*;
import org.hibernate.*;
public class ItemDAO {
	private String categoryName;
	private Scanner sc;
	private SessionFactory sesfact;
	private Session session;
	private Transaction tran;
	private List<Order> buylist;
	private Query query;
	
	public ItemDAO() {
		
		sc=new Scanner(System.in);
		sesfact=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Order.class).addAnnotatedClass(Item.class).buildSessionFactory();
	}
	public void addItem(List<Item> ilist) {
		session=sesfact.openSession();
		tran=session.beginTransaction();
		for(Item item:ilist) {
			session.save(item);
			
		}
		tran.commit();
	}
	public void displayItemList() {
		session=sesfact.openSession();
		tran=session.beginTransaction();
		categoryName = "southindian";

	    List<Item> ilist = session.createQuery("SELECT i FROM Item i WHERE i.catagory=:categoryParam", Item.class)
	            .setParameter("categoryParam", categoryName)
	            .getResultList();
	    categoryName = "northindian";

	    List<Item> list = session.createQuery("SELECT i FROM Item i WHERE i.catagory=:categoryParam", Item.class)
	            .setParameter("categoryParam", categoryName)
	            .getResultList();
	    categoryName = "chainese";

	    List<Item> list1 = session.createQuery("SELECT i FROM Item i WHERE i.catagory=:categoryParam", Item.class)
	            .setParameter("categoryParam", categoryName)
	            .getResultList();
	   
		System.out.println("                         ********MENU************                                        ");
		
				for(Item i:ilist) {
			System.out.println(""+i.getItemname()+"               "+i.getPrice());
			
		}
		System.out.println("***************** INDIAN***************************");
		for(Item i:list) {
			System.out.println(i.getItemname()+"               "+i.getPrice());
			
		}
		System.out.println("********************CHAINESE**********************************");
		for(Item i:list1) {
			System.out.println(""+i.getItemname()+"               "+i.getPrice());
		}
	}
	public void searchByCatagory(String catagorys) {
		session=sesfact.openSession();
		tran=session.beginTransaction();
		System.out.println("***************catagory******************************");
		query = session.createQuery("select i from Item i where i.catagory=:catagorys");
		query.setParameter("catagorys", catagorys);
		List <Item> ilist = query.list();
		for(Item i:ilist) {
			System.out.println("Item Name "+i.getItemname()+"               "+i.getPrice());
			
		}
		
	}
	public void BuyItemsInMenu(String customername,int customerid) {
		session=sesfact.openSession();
		tran=session.beginTransaction();
		String ch="y";
		buylist=new ArrayList();
		Customer customer = session.find(Customer.class,customerid);
		while(ch.equalsIgnoreCase("y")) {
			System.out.println("Enter Item Name:");
			String i_name=sc.next();
			System.out.println("how many plates do you want to buy:");
			int no_plate=sc.nextInt();
			query=session.createQuery("select i from Item i where i.itemname=:i_name");
			query.setParameter("i_name", i_name);
			List <Item>ilist = query.list();
			Order order=new Order();
			for(Item i:ilist) {
				order.setTotalbill(no_plate*i.getPrice());
			}
			order.setItemname(i_name);
			order.setUsername(customername);
			order.setNoofplates(no_plate);
			LocalDate date = LocalDate.now();
			order.setOrdredate(date);
			order.setCobj(customer);
			buylist.add(order);
		    customer.setOrderlist(buylist);
			session.save(order);
			session.save(customer);
			System.out.println("do you want to order item again(Y/N):");
			ch=sc.next();
		}
		tran.commit();
		billgenerator(customername,buylist);
	}
	public void billgenerator(String customername, List<Order> buylist2) {
		double total_bill=0;
		System.out.println("**************************************************************************");
		System.out.println("***********************BILL***********************************************");
		System.out.println("_____-------____________"+customername+"_________-----------______________");
		System.out.println("ITEMNAME                      |        NOOFPLATS                   |         PRICE        ");
		for(Order order:buylist) {
			System.out.println(order.getItemname()+"                      |                      "+order.getNoofplates()+"                   |         "+order.getTotalbill());
			total_bill+=order.getTotalbill();
		}
		System.out.println("*****************************************************************************");
		System.out.println("FINAL BILL IS:"+total_bill);
		
	}
	public void seeOrderHistory(int cust_id) {
		session=sesfact.openSession();
		 query = session.createQuery("select o from Order o join o.cobj c on c.customerid=:cust_id");
		 query.setParameter("cust_id",cust_id);
		 List <Order>olist = query.list();
		 for(Order order:olist) {
			 System.out.println("Item name is:"+order.getItemname());
			 System.out.println("Item price:"+order.getTotalbill());
			 System.out.println("Item order date is"+order.getOrdredate());
			 
		 }
		
	}
	
}
