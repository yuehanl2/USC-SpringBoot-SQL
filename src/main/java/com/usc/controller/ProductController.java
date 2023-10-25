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

import com.usc.beans.Product;
import com.usc.dao.ProductDao;
import com.usc.http.Response;
import com.usc.service.ProductService;


@RestController() // recept API request
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductDao productdao;

	@Autowired
	ProductService productserver;


	@GetMapping
	//get all product
	public List<Product> getproduct() {
		return productdao.findAll();
	}

	@PostMapping
	//add product
	public Response addProduct(@RequestBody Product product) { // json
		return productserver.addProduct(product);
	}
	
	@PutMapping
	public Response changeProduct(@RequestBody Product product) {
		return productserver.changeProduct(product);
	}

	@DeleteMapping("/{id}")
	public Response deleteProduct(@PathVariable int id) {
		return productserver.deleteProduct(id);
	}
}