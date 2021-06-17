package com.capgemini.hibernatehandsonpractice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Customers {

	@Id
	@SequenceGenerator(name = "custSeqGen",sequenceName = "custSeq",initialValue = 101,allocationSize = 100)
	@GeneratedValue(generator = "custSeqGen")
	@Column(name = "customer_id")
	private Integer id;
	
	@Column(name = "customer_name")
	private String custName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_address_id")
	private Addresses address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Orders> ordList=new ArrayList<Orders>();

	public Customers() {
		super();
	}

	public Customers(String custName) {
		super();
		this.custName = custName;
		//this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Addresses getAddress() {
		return address;
	}

	public void setAddress(Addresses address) {
		this.address = address;
	}

	public List<Orders> getOrdList() {
		return ordList;
	}

	public void setOrdList(List<Orders> ordList) {
		this.ordList = ordList;
	}
	
	

}
