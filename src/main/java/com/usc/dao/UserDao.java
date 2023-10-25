package com.usc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usc.beans.Product;
import com.usc.beans.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
	User findByUsername(String username);
	User findById(int id);
}
