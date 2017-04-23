package com.product.review.daoimpl;

import java.util.Collection;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Selection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.review.dao.IGenericDAO;
import com.product.review.model.Product;

@Repository
public class GenericDAOImpl<T> implements IGenericDAO<T>{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public  Collection<T> findAll( Class<T> type){
		
			CriteriaQuery<T> query = (CriteriaQuery<T>) this.sessionFactory
		    									.getCurrentSession()
		    									.getCriteriaBuilder()
		    									.createQuery(type);
		   
		    query.select((Selection<T>) query.from(type));  
		    Query q = this.sessionFactory.getCurrentSession().createQuery(query);  
			@SuppressWarnings("unchecked")
			Collection<T> t=q.getResultList(); 
			return t;
	       
	}
	
	public T findOne( Class<T> type,Long id) {
		Session session =sessionFactory.getCurrentSession();
		T t = (T) session.get(type, id);
		return t;
	}


	public Long create(T t) {
		Session session =sessionFactory.getCurrentSession();
		Long check=(Long) session.save(t);
		return check;
		
	}

	public void update(T t) {
		Session session =sessionFactory.getCurrentSession();
		session.update(t);
	}

	public void delete(T t) {
		Session session =sessionFactory.getCurrentSession();
		session.delete(t);
	}

	
	public Collection<T> findAllByTypeId(Class<T> type, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U> Collection<T> findAllByProduct(Class<T> type, Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
