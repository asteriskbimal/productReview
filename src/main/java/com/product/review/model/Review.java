package com.product.review.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "review_id")
	private Long reviewId;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	private SystemUser user;
	
	@Min(value=0)
	@Max(value=5)
	private int rating;
	private String comment;
	
	@Temporal(TemporalType.DATE)
	private Date reviewDate;
	
	@ManyToOne
	private ProductModel productModel;

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	public SystemUser getUser() {
		return user;
	}

	public void setUser(SystemUser user) {
		this.user = user;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

}
