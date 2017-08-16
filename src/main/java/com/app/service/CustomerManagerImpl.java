package com.app.service;

import java.util.List;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ServiceDao;
import com.app.model.Customer;

/**
 *
 * @author:Mina CustomerManagerImpl is a service Bean component
 */

@Service
@Transactional
public class CustomerManagerImpl implements CustomerService {

	@Autowired
	private ServiceDao serviceDao;


	

	public void saveCust(Customer cust) throws SystemException {
		serviceDao.save(cust);

	}

	public List<Customer> getAllCust() throws SystemException {
		return (List<Customer>)((List<? extends Object>)serviceDao.findAll(Customer.class));
	}

	public Customer getCustById(String id) throws SystemException {
		return (Customer) serviceDao.findById(Long.valueOf(id), Customer.class);
	}

	
	public void deleteCust(Customer cust) throws SystemException {
		serviceDao.delete(cust);
	}


	

}
