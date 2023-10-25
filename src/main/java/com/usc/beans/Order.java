package com.usc.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity // jpa or mapping
@Table(name = "usc.order")
public class Order {
	

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "USC_USER_SEQ")
	private int id;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderProduct> purchases;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	public Order() {
		super();
	}
	
	public Order(List<OrderProduct> purchases) {
		super();
		this.purchases=purchases;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderProduct> getPurchases() {
		return purchases;
	}

	public void setPurchase(List<OrderProduct> purchases) {
		this.purchases = purchases;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}

//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//
//@Entity // jpa or mapping
//@Table(name = "usc.order")
//public class Order {
//	
//
//	@Id // primary key
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
//	@SequenceGenerator(name = "SEQ", sequenceName = "USC_USER_SEQ")
//	private int id;
//	
//
//	@ManyToOne
//	@JoinColumn(name = "user_id",referencedColumnName = "id" )
//	private User user;
//	
//	@ManyToMany
//	@JoinTable(name = "c_order_product", joinColumns = {
//			@JoinColumn(name = "order_id", referencedColumnName = "id") }, inverseJoinColumns = {
//					@JoinColumn(name = "product_id", referencedColumnName = "id") })
//	private List<Product> product = new ArrayList<Product>();
//	
//	public Order() {
//		super();
//	}
//	
//	public Order(User user, List<Product> product) {
//		super();
//		this.user = user;
//		this.product=product;
//		
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public List<Product> getProducts() {
//		return product;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.product = products;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
//}

