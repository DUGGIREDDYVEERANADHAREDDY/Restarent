package com.pojo;
import javax.persistence.*;
import java.util.*;
import java.util.List;
@Entity
@Table(name="userdeatils")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="userid")
	public int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Column(name="usernme")
	public String username;
	@Column(name="password")
	public String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(cascade=CascadeType.ALL)
//    private List<Item> itemlst;
//	public List<Item> getItemlst() {
//		return itemlst;
//	}
//	public void setItemlst(List<Item> itemlst) {
//		this.itemlst = itemlst;
//	}
	public List<OrderedItem> bylist;
	public List<OrderedItem> getBylist() {
		return bylist;
	}
	public void setBylist(List<OrderedItem> bylist) {
		this.bylist = bylist;
	}
	
	
	
	

	
	
	
	
    
	

}
