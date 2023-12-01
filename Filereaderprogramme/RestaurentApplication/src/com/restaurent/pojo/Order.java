package com.restaurent.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="orderdetails")
//@PrimaryKeyJoinColumn(name="itemid")
public class Order  {
	@Id
	 @GeneratedValue
	private int orderid;
	@Column
	private String itemname;
	@Column
	private String username;
	@Column
	private int noofplates;
	@Column
	private double totalbill;
	@Column
	private LocalDate ordredate;
	@ManyToOne
	@JoinColumn(name="Customerid")
	private Customer cobj;
	
	public Customer getCobj() {
		return cobj;
	}
	public void setCobj(Customer cobj) {
		this.cobj = cobj;
	}
	
	public LocalDate getOrdredate() {
		return ordredate;
	}
	public void setOrdredate(LocalDate date) {
		this.ordredate = date;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNoofplates() {
		return noofplates;
	}
	public void setNoofplates(int noofplates) {
		this.noofplates = noofplates;
	}
	public double getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(double totalbill) {
		this.totalbill = totalbill;
	}
	
}
