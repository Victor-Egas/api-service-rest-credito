package com.producto.credito.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Document(collection="credito")
public class Credito {

		@Id
		private String id;
		
		@Field(name="status")
		private String status;
		
		@Field(name="type")
		private String type;
		
		@Field(name="total")
		private double total;
		
		@Field(name="cuotas")
		private  int cuotas;
		
		private Customer customer;

		public String getId() {
			return id;
		}
		
		

		 
}
