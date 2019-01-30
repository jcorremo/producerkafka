package com.jcorremo.kafka.producer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.jcorremo.kafka.producer.model.Customer;
 
 
@Service
public class KafkaProducer {
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	@Value("${cloudkarafka.topic}")
	String kafkaTopic;
	
	public void send(Customer customer) {
	    kafkaTemplate.send(kafkaTopic, customer);
	}
}