package com.mh.erp.products.domain.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;

@Repository
public interface ProductPersistence {
	List<Product> findAll(int limit);

	Product create(Product product);
	
	Product read(Long productId);

	Product update(Product product);

	ProductIdAndNameDto delete(Long productId);

	Product updateEan(Long productId, String ean);

	Product findByEanOrCode(String ean);
}
