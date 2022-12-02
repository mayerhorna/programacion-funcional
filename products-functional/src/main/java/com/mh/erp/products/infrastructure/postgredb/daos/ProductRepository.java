package com.mh.erp.products.infrastructure.postgredb.daos;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mh.erp.products.infrastructure.postgredb.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	@Query(value = "SELECT tb_product_id as productId, code, name FROM tb_product WHERE is_deleted = 0 ORDER BY RANDOM() LIMIT :limit ")
	Stream<ProductEntity> findAll(int limit);
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 and code = :code")
	Optional<ProductEntity> findByCode(String code);
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 and tb_product_id = :productId")
	Optional<ProductEntity> findById(Long productId);
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 and code = :code and tb_product_id <> :productId")
	Stream<ProductEntity> findByCodeAndProductIdNot(String code, Long productId);

	@Modifying
	@Query("UPDATE tb_product set is_deleted = 1 WHERE tb_product_id = :productId ")
	Stream<Void> logicallyDelete(Long productId);
	
} 
