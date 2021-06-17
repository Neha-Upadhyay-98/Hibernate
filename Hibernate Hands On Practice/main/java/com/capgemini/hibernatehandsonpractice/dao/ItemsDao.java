package com.capgemini.hibernatehandsonpractice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.capgemini.hibernatehandsonpractice.entity.Items;
import com.capgemini.hibernatehandsonpractice.util.HibernateUtil;

public class ItemsDao {
	
	// INSERT OPERATION ON CUSTOMERS TABLE
		public void saveItem(Items items) {
			Transaction transaction = null;
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				// start transaction
				transaction = session.beginTransaction();
				// save the instructor object
				session.save(items);
				// commit the transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}

}
