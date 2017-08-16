package com.app.bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.service.CustomerService;

/**
 *
 * @author: Mina 
 * CustomerBean is View Scope CRUD Bean
 */
@Component
@ViewScoped
public class CustomerBean {

	private static Logger logger = Logger.getLogger("CustomerBean.class");

	private Customer cust;

	@Autowired
	private CustomerService manager;

	private boolean showCreatePanel = false;

	public CustomerBean() {
	}

	/**
	 * @return String <b> save customer </b>
	 */
	public String saveCust() {
		try {
			logger.log(Level.FINE, "Begin Saving Object ");
			manager.saveCust(cust);
			logger.log(Level.FINE, "Ending Saving Object ");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception While Saving Object ");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));

		}
		return "pretty:home";
	}

	/**
	 * @return void <b> delete customer </b>
	 */
	public void deleteCust() {
		try {
			logger.log(Level.FINE, "Begin Deleting Object ");
			manager.deleteCust(cust);
			logger.log(Level.FINE, "Ending Deleting Object ");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception While Deleting Object with error  " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));

		}
	}

	/**
	 * @return String <b> edit customer </b>
	 */
	public String editCust() {
		try {

			logger.log(Level.FINE, "Begin Editing Object ");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception While Editing Object with error  " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));

		}
		return "pretty:home";
	}

	/**
	 * @return String <b> initiate new customer and return back to home.jsf</b>
	 */
	public String newCust() {
		reinit();
		showCreatePanel = true;
		return "pretty:home";
	}

	/**
	 * @return void <b> initiate new customer </b>
	 */
	public void reinit() {
		cust = new Customer();
	}

	/**
	 * @return void <b> retrieve all customers </b>
	 */
	public List<Customer> getAllCust() {

		List<Customer> custs = null;
		try {
			manager.getAllCust();
		} catch (SystemException e) {
			logger.log(Level.SEVERE, "Exception While Editing Object with error  " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return custs;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public CustomerService getManager() {
		return manager;
	}

	public void setManager(CustomerService manager) {
		this.manager = manager;
	}

	public boolean isShowCreatePanel() {
		return showCreatePanel;
	}

	public void setShowCreatePanel(boolean showCreatePanel) {
		this.showCreatePanel = showCreatePanel;
	}

}
