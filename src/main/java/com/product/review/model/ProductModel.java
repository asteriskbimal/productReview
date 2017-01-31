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
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "model_id")
    private Long productmodelId;

    private String model;
   
    @JsonIgnore
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="feature_id")
    private List<Feature> features=new ArrayList<Feature>();
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="productId")
    private Product product;
    
    @JsonIgnore
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="item_id")
    private List<ProductItem> productItems=new ArrayList<ProductItem>();
    
	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getProductmodelId() {
		return productmodelId;
	}

	public void setProductmodelId(long productmodelId) {
		this.productmodelId = productmodelId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}