package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
	/**
	 * @auther Mina.Georgy
	 */
	private static final long serialVersionUID = 8496087166198616020L;
	private long id;
	private String name;
	private String age;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "age")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Customer == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final Customer cust = (Customer) obj;
		return new EqualsBuilder().append(name, cust.getName())
				.append(id, cust.getId()).append(age, cust.getAge())
				.isEquals();
	}

}
