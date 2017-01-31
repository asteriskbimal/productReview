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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
    private Long productId;

    private String productName;
    
    public String description;
    
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="categoryId")
    public Category category; 
    
    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@JsonIgnore
	@OneToMany(mappedBy="product",cascade=CascadeType.PERSIST)
    private List<ProductModel> productModel=new ArrayList<ProductModel>();
    
	@JsonIgnore
    @ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="productId")
    private ProductBrand productBrand;
    
    public List<ProductModel> getProductModel() {
		return productModel;
	}

	public void setProductModel(List<ProductModel> productModel) {
		this.productModel = productModel;
	}

	public ProductBrand getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(ProductBrand productBrand) {
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