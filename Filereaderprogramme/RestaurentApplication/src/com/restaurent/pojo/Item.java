package com.restaurent.pojo;

import javax.persistence.*;

@Entity
@Table(name="itemdetails")
//@Inheritance(strategy=InheritanceType.JOINED)
public class Item {
	@Id
	private int itemid;
	@Column
	private String itemname;
	@Column
	private double price;
	@Column
	private String catagory;
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
}
