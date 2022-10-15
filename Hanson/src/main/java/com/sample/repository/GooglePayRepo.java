package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.GooglePay;

@Repository
public interface GooglePayRepo extends JpaRepository<GooglePay, Integer> {

}
