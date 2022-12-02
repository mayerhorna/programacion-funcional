package com.mh.erp.products.infrastructure.postgredb.persistence;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.domain.persistence.ProductPersistence;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;
import com.mh.erp.products.infrastructure.postgredb.daos.ProductRepository;
import com.mh.erp.products.infrastructure.postgredb.entities.ProductEntity;


@Repository
public class ProductPersistencePostgredb implements ProductPersistence {
	
	private ProductRepository productRepository;
	
    public ProductPersistencePostgredb(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
    
    @Override
    public Stream<Product> findAll(int limit) {
    	return this.productRepository
    				.findAll(limit)
    				.map(ProductEntity::toProduct);
    }

	@Override
	public Optional<Product> create(Product product) {
		return Optional.empty();
	}

	@Override
	public Optional<Product> read(Long productId) {
		return Optional.empty();
	}

	@Override
	public Optional<Product> update(Product product) {
        return Optional.empty();
	}
	
	private Optional<ProductEntity> assertFindByCodeNot(String code) {
        return Optional.empty();
    }
	
	private Stream<Void> assertCodeNotExistInOthersProducts(String code, Long productId) {
        return Stream.empty();
    }
	
	@Override
	public Optional<ProductIdAndNameDto> delete(Long productId) {
		return Optional.empty();
	}
	
	@Override
	public Optional<Product> updateEan(Long productId, String ean) {
		return Optional.empty();
	}
}
