package com.product.review.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "model_id")
    private Long productmodelId;

    private String model;

    @Temporal(TemporalType.DATE)
    @Column(name = "mfg_date")
    private Date manufactureDate;
    
    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="feature_id")
    private List<Feature> features=new ArrayList<Feature>();
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="productId")
    private Product product;

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

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}



}