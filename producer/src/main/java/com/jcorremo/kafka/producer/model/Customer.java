package com.jcorremo.kafka.producer.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {
	@Id
	private ObjectId _id;

	private String nombre;
	private String edad;

	public Customer() {

	}

	public Customer(String nombre, String edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Customer [nombre=" + nombre + ", edad=" + edad + "]";
	}

}
