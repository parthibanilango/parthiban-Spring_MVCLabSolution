/**
 * 
 */
package com.gl.studentapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.studentapp.model.Student;

/**
 * @author Parthiban Ilango
 *
 */

@Repository
public class StudentServiceImpl implements StudentService {
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory ) {
	    this.sessionFactory = sessionFactory;
		
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			this.session = this.sessionFactory.openSession();
		}
	}

	/* (non-Javadoc)
	 * @see com.gl.student.debate.service.StudentService#findAll()
	 */
	@Transactional
	public List<Student> findAll() {
		Transaction tx = session.beginTransaction();
		List<Student> students = session.createQuery( "from Student", Student.class ).list(); // find all the records from the database table
		tx.commit();
		return students;
	}

	/* (non-Javadoc)
	 * @see com.gl.student.debate.service.StudentService#findById(int)
	 */
	@Transactional
	public Student findById(int theId) {
		Student student = new Student();
		Transaction tx = session.beginTransaction();
		student = session.get(Student.class, theId);
		tx.commit();
		return student;
	}

	/* (non-Javadoc)
	 * @see com.gl.student.debate.service.StudentService#save(com.gl.student.debate.model.Student)
	 */
	@Transactional
	public void save(Student theStudent) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(theStudent);
		tx.commit();
		
	}

	/* (non-Javadoc)
	 * @see com.gl.student.debate.service.StudentService#deleteById(int)
	 */
	public void deleteById(int theId) {
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, theId);
		session.delete(student);
		tx.commit();
		
	}

	
	
}
