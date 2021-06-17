package com.capgemini.hibernateonetooneexample.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.capgemini.hibernateonetooneexample.entity.Instructor;
import com.capgemini.hibernateonetooneexample.entity.InstructorDetail;
import com.capgemini.hibernateonetooneexample.util.HibernateUtil;

public class InstructorDetailDao {

	//inserting the instructor detail into InstructorDetail table
			public void SaveInstructorDetail(InstructorDetail instructorDetail) {
				Transaction transaction = null;
				try {
					Session session = HibernateUtil.getSessionFactory().openSession();
					//start transaction
					transaction = session.beginTransaction();
					//save the instructor object
					session.save(instructorDetail);
					//commit the transaction
					transaction.commit();
				}catch (Exception e) {
					if(transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
				}
			}
			
			//updating the instructor detail in InstructorDetail table
			public void updateInstructorDetail(InstructorDetail instructorDetail) {
				Transaction transaction = null;
				try {
					Session session = HibernateUtil.getSessionFactory().openSession();
					//start transaction
					transaction = session.beginTransaction();
					//updating the instructor object
					session.saveOrUpdate(instructorDetail);
					//commit the transaction
					transaction.commit();
				}catch (Exception e) {
					if(transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
				}
			}
			
			//deleting the instructor detail from InstructorDetail table
			public void deleteInstructorDetail(int id) {
				Transaction transaction = null;
				try {
					Session session = HibernateUtil.getSessionFactory().openSession();
					//start transaction
					transaction = session.beginTransaction();
					//get instructor using id
					InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
					//delete the instructor object
					session.delete(instructorDetail);
					//commit the transaction
					transaction.commit();
				}catch (Exception e) {
					if(transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
				}
			}
			
			//displaying the instructor detail from InstructorDetail table
			public InstructorDetail getInstructorDetail(int id) {
				Transaction transaction = null;
				InstructorDetail instructorDetail = null;
				try {
					Session session = HibernateUtil.getSessionFactory().openSession();
					//start transaction
					transaction = session.beginTransaction();
					//get instructor using id
					instructorDetail = session.get(InstructorDetail.class, id);
					//commit the transaction
					transaction.commit();
				}catch (Exception e) {
					if(transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
				}
				return instructorDetail;
			}
			
			//displaying all the instructor detail from InstructorDetail table
			public List<InstructorDetail> getAllInstructorsDetail(){
				List<InstructorDetail> instructorDetails = null;
				try {
					Session session = HibernateUtil.getSessionFactory().openSession();
					instructorDetails = session.createQuery("from InstructorDetail", InstructorDetail.class).list();
					instructorDetails.forEach(instr -> System.out.println(instr.getHobby()));
				}catch (Exception e) {
					e.printStackTrace();
				}
				return instructorDetails;
			}
	
}
