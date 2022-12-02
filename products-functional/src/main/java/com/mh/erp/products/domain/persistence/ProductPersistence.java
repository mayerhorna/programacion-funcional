package com.mh.erp.products.domain.persistence;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;

@Repository
public interface ProductPersistence {
	Stream<Product> findAll(int limit);

	Optional<Product> create(Product product);
	
	Optional<Product> read(Long productId);

	Optional<Product> update(Product product);

	Optional<ProductIdAndNameDto> delete(Long productId);

	Optional<Product> updateEan(Long productId, String ean);
}
