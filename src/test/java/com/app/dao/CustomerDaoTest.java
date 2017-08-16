package com.app.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.transaction.SystemException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.app.dao.ServiceDaoImpl;
import com.app.model.Customer;

/**
 *
 * @author:Mina CustomerDaoTest to test Dao layer
 */
public class CustomerDaoTest {
	static ServiceDaoImpl dao;
	static SessionFactory factory;
	static Session session;

	@BeforeClass
	public static void initClass() {
		dao = mock(ServiceDaoImpl.class);
		 
		factory = mock(SessionFactory.class);
		session = mock(Session.class);
		dao.setSessionFactory(factory);
	}

	@Before
	public void init() {
		reset(factory, session);
		when(factory.getCurrentSession()).thenReturn(session);
	}

	@Test
	public void testCreateDataKO() throws SystemException {
		// Setup
		Customer cust = new Customer();
		when(session.merge(cust)).thenReturn("5");
		assertEquals(session.merge(cust), "5");
		// Action
	}


	@Test
	public void testRetrieveDataOK() throws SystemException {
		// /Setup
		Criteria criteria = mock(Criteria.class);
		when(session.createCriteria(Customer.class)).thenReturn(criteria);
		List<Customer> persons = mock(List.class);
		when(criteria.list()).thenReturn(persons);
		// Action
		dao.findAll(Customer.class);
		// Test
		//verify(session, times(1)).createCriteria(Customer.class);
		//verify(criteria, times(1)).list();
	}
 
	public void testDeleteDataKO() throws SystemException {
		// Setup
		Customer input = new Customer();
		doThrow(new SystemException("")).when(session).delete(input);
		// Action
		dao.delete(input);
	}
}
