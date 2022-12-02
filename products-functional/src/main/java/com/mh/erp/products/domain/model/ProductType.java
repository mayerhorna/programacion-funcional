package com.mh.erp.products.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductType {
    private Long productTypeId;

    private String code;
    
    private String name;
    
    public ProductType() {
	}
	
	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(((ProductType)obj).getProductTypeId().equals(this.getProductTypeId())){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return productTypeId.intValue();
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
}