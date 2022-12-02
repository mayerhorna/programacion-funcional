package com.mh.profun.ejercicios.domain;
 
public class Role {

	private Integer id;

	private String name;
	
	private Integer weight; 
	
    public Role(Integer id, String name, Integer weight) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
