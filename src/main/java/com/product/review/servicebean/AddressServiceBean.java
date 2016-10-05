package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.Address;
import com.product.review.service.AddressService;

@Service
@Transactional
public class AddressServiceBean implements AddressService {

	@Autowired
	private IGenericDAO<Address> genericDAOImpl;

	
	public Collection<Address> findAll() {
		return genericDAOImpl.findAll(Address.class);
	}


	public Address findOne(Long id) {
		return genericDAOImpl.findOne(Address.class,id);
	}

	public Long create(Address address) {

		if (address.getAddressId() != null) {
			return null;
		}
		return genericDAOImpl.create(address);
	}


	public void update(Address address) {
		Address add = genericDAOImpl.findOne(Address.class,address.getAddressId());
		if (add == null) {
			System.out.println("Cannot update new record");
		}
		genericDAOImpl.update(address);
	}


	public void delete(Address address) {
		genericDAOImpl.delete(address);

	}

}
