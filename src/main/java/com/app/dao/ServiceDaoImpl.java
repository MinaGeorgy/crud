package com.app.dao;

import java.util.List;

import javax.transaction.SystemException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @auther Mina.Georgy
 */
@Repository("serviceDao")
public class ServiceDaoImpl implements ServiceDao{
	
	private SessionFactory sessionFactory;
	 
	private ServiceDao serviceDao;

	@Autowired
	public void setSessionFactory(SessionFactory factory){
		sessionFactory=factory;
	}

	public void save(Object t) throws SystemException {
		try {
			sessionFactory.getCurrentSession().merge(t);
		} catch (Exception e) {
			throw new SystemException("Saving Operation Failed");
		}
		
	}

	public List<Object> findAll(Class clazz) throws SystemException {
		List<Object> result=null;
		try {
			 sessionFactory.getCurrentSession().createCriteria(clazz).list();
		} catch (Exception e) {
			throw new SystemException("Finding Operation Failed");
		}
		return result;
	}

	public Object findById(long id,Class clazz)  {
		return  sessionFactory.getCurrentSession().get(clazz, id);
	}

	public void delete(Object t) throws SystemException {
		
		try {
			sessionFactory.getCurrentSession().delete(t);
		} catch (Exception e) {
			throw new SystemException("Deleting Operation Failed");
		}		
	}

	
	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}


}
