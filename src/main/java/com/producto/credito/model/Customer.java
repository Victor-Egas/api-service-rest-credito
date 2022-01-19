package com.producto.credito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Customer {
		
		private String id;
		
		private String firstName;
		
		private String lastName;
		
		private String document;
		
		private String type;
}
