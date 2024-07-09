package com.SBproject.Main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long item_id;

	@OneToOne(targetEntity = Product.class)
	private Product product;
	@ManyToOne
	private User user;

	public Item() {
		super();
	}

	public Item(Product product, User user, int quantity) {
		super();
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "quantity")
	private int quantity;

}
