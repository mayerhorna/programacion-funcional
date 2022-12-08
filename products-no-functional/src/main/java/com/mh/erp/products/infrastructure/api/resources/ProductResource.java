package com.mh.erp.products.infrastructure.api.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.domain.services.ProductService;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;

@RestController
@RequestMapping(ProductResource.PRODUCTS)
public class ProductResource {
	public static final String PRODUCTS = "/products";
	public static final String PRODUCT_ID = "/{productId}";
	public static final String SEARCH = "/search";
	public static final String EAN = "/ean";
    private ProductService productService;
    
	public ProductResource(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(SEARCH)
    public List<Product> findAll(@RequestParam int limit) {
		List<Product> products = 
    			productService.findAll(limit);
    	return products;
    } 
    
    @PostMapping
	public Product create(@Valid @RequestBody Product product) {
        product.doDefault();
        return this.productService.create(product);
    }
    
    @PutMapping(PRODUCT_ID)
   	public Product update(@PathVariable Long productId, @Valid @RequestBody Product product) {
       return this.productService.update(productId, product);
    }
    
    @PatchMapping(value = PRODUCT_ID + EAN)
   	public Product updateEan(@PathVariable Long productId, @RequestParam String ean) {
       return this.productService.updateEan(productId, ean);
    }

    @GetMapping(PRODUCT_ID)
    public Product read(@PathVariable Long productId) {
        return this.productService.read(productId);
    }
    
    @DeleteMapping(PRODUCT_ID)
    public ProductIdAndNameDto delete(@PathVariable Long productId) {
        return this.productService.delete(productId);
    }
    
    @GetMapping(EAN)
    public Product findByEanOrCode(@RequestParam(required = false) String ean) {
        return this.productService.findByEanOrCode(ean);
    }
}
