package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.PhonePay;
@Repository
public interface PhonePayRepo extends JpaRepository<PhonePay, Integer> {

}
