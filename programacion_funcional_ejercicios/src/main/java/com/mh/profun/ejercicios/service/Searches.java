package com.mh.profun.ejercicios.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;

import com.mh.profun.ejercicios.db.UsersDatabase;
import com.mh.profun.ejercicios.domain.Role;
import com.mh.profun.ejercicios.domain.User;

public class Searches {
	
	/**
	 * Obtiene El apellido(surname) por nombre de usuario. Sin repetir resultado(distinct)
	 * */
    public Stream<String> findUserSurnameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getSurname)
                .distinct();
    }

    /**
	 * Obtiene los nombres de roles por usuario
	 * */
    public Stream<String> findRolesByUserName(String userName) {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> userName.equals(user.getName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> { 
                	return user.getRoles().stream();
                	})
                .map(Role::getName);
    }
    
    /**
   	 * Obtiene todos los roles de todos los usuarios presentes(activos). Sin repetir resultado(distinct) 
   	 * */
    public Stream<String> findAllRolesOfAllPresentUsers() {
    	return Stream.empty();
    }

    /**
	 * Obtiene cantidad de usuarios por un rol
	 * */
    public Long findUsersCountByRole(String roleNameToLook) {
        return 0L;
    }

    /**
   	 * Obtiene el primer rol por id de usuario
   	 * */
    public Optional<Role> findFirstRoleByUserId(String userId) {
        return Optional.empty();
    }

    /**
   	 * Obtiene el rol mas bajo en peso por Nombre de usuario
   	 * */
    public Optional<Role> findLowestRoleByUserId(String userId) {
    	return Optional.empty();
    }

    /**
   	 * Obtiene el rol mas alto en peso por id de usuario
   	 * */
    public Optional<Role> findHighestRoleByUserId(String userId) {
    	return Optional.empty();
    }

    
}
