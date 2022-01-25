package com.producto.credito.controller;

import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.producto.credito.model.Credito;
import com.producto.credito.service.ICreditoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CreditoController {

	@Autowired
	private ICreditoService service;
	
	@GetMapping("/findAll")
	public Mono<ResponseEntity<Flux<Credito>>> findAll(){
		Flux<Credito> fxCuentaPlazoFijo=service.findAll();
		return Mono.just(ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fxCuentaPlazoFijo)
				);
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Credito>> findById(@PathVariable String id){
		return  service.findById(id).map(c -> ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(c))
				.defaultIfEmpty(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public Mono<ResponseEntity<Credito>> insert(@RequestBody Credito cuentaPlazoFijo , final ServerHttpRequest req){
		return service.save(cuentaPlazoFijo)
				.map(c -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(c.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(c)
						);
	}
	
	@PutMapping
	public Mono<ResponseEntity<Credito>> update(@RequestBody Credito CuentaPlazoFijo ){
		return service.update(CuentaPlazoFijo)
				.map(c -> ResponseEntity
						.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(c)
						);
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
		return service.findById(id).flatMap(c ->{
			return service.delete(c).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
}
