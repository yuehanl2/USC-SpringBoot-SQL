//package Temp;
//
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
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
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//
//@Entity // jpa or mapping
//@Table(name = "usc.order_product")
//
//public class OrderProduct {
//	
//
//	@Id // primary key
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
//	@SequenceGenerator(name = "SEQ", sequenceName = "USC_USER_SEQ")
//	private int id;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "order_id")
//	@JsonIgnoreProperties("purchases")
//	private Order order;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "product_id")
//	private Product product;
//	
//	public OrderProduct() {
//		super();
//	}
//	
//	public OrderProduct(Order order, Product product) {
//		super();
//		this.order=order;
//		this.product=product;
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
//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	@Override
//	public String toString() {
//		return "OrderProduct [id=" + id + ", order=" + order + ", product=" + product + "]";
//	}
//	
//	
//	
//	
//
//
//
//}
