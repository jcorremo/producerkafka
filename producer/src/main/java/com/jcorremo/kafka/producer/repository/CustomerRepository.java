package com.jcorremo.kafka.producer.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.jcorremo.kafka.producer.model.Customer;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, String>{
	
}
