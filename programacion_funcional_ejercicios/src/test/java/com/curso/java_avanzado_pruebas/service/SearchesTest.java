package com.curso.java_avanzado_pruebas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.mh.profun.ejercicios.domain.Role;
import com.mh.profun.ejercicios.service.Searches;

class SearchesTest {

    @Test
    void findUserSurnameByUserNameDistinct_Paula_Torres() {
        assertEquals(List.of("Torres"), new Searches().findUserSurnameByUserNameDistinct("Paula")
                .collect(Collectors.toList()));
    }
    
    @Test
    void findRolesByUserName_Maria_SALESandPURCHASE() {
        assertEquals(List.of("SALES","PURCHASE"), new Searches().findRolesByUserName("Maria")
                .collect(Collectors.toList()));
    }
    
    @Test
    void findAllRolesOfAllPresentUsers_0_ALL() {
    	assertEquals(List.of("ADMIN","SALES","PURCHASE","WAREHOUSE"), 
    			new Searches()
    				.findAllRolesOfAllPresentUsers()
    				.collect(Collectors.toList()));
    }
 
    @Test
    void findUserNamesByRole_SALES_5() {
        assertEquals(5, new Searches().findUsersCountByRole("SALES"));
    }
    
    @Test
    void findFirstRoleByUserId_3_SALES() {
    	assertEquals("SALES", new Searches().findFirstRoleByUserId("3").get().getName());
    }
    
    @Test
    void findLowestRoleByUserId_5_WAREHOUSE() {
    	assertEquals("WAREHOUSE", new Searches().findLowestRoleByUserId("5").get().getName());
    }
    
    @Test
    void findHighestRoleByUserId_3_SALES() {
    	assertEquals("SALES", new Searches().findHighestRoleByUserId("3").get().getName());
    }
    
}
