package com.jcorremo.kafka.producer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcorremo.kafka.producer.config.KafkaProducer;
import com.jcorremo.kafka.producer.model.Customer;
import com.jcorremo.kafka.producer.repository.CustomerRepository;

import reactor.core.publisher.Mono;

@RestController
public class ProducerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@PostMapping
	public Mono<@Valid Customer> createCustomer(@Valid @RequestBody Customer customer){
		return customerRepository.save(customer).doOnNext(x -> kafkaProducer.send(x));
	}
	
}
