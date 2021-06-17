package com.capgemini.hibernatehandsonpractice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.capgemini.hibernatehandsonpractice.entity.Customers;
import com.capgemini.hibernatehandsonpractice.util.HibernateUtil;

public class CustomersDao {

	// INSERT OPERATION ON CUSTOMERS TABLE
	public void saveCustomer(Customers customers) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start transaction
			transaction = session.beginTransaction();
			// save the instructor object
			session.save(customers);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// UPDATE OPERATION ON CUSTOMERS TABLE
	public void updateCustomer(Customers customers) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start transaction
			transaction = session.beginTransaction();
			// save the instructor object
			session.saveOrUpdate(customers);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// DELETE OPERATION ON CUSTOMERS TABLE
	public void deleteCustomer(int id) {
		Transaction transaction = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start transaction
			transaction = session.beginTransaction();
			// get instructor using id
			Customers customers = session.get(Customers.class, id);
			// delete the instructor object
			session.delete(customers);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	// DISPLAY OPERATION BY USING ID
	public Customers getCustomer(int id) {
		Transaction transaction = null;
		Customers customers = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// start transaction
			transaction = session.beginTransaction();
			// get instructor using id
			customers = session.get(Customers.class, id);
			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return customers;
	}

	// DISPLAYING ALL CUSTOMERS
	public List<Customers> getAllCustomers() {
		List<Customers> customers = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			customers = session.createQuery("from Instructor", Customers.class).list();
			customers.forEach(cust -> System.out.println(cust.getCustName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
}
