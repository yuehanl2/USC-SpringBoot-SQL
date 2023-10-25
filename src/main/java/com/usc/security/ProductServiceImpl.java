//package com.usc.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.usc.beans.User;
//import com.usc.dao.ProductDao;
//
//@Service
//public class ProductServiceImpl implements UserDetailsService {
//	@Autowired
//	ProductDao productDao;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = productDao.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User " + username + " was not found in the database");
//		}
//		return user;
//	}
//}
