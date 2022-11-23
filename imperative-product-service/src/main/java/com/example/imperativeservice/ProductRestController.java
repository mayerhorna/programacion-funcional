package com.example.imperativeservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductRestController {

	@Autowired
    private ProductRepository productRepository;

    @RequestMapping("/products")
    public List<Product> findProducts(@RequestParam int limit) {
    /*	List<Product> products = productRepository.findProducts(limit);
    	for (Product product : products) {
    		encryptCode(product);
		}
    	return products;
    	
    	*/
    	return productRepository.findProducts(limit)
    			.stream()
    				.map( product -> {
    			        String encriptedCode = new BCryptPasswordEncoder().encode(product.getCode());
    			        product.setEncriptedCode(encriptedCode);
    			        return product;
    			    })
    				.collect(Collectors.toList());
    	
    }

    private Product encryptCode(Product product) {
        String encriptedCode = new BCryptPasswordEncoder().encode(product.getCode());
        product.setEncriptedCode(encriptedCode);
        return product;
    }
}
