package com.capgemini.hibernatehandsonpractice.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class Orders {

	@Id
	@SequenceGenerator(name = "ordSeqGen",sequenceName = "ordSeq",initialValue = 555,allocationSize = 100)
	@GeneratedValue(generator = "ordSeqGen")
	@Column(name = "order_id")
	private Integer id;
	

	
	@Column(name = "order_date")
	private LocalDate ordDate;
	
	@Column(name = "amount")
	private Double amt;
	
	@ManyToMany(mappedBy = "orders" ,cascade = {CascadeType.ALL})
	private Set<Items> items = new HashSet<Items>();

	public Orders() {
		super();
	}

	public Orders(LocalDate ordDate, Double amt) {
		super();
		//this.custList = custList;
		this.ordDate = ordDate;
		this.amt = amt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(LocalDate ordDate) {
		this.ordDate = ordDate;
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}
	
	
}
