package com.usc.beans;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderRequest {
	
	private int id;
	private int orderID;
	private int qty;
	private int orderPID;
	
	public int getOrderPID() {
		return orderPID;
	}

	public void setOrderPID(int orderPID) {
		this.orderPID = orderPID;
	}

	private List<InputProduct> product;
	
	public List<InputProduct> getProduct() {
		return product;
	}

	public void setProduct(List<InputProduct> product) {
		this.product = product;
	}




	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderRequest() {
		super();
	}

}
