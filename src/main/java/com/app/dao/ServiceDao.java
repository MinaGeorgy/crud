package com.app.dao;

import java.util.List;

import javax.transaction.SystemException;
/**
 * @auther Mina.Georgy
 */
public interface ServiceDao {
	public void save(Object t) throws SystemException;

	public List<Object> findAll(Class clazz) throws SystemException;

	public Object findById(long id,Class clazz)throws SystemException;

	public void delete(Object t)throws SystemException;
	

}
