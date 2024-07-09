package com.SBproject.Main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBproject.Main.model.Product;
import com.SBproject.Main.repository.ProductRespository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRespository respository;
		public List<Product> getAll() {
			List<Product> products = respository.findAll();
			return products;
		}
		public Product getProduct(Long id) throws Exception {
			Product product = respository.findById(id).orElseThrow(() -> new Exception("Product Not Found")) ;
				return product ;
		}
		public String  addProduct(Product p) {
			 respository.save(p);
			return "product Added";
		}
		public String  deleteProduct(Long id) {
		Product product = respository.findById(id).orElse(null);
		if (product!=null) {
			respository.deleteById(id);
		return "Product Deleted";	
		}
		else {
			return "Product Not Fount";
			
		}
			
		}
}
