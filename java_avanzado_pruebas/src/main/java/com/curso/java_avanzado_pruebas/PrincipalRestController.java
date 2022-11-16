package com.curso.java_avanzado_pruebas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalRestController {
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	String template = "Hello, %s!";
    	String message = String.format(template, name);
    	return new Greeting(1, message);
    }

}
