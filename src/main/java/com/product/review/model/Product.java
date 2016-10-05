package com.product.review.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
    private Long productId;

    private String productName;
    
    public String description;
    
    @OneToMany(mappedBy="product",cascade=CascadeType.PERSIST)
    private List<ProductModel> productModel=new ArrayList<ProductModel>();
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="product_brand",
    joinColumns=@JoinColumn(name="productId"),
    inverseJoinColumns=@JoinColumn(name="brandId"))
    private List<ProductBrand> productBrand=new ArrayList<ProductBrand>();
    
    public List<ProductModel> getProductModel() {
		return productModel;
	}

	public void setProductModel(List<ProductModel> productModel) {
		this.productModel = productModel;
	}

	public List<ProductBrand> getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(List<ProductBrand> productBrand) {
		this.productBrand = productBrand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}