/**
 * 
 */
package com.gl.studentapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.studentapp.model.Student;

/**
 * @author Parthiban Ilango
 *
 */
@Service
public interface StudentService {
	public List<Student> findAll();
	public Student findById( int theId );
	public void save( Student theStudent );
	public void deleteById( int theId );
	

}
