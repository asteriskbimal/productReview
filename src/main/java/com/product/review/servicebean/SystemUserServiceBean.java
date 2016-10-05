package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.SystemUser;
import com.product.review.service.SystemUserService;

@Service
@Transactional
public class SystemUserServiceBean implements SystemUserService {

	@Autowired
	private IGenericDAO<SystemUser> genericDAOImpl;

	public Collection<SystemUser> findAll() {
		Collection<SystemUser> s=genericDAOImpl.findAll(SystemUser.class);
		return s;
	}

	public SystemUser findOne(Long id) {
		return genericDAOImpl.findOne(SystemUser.class,id);
	}

	public Long create(SystemUser systemUser) {

		if (systemUser.getSystemUserId() != null) {
			return null;
		}
		return genericDAOImpl.create(systemUser);
	}

	public void update(SystemUser systemUser) {
		
		SystemUser add = genericDAOImpl.findOne(SystemUser.class,systemUser.getSystemUserId());
		if (add == null) {
			System.out.println("Cannot update new record");
		}
		add.setSystemUserId(systemUser.getSystemUserId());
		add.setUserName(systemUser.getUserName());
		add.setLastName(systemUser.getLastName());
		add.setFirstName(systemUser.getFirstName());
		add.getAddress().setAddressId(systemUser.getAddress().getAddressId());
		add.getAddress().setApartment(systemUser.getAddress().getApartment());
		add.getAddress().setCity(systemUser.getAddress().getCity());
		add.getAddress().setCountry(systemUser.getAddress().getCountry());
		add.getAddress().setZip(systemUser.getAddress().getZip());
		add.getAddress().setState(systemUser.getAddress().getState());
		add.getAddress().setDescr(systemUser.getAddress().getDescr());
		//genericDAOImpl.update(systemUser);
	}

	public void delete(SystemUser systemUser) {
		genericDAOImpl.delete(systemUser);
	}

}
