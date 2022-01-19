package com.producto.credito.service;

import com.producto.credito.model.Credito;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICuentaPlazoFijoService {
	
	public Flux<Credito> findAll();

	public Mono<Credito> findById(String id);
	
	public Mono<Credito> save(Credito cuentaPlazoFijo);
	
	public Mono<Void> delete(Credito cuentaPlazoFijo);
	
	public Mono<Credito> update(Credito cuentaPlazoFijo);
}
