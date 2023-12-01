package com.service;

import com.dao.Useropertions;

public class Service {
	Useropertions us;
	
	
public Service()
{
	us = new Useropertions();
}
public void  newuser()
{
	us.RegisterByNewUser();
}
public void existinguser()
{
	us.existiguser();
}
public void insertitems()
{
	us.insertItems();
}
public void retrivedata()
{
	us.RetriveData();
}
public void orderitems()
{
	us.Orderitems();
}
public void historyof()
{
	//us.history();
}
public  void cart()
{
	us.cart();
}

}
