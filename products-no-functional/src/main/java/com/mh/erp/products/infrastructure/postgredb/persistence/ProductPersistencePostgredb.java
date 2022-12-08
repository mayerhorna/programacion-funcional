package com.mh.erp.products.infrastructure.postgredb.persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.mh.erp.products.domain.exceptions.ConflictException;
import com.mh.erp.products.domain.exceptions.NotFoundException;
import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.domain.persistence.ProductPersistence;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;
import com.mh.erp.products.infrastructure.postgredb.daos.ProductRepository;
import com.mh.erp.products.infrastructure.postgredb.entities.ProductEntity;
import com.mh.erp.products.infrastructure.postgredb.entities.metadata.IsDeleted;


@Repository
public class ProductPersistencePostgredb implements ProductPersistence {
	
	private ProductRepository productRepository;
	
    public ProductPersistencePostgredb(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
    
    @Override
    public List<Product> findAll(int limit) {
    	List<ProductEntity> list = this.productRepository.findAll(limit);
    	List<Product> listFinal = new ArrayList<>(); 
    	for (ProductEntity productEntity : list) {
    		listFinal.add(productEntity.toProduct());
		}
    	return listFinal;
    }

	@Override
	public Product create(Product product) {
		assertCodeNotExist(product.getCode());
		assertEanNotExist(product.getEan());
		ProductEntity productEntity = new ProductEntity(product);
		productRepository.save(productEntity);
		return productEntity.toProduct();
	}

	@Override
	public Product read(Long productId) {
		assertIdExist(productId);
		ProductEntity productEntity = productRepository.getReferenceById(productId);
		return productEntity.toProduct();
	}

	@Override
	public Product update(Product product) {
		assertCodeNotExistInOthersProducts(product.getCode(), product.getProductId());
		assertEanNotExistInOthersProducts(product.getEan(), product.getProductId());
		ProductEntity productEntity = productRepository.getReferenceById(product.getProductId());
		BeanUtils.copyProperties(product, productEntity, "created", "isDeleted");
    	productEntity.setUpdated(LocalDateTime.now());
		productRepository.save(productEntity);
        return productEntity.toProduct();
	}
	
	
	@Override
	public ProductIdAndNameDto delete(Long productId) {
		assertIdExist(productId);
		productRepository.logicallyDelete(productId);
		ProductEntity productEntity = productRepository.getReferenceById(productId);
		return productEntity.toProductIdAndNameDto();
	}
	
	@Override
	public Product updateEan(Long productId, String ean) {
		assertIdExist(productId);
		assertEanNotExistInOthersProducts(ean, productId);
		ProductEntity productEntity = productRepository.getReferenceById(productId);
		productEntity.setEan(ean);
		productRepository.save(productEntity);
		return productEntity.toProduct();
	}
	
	@Override
	public Product findByEanOrCode(String ean) {
		ProductEntity productsEntity = productRepository.findByEanOrCode(ean);
		if(productsEntity == null) {
			throw new ConflictException("El EAN del Producto no existe : " + ean);
		}
		return productsEntity.toProduct();
	}
	
	private void assertCodeNotExist(String code) {
		boolean existCode = productRepository.existsByCodeIgnoreCaseAndIsDeleted(code, IsDeleted.NO);
		if(existCode == true) {
			throw new ConflictException("El Codigo del Producto ya existe : " + code);
		}
    }
	
	private void assertEanNotExist(String ean) {
		if( ean == null) {
			return;
		}
		boolean exist = productRepository.existsByEanIgnoreCaseAndIsDeleted(ean, IsDeleted.NO);
		if(exist == true) {
			throw new ConflictException("El EAN del Producto ya existe : " + ean);
		}
    }
	
	
	private void assertCodeNotExistInOthersProducts(String code, Long productId) {
		boolean exist = productRepository.existsByCodeIgnoreCaseAndIsDeletedAndProductIdNot(code, IsDeleted.NO , productId);
		if(exist == true) {
			throw new ConflictException("El Codigo ya existe en otros producto: " + code);
		}
    }
	
	private void assertEanNotExistInOthersProducts(String code, Long productId) {
		boolean exist = productRepository.existsByEanIgnoreCaseAndIsDeletedAndProductIdNot(code, IsDeleted.NO , productId);
		if(exist == true) {
			throw new ConflictException("El Ean ya existe en otros productos: " + code);
		}
    }
	
	private void assertIdExist(Long productId) {
		boolean exist = productRepository.existsByProductIdAndIsDeleted(productId, IsDeleted.NO );
		if(exist == false) {
			throw new NotFoundException("No existe productId: " + productId);
		}
    }
}
