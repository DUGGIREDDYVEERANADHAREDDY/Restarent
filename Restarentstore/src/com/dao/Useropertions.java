package com.dao;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;

import com.pojo.Item;
//import com.pojo.Items;
import com.pojo.OrderedItem;
//import com.pojo.Product;
//import com.pojo.Product;
import com.pojo.User;

import java.util.*;

public class Useropertions {
	public SessionFactory sat;
	public Session ses;
	public Transaction tax;
	Scanner sc;
	List<OrderedItem> order;
	List<Item> itemlst;
	List<User> ulist;
	public Useropertions()
	{
		sat = new Configuration().configure("restarent.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Item.class)
				.addAnnotatedClass(OrderedItem.class).buildSessionFactory();
		sc= new Scanner(System.in);
		order = new ArrayList<>();
		itemlst=new ArrayList<>();
		ulist=new ArrayList<>();
	}	
	
	public void RegisterByNewUser()
	{
		ses=sat.openSession();
		tax=ses.beginTransaction();
		User us =new User();
		System.out.println("enter user name");
		String name=sc.next();
		System.out.println("enter password");
		String pass=sc.next();
		us.setUsername(name);
		us.setPassword(pass);
		ses.save(us);
		tax.commit();
		System.out.println("data inserted");
		
	}
	public void existiguser()
	{
		ses=sat.openSession();
		tax=ses.beginTransaction();
		System.out.println("enter user name");
		String name= sc.next();
		System.out.println("enter password");
		String pass=sc.next();
		Query q =  ses.createQuery("from User where usernme=:eid and password=:id");
		q.setParameter("eid",name);
		q.setParameter("id", pass);
		//User user=(User) q.uniqueResult();
		List <User> ulist = q.list();
		for(User u:ulist) {
			RetriveData();
			
		}
		
//		if(user!=null)
//		{
//			System.out.println("login as exiting user");
//		}
//		else
//		{
//			System.out.println("sorry your details in not in my database you can register");
//			
//		}

	}
	public void insertItems()
	{
		ses=sat.openSession();
		tax=ses.beginTransaction();
		System.out.println("how many items you want to insert");
		int noof= sc.nextInt();
		for(int i=0;i<noof;i++)
		{
			Item it = new Item();
			System.out.println("enter item code");
			it.setItemcode(sc.nextInt());
			System.out.println("enter item name");
			it.setItemname(sc.next());
			System.out.println("enter price of items");
			it.setPrice(sc.nextDouble());
			ses.save(it);
//			tax.commit();
//			System.out.println("data insreted");
//	
		}
		tax.commit();
		System.out.println("data insreted");

//		tax.commit();
	}
	public void RetriveData()
	{
		ses=sat.openSession();
		tax=ses.beginTransaction();
		Query q=ses.createQuery("from Item");
		List<Item> item=q.list();
		for(Item it:item)
		{
			System.out.println("item code is-------"+it.getItemcode());
			System.out.println("item name is ------"+it.getItemname());
			System.out.println("item price is-------"+it.getPrice());
			
			
			
			
			System.out.println();
		}
	}
	public void Orderitems()
	{
		ses=sat.openSession();
		tax=ses.beginTransaction();
		Query  q = ses.createQuery("from Item");
		List<Item> item=q.list();
		//List<OrderedItem> order = new ArrayList<>();
		for(Item it:item)
		{
			System.out.println("item code is-------"+it.getItemcode());
			System.out.println("item name is ------"+it.getItemname());
			System.out.println("item price is-------"+it.getPrice());
			
			
			
			
			
			System.out.println("");
		}
		
		System.out.println("please select the order using code");
		int selectedCode=sc.nextInt();
		 Item selectedItem = null;
		 for(Item it:item) {
		        if (it.getItemcode() == selectedCode) {
		            selectedItem = it;
		            break;
		        }
		    }
		 if(selectedItem !=null)
		 {
			 OrderedItem orderitem = new OrderedItem();
			 orderitem.setOrderid(selectedItem.getItemcode());
			 LocalDate date=LocalDate.now();
			orderitem.setDate(date);
			 orderitem.setOrderid(selectedItem.getItemcode());
			 orderitem.setTotalprice(selectedItem.getPrice());
			// Object userid = null;
			//orderitem.setOrderid(userid);
			 //orderitem.setUserobj(selectedItem.getItemcode());
			 //orderitem.getUboj(ulist);
			 order.add(orderitem);
			 //orderitem.setUserobj(null);
			 ses.save(orderitem);
			 /*// Assuming you have a User object associated with the order
// Replace "userId" with the actual user ID
orderitem.setUserId(userId);

// Saving the ordered item
ses.save(orderitem);
*/
			 System.out.println("dear mam/sir you order placed succsfully");
		 String choice="y";
		 String ch;
		 if(choice.equalsIgnoreCase("y"))
		 {
			 
			 System.out.println("you want to oder again?(y/n)");
			 ch=sc.next();
			 System.out.println("enter how many plate you want to order");
			 int num=sc.nextInt();
			 for (OrderedItem or : order) {
				 or.setNoofplates(num);
			 }

		 } 
		 ses.save(selectedItem);
		 tax.commit();
		 
		 double cost =0;
		 for (OrderedItem or : order) {
		     cost = or.getNoofplates() * or.getTotalprice();
		     System.out.println("your order data is"+or.getDate());
		 }
		 System.out.println("The cost is " + cost);
		 System.out.println("Thankyou! visiting again");
		}
	}
//	public void history()
//	{
//		for(Item r:itemlst)
//		{
//			System.out.println("item name is"+r.getItemcode());
//			System.out.println("data  of  order:-"+r);
//			System.out.println("item price"+r.getTotalprice());
//			
//			//System.out.println("you order number of plates"+or.getNoofplates());
//		}
//	 }
	public void cart() {
	        ses = sat.openSession();
	        tax = ses.beginTransaction();

	        Query q = ses.createQuery("from Item");
	        List<Item> items = q.list();
	        for (Item item : items) {
	            System.out.println("Item name:-----------" + item.getItemname());
	            System.out.println("Item price:------------" + item.getPrice());
	            System.out.println("item code is----------"+item.getItemcode());
	            
	            
	            
	            
	            System.out.println("");
	            
	        }
	        

	        System.out.println("Enter the item you want to add to the cart:");
	        int selectedCode = sc.nextInt();
	           Query q1 = ses.createQuery("from Item where itemcode=:eid");
	      
	        q1.setParameter("eid", selectedCode);
	        List<Item> selectedItems = q1.list();

	        if (selectedItems.isEmpty()) {
	            System.out.println("No item found with the entered code/name.");
	        } else {

	            boolean found = false;

	            for (Item it : selectedItems) {
	                if (it.getItemcode() == selectedCode) {
	                    found = true;
	                    System.out.println("Your item was added to the cart successfully! You can view the cart.");
	                    //order.addAll(it); 
	                    break; // Exit loop once the item is found
	                }
	            }

	            if (!found) {
	                System.out.println("You have entered an invalid item code.");
	            }
	        }
	        // The rest of your code...


	        }
}
	
	
	
	
	
		

	
	
	

	
	

