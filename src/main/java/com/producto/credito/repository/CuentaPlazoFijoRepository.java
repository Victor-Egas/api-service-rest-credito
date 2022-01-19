package com.producto.credito.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.producto.credito.model.Credito;

public interface CuentaPlazoFijoRepository extends ReactiveMongoRepository<Credito, String> {

}
