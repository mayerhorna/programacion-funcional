package com.example.reactiveservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class ProductRestController {

	@Autowired
    private ProductRepository productRepository;
    
    @RequestMapping(value ="/products" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> findProducts(@RequestParam int limit) {
    	return productRepository
    			.findProducts(limit)
    			.doOnNext(p -> System.out.println(p.getCode()))
    			.map(this::encryptCode);
    }

    private Product encryptCode(Product product) {
        String encriptedCode = new BCryptPasswordEncoder().encode(product.getCode());
        product.setEncriptedCode(encriptedCode);
        return product;
    }
}
