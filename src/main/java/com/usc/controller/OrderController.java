package com.usc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usc.beans.Order;
import com.usc.beans.OrderRequest;
import com.usc.beans.Product;
import com.usc.beans.User;
import com.usc.dao.OrderDao;
import com.usc.dao.ProductDao;
import com.usc.dao.UserDao;
import com.usc.http.Response;
import com.usc.service.OrderService;
import com.usc.service.ProductService;


@RestController() // recept API request
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderDao orderdao;

	@Autowired
	OrderService orderservice;
	
	@Autowired
	UserDao userdao;



//	@GetMapping("/order/{id}")
//	//get all product
//	public User getUserOrder(@PathVariable int id) {
//		Order order= orderdao.findById(id);
//		User user = order.getUser();
//		return user;
//	}
	
//	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")	
	@GetMapping
	//get all order
	public List<Order> getorder() {
		return orderdao.findAll();
	}
	
	@GetMapping("/user/{id}")
	//get all order
	public List<Order> getUserorder(@PathVariable int id) {
		return orderdao.findByUser_Id(id);	
		}
	
	
	@PostMapping
	//add order
	public Response addOrder(@RequestBody OrderRequest request) { // json

		return orderservice.addOrder(request);
	}
	
	@PutMapping
	public Response editOrder(@RequestBody OrderRequest request) {
		return orderservice.editOrder(request);
	}
	
	@PutMapping("/editqty")
	public Response editQTY(@RequestBody OrderRequest request) {
		return orderservice.editQTY(request);
	}

	
	@DeleteMapping("/{id}")
	public Response deleteOrder(@PathVariable int id) {
		return orderservice.deleteOrder(id);
	}
}