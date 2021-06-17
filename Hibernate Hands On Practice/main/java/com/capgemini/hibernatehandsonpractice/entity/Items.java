package com.capgemini.hibernatehandsonpractice.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Items {

	@Id
	@SequenceGenerator(name = "itemSeqGen",sequenceName = "itemSeq",initialValue = 201,allocationSize = 100)
	@GeneratedValue(generator = "itemSeqGen")
	@Column(name = "item_id")
	private Integer id;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_description")
	private String itemDesc;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="items_orders",
					joinColumns = {
							@JoinColumn(name ="item_id")
					},
						inverseJoinColumns = {
								@JoinColumn(name = "order_id")
						}
			)
	private Set<Orders> orders = new HashSet<Orders>();

	public Items() {
		super();
	}

	public Items(String itemName, String itemDesc) {
		super();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	
}
