package com.resilience.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resilience.model.Order;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findByCategory(String category);


}
