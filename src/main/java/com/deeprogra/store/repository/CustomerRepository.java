package com.deeprogra.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deeprogra.store.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}