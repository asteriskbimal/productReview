package com.product.review.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private Long categoryId;

	@Column(name = "cat_name")
	private String categoryName;

//	@OneToMany(mappedBy = "cat", cascade = CascadeType.ALL)
//	private List<ProductBrand> productBrands = new ArrayList<ProductBrand>();
//
//	public List<ProductBrand> getProductBrands() {
//		return productBrands;
//	}
//
//	public void setProductBrands(List<ProductBrand> productBrands) {
//		this.productBrands = productBrands;
//	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}