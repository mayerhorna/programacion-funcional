package com.mh.profun.ejercicios.db;

import java.util.List;
import java.util.stream.Stream;

import com.mh.profun.ejercicios.domain.Role;
import com.mh.profun.ejercicios.domain.User;

/**
 * ROLES 	    | ID | PESO O RELEVANCIA:
 * ADMIN  		| 1	 |  100
 * SALES  		| 2  |   80
 * PURCHASE 	| 3  |   50
 * WAREHOUSE 	| 4  |   30
 * */

public class UsersDatabase {

    public Stream<User> findAll() {

        List<Role> roles1 = List.of(
                new Role(1, "ADMIN", 100),
                new Role(2, "SALES" , 80),
                new Role(3, "PURCHASE" , 50),
                new Role(4, "WAREHOUSE" , 30)
        );
        List<Role> roles2 = List.of(
        		new Role(2, "SALES" , 80),
                new Role(3, "PURCHASE" , 50),
                new Role(4, "WAREHOUSE" , 30)
        );
        
        List<Role> roles3 = List.of(
        		new Role(3, "PURCHASE" , 50),
                new Role(4, "WAREHOUSE" , 30)
        );
         
        List<Role> roles4 = List.of(
        		 new Role(2, "SALES" , 80),
        		 new Role(3, "PURCHASE" , 50)
        );

        return Stream.of(
                new User("1", "Admin", "SuperAdmin", roles1),
                new User("2", "Ana", "Blanco", roles1),
                new User("3", "Oscar", "López", roles2),
                new User("4", "Paula", "Torres", roles2),
                new User("5", "Antonio", "Blanco", roles3),
                new User("6", "Maria", "Torres", roles4)
        );
    }
}
