package com.SBproject.Main.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SBproject.Main.model.Item;
import com.SBproject.Main.model.Product;
import com.SBproject.Main.model.ProductDTO;
import com.SBproject.Main.model.User;
import com.SBproject.Main.service.ItemService;
import com.SBproject.Main.service.ProductService;
import com.SBproject.Main.service.UserService;







@Controller
@RequestMapping("/api")
public class MainController {

	@Autowired
	private ProductService service;
	@Autowired
	private UserService userService;
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUSers() {
		List<User> users = userService.getUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK) ;
	}
	
	@CrossOrigin
	@GetMapping("/all")
	public String getAll(Model model) {
		List<Product> products = service.getAll();
		model.addAttribute("products", products);
		
return "Index";
	}

//	@GetMapping("/all")
//	public ResponseEntity<List<Product>> getAll() {
//		List<Product> products = service.getAll();
//return new ResponseEntity<List<Product>>(products,HttpStatus.OK) ;
//	}
//	@PostMapping("/add")
//	public String addProduct(@RequestBody Product product) {
//		String ans = service.addProduct(product);
//		return "index";
//	}
	@PostMapping("/add")
	public String addProduct(@ModelAttribute("product")  Product product) {
		String ans = service.addProduct(product);
System.out.println(ans);
		return "redirect:/api/all";
	}
	
	@GetMapping("/addForm")
	public String showForm(Model model) {
		Product product= new Product();
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	@GetMapping("/updateForm/{id}")
	public String getUpdateFrom(Model model,@PathVariable("id") Long id) throws Exception {
		Product product = service.getProduct(id);
		model.addAttribute("product", product);
		return "updateProduct";
	}
	
	@PutMapping("path/{id}")
	public String updateProduct(@PathVariable String id, @RequestBody Product product) {
	service.addProduct(product);
		
		return "redirect:/api/all";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id")Long id,Model model) {
		
		String ans= service.deleteProduct(id) ;
		List<Product> products = service.getAll();
		model.addAttribute("products", products);
		return "index";
	}
	@GetMapping("/")
	public String getMehodName() {
		return "addProduct";
	}
	
	
//	
//	@GetMapping("/userCart/{id}")
//	public ResponseEntity<List<Item>> getUserItems(@PathVariable("id") Long id) {
//List<Item> items = itemService.getByUser(id);
//		return new ResponseEntity<List<Item>>(items,HttpStatus.OK);
//	}
//	
	
	@GetMapping("/getItems")
	public ResponseEntity<List<Item>> getMethodName() {
		List<Item> items = itemService.getItems();
		
		return new ResponseEntity<List<Item>>(items,HttpStatus.OK);
	}
	
	
	@GetMapping("/userItems/{id}")
	public ResponseEntity<Set<Item>>  getUserItems(@PathVariable("id") Long  id) {
		Set<Item> items = userService.getUser(id).getItems();
		
		return new ResponseEntity<Set<Item>>(items,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/add-to-cart/{id}")
	public ResponseEntity<User> addToCart(@RequestBody ProductDTO productDTO ,@PathVariable(name = "id")Long uid) throws Exception {
		User user = userService.getUser(uid);
		

Product product = service.getProduct(productDTO.getProduct_id());	
Set<Item> items = itemService.addItems(user, product,productDTO.getQuantity());	
user.setItems(items);
		user = userService.updateUser(user);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	

	
	
	
	
	
}
