package com.usc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.usc.beans.Product;
import com.usc.dao.ProductDao;
import com.usc.http.Response;


@Service
@Transactional
public class ProductService {
	@Autowired
	ProductDao productdao;

	public Response addProduct(Product product) {
		product.setTitle(product.getTitle());
		product.setImg(product.getImg());
		product.setPrice(product.getPrice());
		productdao.save(product);
		return new Response(true);
	}


	public Response changeProduct(Product product) {
			Product p = productdao.findById(product.getId());
			p.setImg(product.getImg());
			p.setTitle(product.getTitle());
			p.setPrice(product.getPrice());
			productdao.save(p);
		    return new Response(true);

	}


	public Response deleteProduct(int id) {
		if (productdao.findById(id) != null) {
			productdao.deleteById(id);
			return new Response(true);

		} else {
			return new Response(false, "Product is not found!");
		}
	}
}