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
		
		genericDAOImpl.update(systemUser);
	}

	public void delete(SystemUser systemUser) {
		genericDAOImpl.delete(systemUser);
	}

}
