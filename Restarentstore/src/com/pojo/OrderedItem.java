package com.pojo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="OrderedItems")
@PrimaryKeyJoinColumn(name="itemcode")
public class OrderedItem{
    @Id
    @Column(name="OrderId")
    private int orderid;
    @Column(name="NoOfPlates")
    private int noofplates;
    @Column(name="DateOfOrder")
    private LocalDate date;
    @Column(name="TotalSpend")
    private double totalprice;

    @ManyToOne
    @JoinColumn(name="UserIdFk")
    private User userobj;
    public int getOrderid() {
        return orderid;
    }
    public void setOrderid(Object userid) {
        this.orderid = (int) userid;
    }
    public int getNoofplates() {
        return noofplates;
    }
    public void setNoofplates(int noofplates) {
        this.noofplates = noofplates;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public double getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
//    public List<User> ulist;
//	public List<User> getUlist() {
//		return ulist;
//	}
//	public void setUlist(List<User> ulist) {
//		this.ulist = ulist;
//	}
	
	
    
 
    

}

