package com.example.reactiveservice;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import reactor.core.publisher.Flux;

public interface ProductRepository extends R2dbcRepository<Product, Long> {

    @Query(value = "SELECT tb_product_id, code, name FROM tb_product ORDER BY RANDOM() LIMIT :limit ")
    Flux<Product> findProducts(int limit);

}
