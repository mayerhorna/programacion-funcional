package com.example.imperativeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT tb_product_id, code, name FROM tb_product ORDER BY RANDOM() LIMIT :limit "
    		,  nativeQuery = true)
    List<Product> findProducts(int limit);

}
