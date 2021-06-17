package com.capgemini.hibernatehandsonpractice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Addresses {

	@Id
	@SequenceGenerator(name = "addrSeqGen",sequenceName = "addrSeq",initialValue = 301,allocationSize = 100)
	@GeneratedValue(generator = "addrSeqGen")
	@Column(name = "address_id")
	private Integer id;
	
	@Column(name = "address")
	private String addr;

	public Addresses() {
		super();
	}

	public Addresses(String addr) {
		super();
		this.addr = addr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
