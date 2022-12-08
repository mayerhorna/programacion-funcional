package com.mh.erp.products.infrastructure.postgredb.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.mh.erp.products.domain.model.Product;
import com.mh.erp.products.infrastructure.api.dtos.ProductIdAndNameDto;
import com.mh.erp.products.infrastructure.api.dtos.ProductSummaryDto;

@Entity
@Table(name = "tb_product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROD_SEQ")
	@SequenceGenerator(name="PROD_SEQ", sequenceName="seq_tb_product", allocationSize=1)
	@Column(name = "tb_product_id")
    private Long productId;
    private String code;
    private String name;
    
    @Column(name = "is_active")
    private Integer isActive = 1;
    
    @Column(name = "sales_price")
    private BigDecimal salesPrice = BigDecimal.ZERO;
    
    @Column(name = "sales_price_with_tax")
    private BigDecimal salesPriceWithTax = BigDecimal.ZERO;
    
    @Column(name = "ean")
    private String ean;
    
    @Column(name = "can_be_sold")
    private Integer canBeSold = 1;
    
    @Column(name = "is_deleted")
    private Integer isDeleted = 0;
    
    @Column(name = "product_location")
    private String productLocation;
    
    @Column(name = "created")
    private LocalDateTime created;
    
    @Column(name = "updated")
    private LocalDateTime updated;
    
    public ProductEntity() {
    	
	}
    
    public ProductEntity(Long productId) {
    	this.productId = productId;
	}
    
    public ProductEntity(Product product) {
     	BeanUtils.copyProperties(product, this);
    }

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public BigDecimal getSalesPriceWithTax() {
		return salesPriceWithTax;
	}

	public void setSalesPriceWithTax(BigDecimal salesPriceWithTax) {
		this.salesPriceWithTax = salesPriceWithTax;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public Integer getCanBeSold() {
		return canBeSold;
	}

	public void setCanBeSold(Integer canBeSold) {
		this.canBeSold = canBeSold;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getProductLocation() {
		return productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	
	public LocalDateTime getUpdated() {
		return updated;
	}
	
	public Product toProduct() {
    	 Product product = new Product();
         BeanUtils.copyProperties(this, product);
         return product;
	}
	 
	public ProductSummaryDto toProductSummayDto() {
		ProductSummaryDto productSummaryDto = new ProductSummaryDto();
        BeanUtils.copyProperties(this, productSummaryDto);
        return productSummaryDto;
	}
	
	public ProductIdAndNameDto toProductIdAndNameDto() {
		ProductIdAndNameDto ProductIdAndNameDto = new ProductIdAndNameDto();
        BeanUtils.copyProperties(this, ProductIdAndNameDto);
        return ProductIdAndNameDto;
	}
	
}
