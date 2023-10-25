package com.usc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.usc.beans.InputProduct;
import com.usc.beans.Order;
import com.usc.beans.OrderProduct;
import com.usc.beans.OrderRequest;
import com.usc.beans.Product;
import com.usc.beans.User;
import com.usc.beans.UserProfile;
import com.usc.dao.OrderDao;
import com.usc.dao.OrderProductDao;
import com.usc.dao.ProductDao;
import com.usc.dao.UserDao;
import com.usc.http.Response;


@Service
@Transactional
public class OrderService {
	@Autowired
	OrderDao orderdao;
	@Autowired	
	UserDao userdao;
	@Autowired
	UserService userservice;
	
	@Autowired
	OrderProductDao opDao;

	@Autowired
	ProductDao productdao;

	
	
	public Response addOrder(@RequestBody OrderRequest request) {
		try {
			Order newOrder = new Order();
			User user = userdao.findById(request.getId());
			newOrder.setUser(user);
			List<InputProduct> getP = request.getProduct();
			List<OrderProduct> orderP = new ArrayList<OrderProduct>();
			
			getP.forEach((p)->{
				OrderProduct orderProduct = new OrderProduct();
				orderProduct.setOrder(newOrder);
				Product product = productdao.findById(p.getId());
				orderProduct.setProduct(product);
				orderProduct.setQty(p.getQty());
				
				orderP.add(orderProduct);
				opDao.save(orderProduct);
			});
			newOrder.setPurchase(orderP);
			orderdao.save(newOrder);
			
			return new Response(true);
			
		} catch(Exception e) {
			return new Response(false);
			
		}
		

	}
	
	@SuppressWarnings("unused")
	public Response editOrder(@RequestBody OrderRequest request) {
		
		
		
		try {
			Order order = orderdao.findById(request.getOrderID());
			OrderProduct deleteOP = opDao.findById(request.getOrderPID());
			
		    
			if (deleteOP != null) {
				deleteOP.getOrder().getPurchases().remove(deleteOP);
				opDao.deleteById(request.getOrderPID());
				if (deleteOP==null && orderdao.findById(request.getOrderID()) != null) {
					orderdao.deleteById(request.getOrderID());


				} else {
					
				}
				
				
				return new Response(true);
				

			} else {
				
			}
		
			
			return new Response(false);
	}catch(Exception e) {
		return new Response(false);
		}
	}
	
	public Response editQTY(@RequestBody OrderRequest request) {
		OrderProduct editOP = opDao.findById(request.getOrderPID());
		if (editOP != null) {
			editOP.setQty(request.getQty());
			opDao.save(editOP);
			return new Response(true);

		} else {
			return new Response(false, "OrderProduct is not found!");
		}
		
	}
	
	
	
	
//
	public Response editQTYTest(@RequestBody OrderRequest request) {
		try {
			//这个OrderRequest的结构是：
//			{
//				  "orderID": 2505,
//				  "product": [
//				    {
//				      "id": 706,
//				      "qty":999
//				    },
//				    {
//				      "id": 708,
//				      "qty":999
//				    }
//				  ]
//				}
			
			 //根据传入的order ID找到要修改的order
			 Order newOrder = orderdao.findById(request.getOrderID());
			 //拿到更新后的product的list
			 List<InputProduct> getP = request.getProduct();
			 //新建一个OrderProduct的list
			 List<OrderProduct> orderP = new ArrayList<OrderProduct>();
			 
			 //清除旧product			 
			 newOrder.getPurchases().clear();

			 //遍历
			 getP.forEach((p)->{
				    //新建OrderProduct
					OrderProduct orderProduct = new OrderProduct();
					orderProduct.setOrder(newOrder);
					
					//根据ID拿到要修改的product
					Product product = productdao.findById(p.getId());
					orderProduct.setProduct(product);
					orderProduct.setQty(p.getQty());
					orderP.add(orderProduct);
					opDao.save(orderProduct);
				});
			 
			 //更新后存好
			newOrder.setPurchase(orderP);
			orderdao.save(newOrder);
			
			return new Response(true);
			
		}catch(Exception e) {
			return new Response(false);
			
		}
		   

	}
////	

	
//	public Order createOrder(OrderRequest request) {
//		System.out.print(request);
//		List<Product> products = request.getProduct();
//		User user = userdao.findById(request.getId());
//		Order order = new Order(user, products);
//		return orderdao.save(order);
//		}


	
	
	public Response deleteOrder(int id) {
		
		if (orderdao.findById(id) != null) {
			orderdao.deleteById(id);
			return new Response(true);

		} else {
			return new Response(false, "Order is not found!");
		}
	}
	


}


