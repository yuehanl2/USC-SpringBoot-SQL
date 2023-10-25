package com.usc.beans;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity // jpa or mapping
@Table(name = "usc.product")

public class Product  {
	
	private static final long serialVersionUID = 1L;
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "USC_USER_SEQ")
	private int id;
	
	@Column(name = "title", nullable = false)
	private String title;

	
	@Column(name = "price", nullable = false)
	private float price;
	
	
	@Column(name = "img", nullable = false)
	private String img;
	

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", img=" + img + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product(int id, String title, float price, String img) {
		super();
		this.id=id;
		this.title=title;
		this.img=img;
		this.price=price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
}
