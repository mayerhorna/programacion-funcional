package com.mh.erp.products.infrastructure.postgredb.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mh.erp.products.infrastructure.postgredb.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	@Query(value = "SELECT * FROM tb_product WHERE is_deleted = 0 ORDER BY RANDOM() LIMIT :limit ", nativeQuery = true)
	List<ProductEntity> findAll(@Param("limit") int limit);
	
	@Modifying
	@Query(value = "UPDATE tb_product set is_deleted = 1 WHERE tb_product_id = :productId " , nativeQuery = true)
	Integer logicallyDelete(@Param("productId") Long productId);

	boolean existsByCodeIgnoreCaseAndIsDeletedAndProductIdNot(String code, Integer isDeleted, Long productId);
	
	boolean existsByEanIgnoreCaseAndIsDeletedAndProductIdNot(String code, Integer isDeleted, Long productId);
	
	boolean existsByProductIdAndIsDeleted(Long productId, Integer isDeleted);

	boolean existsByCodeIgnoreCaseAndIsDeleted(String code, Integer isDeleted);
	
	boolean existsByEanIgnoreCaseAndIsDeleted(String code, Integer isDeleted);

	@Query(name = "ProductEntity.findByEanOrCode"  )
	ProductEntity findByEanOrCode(@Param("ean") String ean);
	
} 
