package com.producto.credito.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.producto.credito.model.Credito;
import com.producto.credito.repository.CuentaPlazoFijoRepository;
import com.producto.credito.service.ICuentaPlazoFijoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CuentaPlazoFijoService implements ICuentaPlazoFijoService {

	@Autowired
	private CuentaPlazoFijoRepository repo;
	
	@Override
	public Flux<Credito> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<Credito> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<Credito> save(Credito CuentaPlazoFijo) {
		return repo.save(CuentaPlazoFijo);
	}

	@Override
	public Mono<Void> delete(Credito CuentaPlazoFijo) {
		return repo.delete(CuentaPlazoFijo);
	}

	@Override
	public Mono<Credito> update(Credito CuentaPlazoFijo) {
		return repo.save(CuentaPlazoFijo);
	}

}