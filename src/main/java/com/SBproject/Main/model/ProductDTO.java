package com.SBproject.Main.model;

import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductDTO {

	private Long product_id;
	
	public ProductDTO(Long product_id, int quantity) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
	}

	

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private int quantity;
}
