package com.restaurent.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.restaurent.DAO.ItemDAO;
import com.restaurent.pojo.Item;
public class ItemService {
	private Scanner sc;
	private ItemDAO itemdao;
	private List<Item> ilist;
	public ItemService() {
		sc=new Scanner(System.in);
		itemdao=new ItemDAO();
		ilist=new ArrayList();
		
	}
	public void insertItem() {
		System.out.println("how many items do you want to insert:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			Item item=new Item();
			System.out.println("enter Item id:");
			item.setItemid(sc.nextInt());
			System.out.println("enter Item name:");
			item.setItemname(sc.next());
			System.out.println("Enter item Catagory:");
			item.setCatagory(sc.next());
			System.out.println("Enter Item Price:");
			item.setPrice(sc.nextDouble());
			ilist.add(item);
		}
		itemdao.addItem(ilist);
	}
	public void viewItemList() {
		
		itemdao.displayItemList();
	}
	public void searchItemsByCatagory() {
		System.out.println("Enter Catagory name:");
		String catagory=sc.next();
		System.out.println("***************************************************************");
		System.out.println("                         ********MENU************                                        ");
		System.out.println("****************************************************************");
		itemdao.searchByCatagory(catagory);
	}
	public void buyItem(String customername,int customerid) {
		viewItemList();
		itemdao.BuyItemsInMenu(customername,customerid);
	}
	public void viewOrderHistory(String customername,int customerid) {
		System.out.println("******************ORDER HISTORY*********************");
		System.out.println("****************"+customername+"************************");
		itemdao.seeOrderHistory(customerid);
	}
}
