package com.restaurent.pojo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="customerdetails")
public class Customer {
	@Id
	 @GeneratedValue
	private int customerid;
	@Column
	private String customername;
	@Column
	private String emailid;
	@Column
	private String password;
	@Column
	private String address;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Order> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<Order> orderlist) {
		this.orderlist = orderlist;
	}
	@Column
	private String mobilenumber;
	@Column
	private String usertype;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	@OneToMany(mappedBy="cobj", cascade=CascadeType.ALL)
	private List<Order> orderlist;
}
