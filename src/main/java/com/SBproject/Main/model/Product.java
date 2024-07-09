package com.SBproject.Main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long product_id;
	@Column(name = "title")
	private String title;
	@Column(name = "price")
	private Long price;
	@Column(name = "stock")
	private String stock;

	@OneToOne(mappedBy = "product")
	private Item item;

	public Product(String title, Long price, String stock, Item item) {
		super();
		this.title = title;
		this.price = price;
		this.stock = stock;
		this.item = item;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getId() {
		return product_id;
	}

	public void setId(Long id) {
		this.product_id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Product(String title, Long price, String stock) {
		super();
		this.title = title;
		this.price = price;
		this.stock = stock;
	}

	public Product() {
		super();
	}

}
