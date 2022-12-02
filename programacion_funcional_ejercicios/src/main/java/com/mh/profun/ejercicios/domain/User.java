package com.mh.profun.ejercicios.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;

    private String name;

    private String surname;

    private List<Role> roles;

    public User() {
        this.roles = new ArrayList<>();
    }

    public User(String id, String name, String surname, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public String fullName() {
        return this.name + " " + this.surname;
    }

    public String initials() {
        return this.name.substring(0, 1) + ".";
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", roles=" + roles +
                '}';
    }
}
