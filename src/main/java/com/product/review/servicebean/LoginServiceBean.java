package com.product.review.servicebean;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.Login;
import com.product.review.service.LoginService;

@Service
@Transactional
public class LoginServiceBean implements LoginService {

	@Autowired
	private IGenericDAO<Login> genericDAOImpl;


	public Collection<Login> findAll() {

		return genericDAOImpl.findAll(Login.class);
	}


	public Login findOne(Long id) {

		return genericDAOImpl.findOne(Login.class,id);
	}


	public Long create(Login login) {

		if (login.getSystemId() != null) {
			return null;
		}
		return genericDAOImpl.create(login);
	}

	public void update(Login login) {
		Login add = genericDAOImpl.findOne(Login.class,login.getSystemId());
		if (add == null) {
		
		}
		genericDAOImpl.update(login);
	}


	public void delete(Login login) {
		genericDAOImpl.delete(login);

	}

}
