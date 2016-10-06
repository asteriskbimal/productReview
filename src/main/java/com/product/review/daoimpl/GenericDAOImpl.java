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

@Repository
public class GenericDAOImpl<T> implements IGenericDAO<T>{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public  Collection<T> findAll( Class<T> type){
			//sessionFactory.openSession();
		    //sessionFactory.getCurrentSession().getTransaction().begin();
			CriteriaQuery<T> query = (CriteriaQuery<T>) this.sessionFactory
		    									.getCurrentSession()
		    									.getCriteriaBuilder()
		    									.createQuery(type);
		   
		    query.select((Selection<T>) query.from(type));  
		    Query q = this.sessionFactory.getCurrentSession().createQuery(query);  
			@SuppressWarnings("unchecked")
			Collection<T> t=q.getResultList(); 
		   	//sessionFactory.getCurrentSession().getTransaction().commit();
			//sessionFactory.getCurrentSession().close();
			return t;
	       
	}
	
	public T findOne( Class<T> type,Long id) {
		Session session =sessionFactory.getCurrentSession();
		//session.getTransaction().begin();
		T t = (T) session.get(type, id);
		//session.getTransaction().commit();
		//session.close();
		return t;
	}


	public Long create(T t) {
		Session session =sessionFactory.getCurrentSession();
		//session.getTransaction().begin();
		Long check=(Long) session.save(t);
		//session.getTransaction().commit();
		//session.close();
		return check;
		
	}

	public void update(T t) {
		Session session =sessionFactory.getCurrentSession();
		//session.getTransaction().begin();
		session.update(t);
		//session.getTransaction().commit();
		//session.close();
	}

	public void delete(T t) {
		Session session =sessionFactory.getCurrentSession();
		//session.getTransaction().begin();
		session.delete(t);
		//session.getTransaction().commit();
		//session.close();
		
	}

	

	
}
