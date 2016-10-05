package com.product.review.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ProductItem extends ProductModel {

	private Double price;
	
	@Enumerated
	private ProductType productType;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="review_id")
	private List<Review> reviews=new ArrayList<Review>();

	
	public List<Review> getReview() {
		return reviews;
	}

	public void setReview(List<Review> reviews) {
		this.reviews = reviews;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

}
