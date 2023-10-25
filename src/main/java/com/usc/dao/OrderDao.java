package com.usc.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usc.beans.Order;

import antlr.collections.List;


@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {

	Order findById(int id);
	
	java.util.List<Order> findByUser_Id(int userId);

}

