package com.app.service;

import java.util.List;

import javax.transaction.SystemException;
import com.app.model.Customer;

/**
 *
 * @author:Mina CustomerService is a service Bean component
 */
public interface CustomerService {

	public void saveCust(Customer person) throws SystemException;

	public List<Customer> getAllCust() throws SystemException;

	public Customer getCustById(String id) throws SystemException;

	public void deleteCust(Customer person) throws SystemException;

}
