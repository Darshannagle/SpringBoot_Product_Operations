package com.SBproject.Main.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBproject.Main.model.Item;
import com.SBproject.Main.model.Product;
import com.SBproject.Main.model.User;
import com.SBproject.Main.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private UserService userService;

	@Autowired
	private ItemRepository repository;

	public ItemService(ItemRepository repository) {
		this.repository = repository;
	}

	public List<Item> getItems() {
		List<Item> items = repository.findAll();
		return items;
	}

	public Set<Item> addItems(User user, Product product,int quantity) {
		Set<Item> items = user.getItems();
		Item item = new Item(product, user, quantity);
		items.add(item);
		userService.updateUser(user);
		return items;
	}
	
}
